package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.AuthenticationCredentials;
import co.gldconsulting.siigo.model.DocumentKind;
import co.gldconsulting.siigo.service.accounting.JournalsFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.Interceptor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import static org.junit.jupiter.api.Assertions.*;

/** Compares SDK queries with identical direct JDK HTTP requests; remote filter behavior is diagnostic. */
@EnabledIfEnvironmentVariable(named = "SIIGO_JOURNAL_FILTER_CONTRACT_TEST", matches = "true")
class JournalFilterContractLiveIT {
    @Test void comparesSdkEncodingAndDirectHttpWithoutAssumingRemoteFilterSupport() throws Exception {
        String partner = required("SIIGO_PARTNER_ID");
        var credentials = new AuthenticationCredentials().setUsername(required("SIIGO_USERNAME"))
                .setAccessKey(required("SIIGO_ACCESS_KEY"));
        AtomicReference<okhttp3.HttpUrl> observed = new AtomicReference<>();
        Interceptor observer = chain -> {
            ThreadSleep.pause();
            var response = chain.proceed(chain.request());
            if (response.request().url().encodedPath().equals("/v1/journals")) observed.set(response.request().url());
            return response;
        };
        var config = CommunicationConfig.builder().setPartnerId(partner).setInterceptors(List.of(observer));
        var mapper = new ObjectMapper();
        List<Map<String, Object>> results = new ArrayList<>();
        try (SiigoApi api = SiigoApi.builder().withCommunicationConfig(config).setCredentials(credentials).build();
             HttpClient raw = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(15)).followRedirects(HttpClient.Redirect.NEVER).build()) {
            String token = api.getAuthenticationService().authenticate(credentials).getAccessToken();
            var types = api.getCatalogService().getDocumentTypes(DocumentKind.CC);
            assertTrue(types.stream().anyMatch(d -> Long.valueOf(9140).equals(d.getId())), "Known document type must exist in this account");
            Map<String, JournalsFilter> cases = new LinkedHashMap<>();
            cases.put("baseline", new JournalsFilter());
            cases.put("date_only_august", new JournalsFilter().setDateStart("2026-08-01").setDateEnd("2026-08-31"));
            cases.put("rfc3339_august", new JournalsFilter().setDateStart("2026-08-01T00:00:00Z").setDateEnd("2026-08-31T23:59:59Z"));
            cases.put("rfc3339_start_only", new JournalsFilter().setDateStart("2026-08-01T00:00:00Z"));
            cases.put("rfc3339_end_only", new JournalsFilter().setDateEnd("2026-07-31T23:59:59Z"));
            cases.put("rfc3339_future_empty", new JournalsFilter().setDateStart("2099-01-01T00:00:00Z").setDateEnd("2099-01-31T23:59:59Z"));
            cases.put("rfc3339_colombia_offset", new JournalsFilter().setDateStart("2026-08-01T00:00:00-05:00").setDateEnd("2026-08-31T23:59:59-05:00"));
            cases.put("document_type_9140", new JournalsFilter().setDocumentId(9140L));
            cases.put("document_type_9150", new JournalsFilter().setDocumentId(9150L));
            cases.put("document_type_nonexistent", new JournalsFilter().setDocumentId(2147483647L));
            cases.put("name_existing", new JournalsFilter().setName("CC-1-229"));
            cases.put("name_with_excluding_dates", new JournalsFilter().setName("CC-1-229").setDateStart("2099-01-01T00:00:00Z").setDateEnd("2099-01-31T23:59:59Z"));
            cases.put("name_with_other_document_type", new JournalsFilter().setName("CC-1-229").setDocumentId(9150L));
            cases.put("created_august", new JournalsFilter().setCreatedStart("2026-08-01T00:00:00Z").setCreatedEnd("2026-08-31T23:59:59Z"));
            for (var testCase : cases.entrySet()) {
                JournalsFilter filter = testCase.getValue().setPageSize(100);
                var sdk = api.getJournalService().getJournals(filter);
                var url = observed.get();
                Map<String, String> actualQuery = new LinkedHashMap<>();
                url.queryParameterNames().forEach(k -> actualQuery.put(k, url.queryParameter(k)));
                assertEquals(filter.toQueryMap(), actualQuery, "SDK must transmit every configured parameter once");
                actualQuery.keySet().forEach(k -> assertEquals(1, url.queryParameterValues(k).size()));
                assertEquals("api.siigo.com", url.host()); assertTrue(url.isHttps());
                ThreadSleep.pause();
                var request = HttpRequest.newBuilder(URI.create(url.toString())).timeout(Duration.ofMinutes(2))
                        .header("Authorization", "Bearer " + token).header("Partner-Id", partner)
                        .header("Accept", "application/json").header("Cache-Control", "no-cache").GET().build();
                var response = raw.send(request, HttpResponse.BodyHandlers.ofString());
                assertEquals(200, response.statusCode());
                var body = mapper.readTree(response.body());
                long directTotal = body.path("pagination").path("total_results").asLong(-1);
                List<String> directIds = new ArrayList<>();
                body.path("results").forEach(row -> directIds.add(row.path("id").asText()));
                assertEquals(sdk.getPagination().getTotalResults().longValue(), directTotal);
                assertEquals(sdk.getResults().stream().map(j -> j.getId()).toList(), directIds,
                        "SDK and independent HTTP client must receive identical ordered IDs");
                Map<String, Object> result = new LinkedHashMap<>();
                result.put("case", testCase.getKey()); result.put("url", url.toString());
                result.put("sdkAndDirectMatch", true); result.put("httpStatus", response.statusCode());
                result.put("totalResults", directTotal); result.put("firstPageRows", directIds.size());
                Map<String, Long> documentCounts = new LinkedHashMap<>();
                sdk.getResults().forEach(j -> documentCounts.merge(String.valueOf(j.getDocument().getId()), 1L, Long::sum));
                result.put("firstPageDocumentTypes", documentCounts);
                result.put("firstPageDateMin", sdk.getResults().stream().map(j -> j.getDate().toString()).min(String::compareTo).orElse(null));
                result.put("firstPageDateMax", sdk.getResults().stream().map(j -> j.getDate().toString()).max(String::compareTo).orElse(null));
                Map<String, String> correlation = new LinkedHashMap<>();
                response.headers().map().forEach((name, values) -> {
                    if (List.of("request-id", "x-request-id", "apim-request-id", "x-correlation-id", "traceparent", "date", "age", "x-cache", "cache-control").contains(name.toLowerCase()))
                        correlation.put(name, String.join(",", values));
                });
                result.put("responseDiagnostics", correlation); results.add(result);
                System.out.printf("Journal filter comparison: %s -> HTTP %d, total=%d, SDK=direct.%n", testCase.getKey(), response.statusCode(), directTotal);
            }
            Map<String, Object> report = new LinkedHashMap<>();
            report.put("testedAt", Instant.now().toString());
            report.put("officialDocumentation", "https://developers.siigo.com/docs/siigoapi/journal-entry/3-get-journals");
            report.put("scope", "GLD account; compares SDK with direct JDK HTTP client using identical encoded URLs and token; no mutations");
            report.put("documentTypes", types.stream().map(d -> Map.of("id", d.getId(), "code", d.getCode(), "type", d.getType())).toList());
            report.put("cases", results);
            Path output = Path.of("target/live-verification/journal-filter-contract.json");
            Files.createDirectories(output.getParent()); mapper.writerWithDefaultPrettyPrinter().writeValue(output.toFile(), report);
        }
    }
    private static String required(String name) {
        String value = System.getenv(name); assertNotNull(value, "Missing " + name); assertFalse(value.isBlank()); return value;
    }
    private static final class ThreadSleep {
        static void pause() throws java.io.IOException {
            try { Thread.sleep(700); } catch (InterruptedException ex) {
                Thread.currentThread().interrupt(); throw new java.io.IOException("Interrupted", ex);
            }
        }
    }
}
