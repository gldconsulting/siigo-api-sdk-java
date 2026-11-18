package co.gldconsulting.siigo;


import co.gldconsulting.siigo.model.Purchase;
import co.gldconsulting.siigo.service.accounting.PurchasesFilter;
import co.gldconsulting.siigo.service.SiigoApiException;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PurchasePaginationIT {
    private static final LocalDate FROM = LocalDate.of(2026, 8, 1), TO = LocalDate.of(2026, 8, 31);
    private static SiigoApi api(MockSiigoServer server) {
        return SiigoApi.builder().withCommunicationConfig(CommunicationConfig.builder().setApiUrl(server.url()).setPartnerId("test-partner")).setAccessToken("manual").build();
    }
    private static String row(String id, String date) { return "{\"id\":\"" + id + "\",\"date\":\"" + date + "\",\"metadata\":{\"created\":\"2026-10-06T10:00:00Z\"}}"; }
    private static String page(int page, int size, int total, String... rows) {
        return "{\"pagination\":{\"page\":" + page + ",\"page_size\":" + size + ",\"total_results\":" + total + "},\"results\":[" + String.join(",", rows) + "]}";
    }
    @Test void traversesAllPagesAndFiltersDocumentDateInclusivelyWithoutSendingLocalDates() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer()) {
            server.enqueue(200, page(1, 2, 5, row("july", "2026-07-31"), row("first", "2026-08-01")));
            server.enqueue(200, page(2, 2, 5, row("last", "2026-08-31"), row("september", "2026-09-01")));
            server.enqueue(200, page(3, 2, 5, row("october", "2026-10-06")));
            PurchasesFilter filter = new PurchasesFilter().setPage(7).setPageSize(2);
            try (SiigoApi api = api(server)) {
                List<Purchase> found = api.getPurchaseService().getPurchasesByDate(FROM, TO, filter);
                assertEquals(List.of("first", "last"), found.stream().map(Purchase::getId).toList());
                assertEquals(7, filter.getPage());
            }
            assertEquals(3, server.requests.size());
            for (int i = 0; i < 3; i++) {
                assertEquals("page=" + (i + 1) + "&page_size=2", server.requests.get(i).query());
                assertEquals("Bearer manual", server.requests.get(i).header("Authorization"));
                assertEquals("test-partner", server.requests.get(i).header("Partner-Id"));
            }
        }
    }
    @Test void doesNotStopWhenFirstPageHasNoMatches() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer()) {
            server.enqueue(200, page(1, 1, 2, row("october", "2026-10-06"))); server.enqueue(200, page(2, 1, 2, row("august", "2026-08-02")));
            try (SiigoApi api = api(server)) { assertEquals("august", api.getPurchaseService().getPurchasesByDate(FROM, TO, new PurchasesFilter().setPageSize(1)).getFirst().getId()); }
            assertEquals(2, server.requests.size());
        }
    }
    @Test void duplicateAcrossPagesFailsInsteadOfReturningPartialData() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer()) {
            server.enqueue(200, page(1, 1, 2, row("duplicate", "2026-08-01"))); server.enqueue(200, page(2, 1, 2, row("duplicate", "2026-08-01")));
            try (SiigoApi api = api(server)) { assertThrows(IllegalStateException.class, () -> api.getPurchaseService().getAllPurchases(new PurchasesFilter().setPageSize(1))); }
            assertEquals(2, server.requests.size());
        }
    }
    @Test void changingTotalsAndTruncatedPagesFail() throws Exception {
        for (boolean changed : List.of(true, false)) {
            try (MockSiigoServer server = new MockSiigoServer()) {
                if (changed) { server.enqueue(200, page(1, 1, 2, row("one", "2026-08-01"))); server.enqueue(200, page(2, 1, 3, row("two", "2026-08-02"))); }
                else server.enqueue(200, page(1, 1, 1));
                try (SiigoApi api = api(server)) { assertThrows(IllegalStateException.class, () -> api.getPurchaseService().getAllPurchases(new PurchasesFilter().setPageSize(1))); }
            }
        }
    }
    @Test void confirmedEmptyListNeedsOneRequest() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer()) {
            server.enqueue(200, page(1, 25, 0));
            try (SiigoApi api = api(server)) { assertTrue(api.getPurchaseService().getAllPurchases().isEmpty()); }
            assertEquals(1, server.requests.size());
        }
    }
    @Test void nonJsonHttpFailurePreservesStatusAndIsNotRetried() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer()) {
            server.enqueue(r -> new MockSiigoServer.Reply(429, "slow down", "text/plain"));
            try (SiigoApi api = api(server)) {
                SiigoApiException error = assertThrows(SiigoApiException.class, () -> api.getPurchaseService().getPurchases());
                assertEquals(429, error.getStatusCode()); assertEquals("GET", error.getError().getMethod()); assertEquals("/v1/purchases", error.getError().getPath());
            }
            assertEquals(1, server.requests.size());
        }
    }
    @Test void invalidDateRangeFailsBeforeAnyHttpRequest() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer(); SiigoApi api = api(server)) {
            assertThrows(IllegalArgumentException.class, () -> api.getPurchaseService().getPurchasesByDate(TO, FROM));
            assertTrue(server.requests.isEmpty());
        }
    }
}
