package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.AuthenticationCredentials;
import co.gldconsulting.siigo.model.Journal;
import co.gldconsulting.siigo.service.accounting.JournalsFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import okhttp3.Interceptor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import static org.junit.jupiter.api.Assertions.*;

/** Opt-in verification of real journal reads; credentials come only from the environment. */
@EnabledIfEnvironmentVariable(named = "SIIGO_JOURNALS_PERIOD_TEST", matches = "true")
class JournalsPeriodLiveIT {
    private final List<Map<String, Object>> exchanges = new ArrayList<>();
    private final List<Map<String, Object>> traversals = new ArrayList<>();

    @Test void authenticatesPaginatesAndFiltersJournalDocumentDates() throws Exception {
        LocalDate from = LocalDate.parse(System.getenv().getOrDefault("SIIGO_JOURNALS_FROM", "2026-08-01"));
        LocalDate to = LocalDate.parse(System.getenv().getOrDefault("SIIGO_JOURNALS_TO", "2026-08-31"));
        assertFalse(from.isAfter(to));
        Interceptor observer = chain -> {
            var request = chain.request();
            String path = request.url().encodedPath();
            boolean auth = path.equals("/auth") && request.method().equals("POST");
            boolean journals = path.equals("/v1/journals") && request.method().equals("GET");
            if (!auth && !journals) throw new java.io.IOException("Live test permits only auth and journal reads");
            // Space requests so a larger account can still respect the API's per-minute limit.
            try { Thread.sleep(700); } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); throw new java.io.IOException("Interrupted live test", e);
            }
            var response = chain.proceed(request);
            var sent = response.request();
            Map<String, Object> entry = new LinkedHashMap<>();
            entry.put("method", sent.method()); entry.put("path", path); entry.put("status", response.code());
            entry.put("partnerHeaderPresent", sent.header("Partner-Id") != null);
            if (journals) {
                Map<String, String> query = new LinkedHashMap<>();
                sent.url().queryParameterNames().forEach(k -> query.put(k, sent.url().queryParameter(k)));
                entry.put("query", query);
                String header = sent.header("Authorization");
                entry.put("bearerHeaderPresent", header != null && header.startsWith("Bearer "));
            }
            exchanges.add(entry);
            assertEquals(200, response.code(), "Live API response for " + path);
            return response;
        };
        var config = CommunicationConfig.builder().setPartnerId(required("SIIGO_PARTNER_ID"))
                .setInterceptors(List.of(observer));
        var credentials = new AuthenticationCredentials().setUsername(required("SIIGO_USERNAME"))
                .setAccessKey(required("SIIGO_ACCESS_KEY"));
        try (SiigoApi api = SiigoApi.builder().withCommunicationConfig(config).setCredentials(credentials).build()) {
            var service = api.getJournalService();
            var first = service.getJournals(new JournalsFilter().setPageSize(100));
            assertNotNull(first.getPagination());
            long total = first.getPagination().getTotalResults();
            assertEquals(1, first.getPagination().getPage());
            assertEquals(100, first.getPagination().getPageSize());
            assertEquals(Math.min(100L, total), first.getResults().size());
            List<Journal> all = read(api, new JournalsFilter().setPageSize(100), "all journals / 100");
            assertEquals(total, all.size());
            assertEquals(ids(first.getResults()), ids(all.subList(0, first.getResults().size())));
            all.forEach(j -> assertNotNull(j.getDate(), "Journal without document date"));
            List<Journal> expected = all.stream().filter(j -> !j.getDate().isBefore(from) && !j.getDate().isAfter(to)).toList();
            int smallSize = 50;
            var localFilter = new JournalsFilter().setPageSize(smallSize);
            var localOriginal = Map.copyOf(localFilter.toQueryMap());
            int localStart = exchanges.size();
            List<Journal> period = service.getJournalsByDate(from, to, localFilter);
            assertEquals(localOriginal, localFilter.toQueryMap());
            assertEquals(ids(expected), ids(period), "SDK local dates must match independent full-data selection");
            int localPages = Math.max(1, (all.size() + smallSize - 1) / smallSize);
            assertEquals(localPages, exchanges.size() - localStart);
            for (int i = 0; i < localPages; i++) {
                Map<String, String> query = new LinkedHashMap<>(localOriginal);
                query.put("page", Integer.toString(i + 1));
                assertEquals(query, exchanges.get(localStart + i).get("query"));
            }
            traversals.add(Map.of("label", "local period / 50", "pageSize", 50, "pages", localPages,
                    "rowsScanned", all.size(), "matchingRows", period.size()));
            List<String> checks = new ArrayList<>(List.of("automatic authentication", "shared token", "partner header",
                    "full pagination", "no duplicate IDs", "local document-date range", "equivalent page sizes", "unchanged caller filter"));
            List<Map<String, Object>> remoteChecks = new ArrayList<>();
            for (boolean timestamp : List.of(false, true)) {
                var remoteFilter = timestamp ? dates(from, to) : new JournalsFilter().setDateStart(from).setDateEnd(to);
                var page = service.getJournals(remoteFilter.setPageSize(100));
                long outside = page.getResults().stream().filter(j -> j.getDate().isBefore(from) || j.getDate().isAfter(to)).count();
                boolean respected = page.getPagination().getTotalResults() == expected.size() && outside == 0;
                remoteChecks.add(Map.of("filter", timestamp ? "RFC3339 date_start/date_end" : "LocalDate date_start/date_end",
                        "respected", respected, "totalResults", page.getPagination().getTotalResults(),
                        "outsidePeriodOnFirstPage", outside));
            }
            if (!period.isEmpty()) {
                for (LocalDate boundary : List.of(from, to))
                    assertEquals(ids(expected.stream().filter(j -> j.getDate().equals(boundary)).toList()),
                            ids(period.stream().filter(j -> j.getDate().equals(boundary)).toList()));
                checks.add("inclusive local date boundaries");
                Journal sample = period.getFirst();
                assertNotNull(sample.getName());
                List<Journal> byName = read(api, new JournalsFilter().setName(sample.getName()).setPageSize(100), "remote name");
                remoteChecks.add(Map.of("filter", "name", "respected",
                        ids(all.stream().filter(j -> sample.getName().equals(j.getName())).toList()).equals(ids(byName)), "totalResults", byName.size()));
                assertNotNull(sample.getDocument()); assertNotNull(sample.getDocument().getId());
                Long documentId = sample.getDocument().getId();
                List<Journal> byDocument = read(api, new JournalsFilter().setDocumentId(documentId).setPageSize(100), "remote document_id");
                remoteChecks.add(Map.of("filter", "document_id", "respected",
                        ids(all.stream().filter(j -> j.getDocument() != null && documentId.equals(j.getDocument().getId())).toList()).equals(ids(byDocument)), "totalResults", byDocument.size()));
            }
            assertEquals(1L, exchanges.stream().filter(e -> e.get("path").equals("/auth")).count());
            exchanges.forEach(e -> {
                assertEquals(true, e.get("partnerHeaderPresent"));
                if (e.containsKey("bearerHeaderPresent")) assertEquals(true, e.get("bearerHeaderPresent"));
            });
            Map<String, Object> report = new LinkedHashMap<>();
            report.put("testedAt", Instant.now().toString()); report.put("from", from.toString()); report.put("to", to.toString());
            report.put("totalApiJournals", total); report.put("matchingJournals", period.size());
            report.put("pageSizesVerified", List.of(100, smallSize));
            report.put("dateFilter", "SDK getJournalsByDate: local inclusive journal.date selection after complete pagination");
            report.put("remoteFilterDiagnostics", remoteChecks);
            report.put("checksPassed", checks); report.put("traversals", traversals); report.put("httpExchanges", exchanges);
            report.put("journals", period.stream().map(j -> {
                Map<String, Object> row = new LinkedHashMap<>();
                row.put("id", j.getId()); row.put("name", j.getName()); row.put("date", j.getDate().toString());
                row.put("documentId", j.getDocument() == null ? null : j.getDocument().getId());
                row.put("itemCount", j.getItems() == null ? null : j.getItems().size());
                return row;
            }).toList());
            Path output = Path.of("target", "live-verification", "journals-" + from + "-" + to + ".json");
            Files.createDirectories(output.getParent());
            new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(output.toFile(), report);
            System.out.printf("Live journal verification passed: %d API journals; %d in %s..%s; page sizes 100/%d.%n", total, period.size(), from, to, smallSize);
            remoteChecks.forEach(check -> System.out.println("Remote journal filter diagnostic: " + check));
            if ("true".equals(System.getenv("SIIGO_ASSERT_REMOTE_JOURNAL_FILTERS")))
                assertTrue(remoteChecks.stream().allMatch(check -> Boolean.TRUE.equals(check.get("respected"))),
                        "One or more remote journal filters were ignored; see live-verification report");
        }
    }

    private List<Journal> read(SiigoApi api, JournalsFilter filter, String label) {
        Map<String, String> original = Map.copyOf(filter.toQueryMap());
        int start = exchanges.size();
        List<Journal> rows = api.getJournalService().getAllJournals(filter);
        assertEquals(original, filter.toQueryMap());
        ids(rows);
        List<Map<String, Object>> requests = exchanges.subList(start, exchanges.size());
        int size = filter.getPageSize();
        long pages = Math.max(1, (rows.size() + (long) size - 1) / size);
        assertEquals(pages, requests.size());
        for (int i = 0; i < requests.size(); i++) {
            Map<String, String> expected = new LinkedHashMap<>(original);
            expected.put("page", Integer.toString(i + 1));
            assertEquals(expected, requests.get(i).get("query"), "Every page must retain all request filters");
        }
        traversals.add(Map.of("label", label, "pageSize", size, "pages", pages, "rows", rows.size()));
        return rows;
    }
    private static JournalsFilter dates(LocalDate from, LocalDate to) {
        return new JournalsFilter().setDateStart(from + "T00:00:00Z").setDateEnd(to + "T23:59:59Z");
    }
    private static Set<String> ids(List<Journal> rows) {
        var ids = rows.stream().map(Journal::getId).collect(Collectors.toCollection(HashSet::new));
        assertFalse(ids.contains(null)); assertEquals(rows.size(), ids.size()); return ids;
    }
    private static String required(String name) {
        String value = System.getenv(name);
        assertNotNull(value, "Missing environment variable " + name);
        assertFalse(value.isBlank(), "Empty environment variable " + name); return value;
    }
}
