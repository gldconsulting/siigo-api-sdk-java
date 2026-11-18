package co.gldconsulting.siigo;

import co.gldconsulting.siigo.service.accounting.JournalsFilter;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JournalPeriodIT {
    private static final LocalDate FROM = LocalDate.of(2026, 8, 1);
    private static final LocalDate TO = LocalDate.of(2026, 8, 31);
    private static SiigoApi api(MockSiigoServer server) {
        return SiigoApi.builder().withCommunicationConfig(CommunicationConfig.builder()
                .setApiUrl(server.url()).setPartnerId("test-partner")).setAccessToken("manual").build();
    }
    @Test void filtersDocumentDatesAfterAllPagesAndIncludesBothBoundaries() throws Exception {
        try (var server = new MockSiigoServer(); var api = api(server)) {
            server.enqueue(200, """
                {"pagination":{"page":1,"page_size":2,"total_results":4},"results":[
                 {"id":"july","date":"2026-07-31","metadata":{"created":"2026-08-01"}},
                 {"id":"august-first","date":"2026-08-01"}]}
                """);
            server.enqueue(200, """
                {"pagination":{"page":2,"page_size":2,"total_results":4},"results":[
                 {"id":"august-last","date":"2026-08-31","metadata":{"created":"2026-10-15"}},
                 {"id":"september","date":"2026-09-01"}]}
                """);
            var filter = new JournalsFilter().setPageSize(2).setPage(9);
            Map<String, String> original = Map.copyOf(filter.toQueryMap());
            var rows = api.getJournalService().getJournalsByDate(FROM, TO, filter);
            assertEquals(List.of("august-first", "august-last"), rows.stream().map(j -> j.getId()).toList());
            assertEquals(original, filter.toQueryMap());
            assertEquals(2, server.requests.size());
            assertTrue(server.requests.getFirst().query().contains("page=1"));
            assertTrue(server.requests.getLast().query().contains("page=2"));
            server.requests.forEach(r -> { assertFalse(r.query().contains("date_start")); assertFalse(r.query().contains("date_end")); });
        }
    }
    @Test void rejectsConflictingRemoteDatesAndInvalidRangesBeforeHttp() throws Exception {
        try (var server = new MockSiigoServer(); var api = api(server)) {
            assertThrows(IllegalArgumentException.class, () -> api.getJournalService().getJournalsByDate(TO, FROM));
            assertThrows(IllegalArgumentException.class, () -> api.getJournalService().getJournalsByDate(FROM, TO, new JournalsFilter().setDateStart(FROM)));
            assertThrows(NullPointerException.class, () -> api.getJournalService().getJournalsByDate(null, TO));
            assertTrue(server.requests.isEmpty());
        }
    }
    @Test void refusesToTreatMissingDocumentDateAsSuccessfulEmptyPeriod() throws Exception {
        try (var server = new MockSiigoServer(); var api = api(server)) {
            server.enqueue(200, "{\"pagination\":{\"page\":1,\"page_size\":25,\"total_results\":1},\"results\":[{\"id\":\"missing-date\"}]}");
            assertThrows(IllegalStateException.class, () -> api.getJournalService().getJournalsByDate(FROM, TO));
        }
    }
}
