package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.AuthenticationCredentials;
import co.gldconsulting.siigo.model.Purchase;
import co.gldconsulting.siigo.service.accounting.PurchasesFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
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

/** Opt-in, real authentication and read-only purchase pagination/date filtering. */
@EnabledIfEnvironmentVariable(named = "SIIGO_PURCHASES_PERIOD_TEST", matches = "true")
class PurchasesPeriodLiveIT {
    @Test void authenticatesAndFindsTheSamePeriodWithDifferentPageSizes() throws Exception {
        LocalDate from = LocalDate.parse(System.getenv().getOrDefault("SIIGO_PURCHASES_FROM", "2026-08-01"));
        LocalDate to = LocalDate.parse(System.getenv().getOrDefault("SIIGO_PURCHASES_TO", "2026-08-31"));
        assertFalse(from.isAfter(to));
        List<Map<String, Object>> exchanges = new ArrayList<>();
        Interceptor observer = chain -> {
            var request = chain.request();
            String path = request.url().encodedPath();
            boolean auth = path.equals("/auth") && request.method().equals("POST");
            boolean purchases = path.equals("/v1/purchases") && request.method().equals("GET");
            if (!auth && !purchases) throw new java.io.IOException("Live test permits only auth and purchase reads");
            if (purchases && !request.url().queryParameterNames().equals(Set.of("page", "page_size")))
                throw new java.io.IOException("Unexpected remote purchase filter");
            var response = chain.proceed(request);
            var sent = response.request();
            Map<String, Object> exchange = new LinkedHashMap<>();
            exchange.put("method", sent.method());
            exchange.put("path", path);
            exchange.put("status", response.code());
            exchange.put("partnerHeaderPresent", sent.header("Partner-Id") != null);
            if (purchases) {
                exchange.put("page", Integer.parseInt(sent.url().queryParameter("page")));
                exchange.put("pageSize", Integer.parseInt(sent.url().queryParameter("page_size")));
                String header = sent.header("Authorization");
                exchange.put("bearerHeaderPresent", header != null && header.startsWith("Bearer "));
            }
            exchanges.add(exchange);
            return response;
        };
        var config = CommunicationConfig.builder().setPartnerId(required("SIIGO_PARTNER_ID"))
                .setInterceptors(List.of(observer));
        var credentials = new AuthenticationCredentials().setUsername(required("SIIGO_USERNAME"))
                .setAccessKey(required("SIIGO_ACCESS_KEY"));
        try (SiigoApi api = SiigoApi.builder().withCommunicationConfig(config).setCredentials(credentials).build()) {
            var service = api.getPurchaseService();
            var first = service.getPurchases(new PurchasesFilter().setPageSize(100));
            assertNotNull(first.getPagination());
            long total = first.getPagination().getTotalResults();
            assertEquals(1, first.getPagination().getPage());
            assertEquals(100, first.getPagination().getPageSize());
            assertEquals(Math.min(100L, total), first.getResults().size());

            int allStart = exchanges.size();
            List<Purchase> all = service.getAllPurchases(new PurchasesFilter().setPageSize(100));
            int allEnd = exchanges.size();
            assertEquals(total, all.size(), "Complete pagination must match total_results");
            assertEquals(total, ids(all).size(), "No duplicate purchase IDs");
            assertEquals(ids(first.getResults()), ids(all.subList(0, first.getResults().size())));
            verifyPages(exchanges.subList(allStart, allEnd), total, 100);
            all.forEach(p -> assertNotNull(p.getDate(), "Purchase without document date"));
            List<Purchase> expected = all.stream()
                    .filter(p -> p.getDate().compareTo(from) >= 0 && p.getDate().compareTo(to) <= 0).toList();

            var filter = new PurchasesFilter().setPageSize(50);
            var original = Map.copyOf(filter.toQueryMap());
            int periodStart = exchanges.size();
            List<Purchase> period = service.getPurchasesByDate(from, to, filter);
            verifyPages(exchanges.subList(periodStart, exchanges.size()), total, 50);
            assertEquals(original, filter.toQueryMap(), "Traversal must not mutate the caller's filter");
            assertEquals(ids(expected), ids(period), "Date filter must equal the independent full-data selection");
            assertEquals(0, sum(expected).compareTo(sum(period)));
            for (LocalDate boundary : List.of(from, to)) {
                assertEquals(ids(expected.stream().filter(p -> p.getDate().equals(boundary)).toList()),
                        ids(period.stream().filter(p -> p.getDate().equals(boundary)).toList()), "Inclusive date boundary");
            }
            period.forEach(p -> assertTrue(!p.getDate().isBefore(from) && !p.getDate().isAfter(to)));
            assertEquals(1L, exchanges.stream().filter(e -> e.get("path").equals("/auth")).count(),
                    "One automatic authentication should serve all pages");
            exchanges.forEach(e -> {
                assertEquals(200, e.get("status"));
                assertEquals(true, e.get("partnerHeaderPresent"));
                if (e.containsKey("bearerHeaderPresent")) assertEquals(true, e.get("bearerHeaderPresent"));
            });

            Map<String, Object> report = new LinkedHashMap<>();
            report.put("testedAt", Instant.now().toString());
            report.put("from", from.toString());
            report.put("to", to.toString());
            report.put("totalApiPurchases", total);
            report.put("matchingPurchases", period.size());
            report.put("matchingTotal", sum(period));
            report.put("pageSizesVerified", List.of(100, 50));
            report.put("dateFilter", "local, inclusive, using purchase.date after complete pagination");
            report.put("checksPassed", List.of("automatic authentication", "shared bearer token", "partner header",
                    "complete pagination", "unique IDs", "equivalent date selection", "inclusive boundaries", "unchanged caller filter"));
            report.put("httpExchanges", exchanges);
            report.put("purchases", period.stream().map(p -> {
                Map<String, Object> row = new LinkedHashMap<>();
                row.put("id", p.getId()); row.put("name", p.getName());
                row.put("date", p.getDate().toString()); row.put("total", p.getTotal());
                return row;
            }).toList());
            Path output = Path.of("target", "live-verification", "purchases-" + from + "-" + to + ".json");
            Files.createDirectories(output.getParent());
            new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(output.toFile(), report);
            System.out.printf("Live purchase verification passed: %,d API purchases; %d in %s..%s; total %s; page sizes 100/50.%n",
                    total, period.size(), from, to, sum(period).toPlainString());
        }
    }

    private static void verifyPages(List<Map<String, Object>> exchanges, long total, int size) {
        long pages = Math.max(1, (total + size - 1) / size);
        assertEquals(pages, exchanges.size());
        for (int i = 0; i < exchanges.size(); i++) {
            assertEquals(i + 1, exchanges.get(i).get("page"));
            assertEquals(size, exchanges.get(i).get("pageSize"));
        }
    }
    private static Set<String> ids(List<Purchase> purchases) {
        var ids = purchases.stream().map(Purchase::getId).collect(Collectors.toCollection(HashSet::new));
        assertFalse(ids.contains(null));
        assertEquals(purchases.size(), ids.size());
        return ids;
    }
    private static BigDecimal sum(List<Purchase> purchases) {
        return purchases.stream().map(p -> { assertNotNull(p.getTotal()); return p.getTotal(); })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    private static String required(String name) {
        String value = System.getenv(name);
        assertNotNull(value, "Missing environment variable " + name);
        assertFalse(value.isBlank(), "Empty environment variable " + name);
        return value;
    }
}
