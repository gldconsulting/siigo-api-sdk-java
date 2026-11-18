package co.gldconsulting.siigo;

import co.gldconsulting.siigo.service.accounting.JournalsFilter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JournalFilterEncodingIT {
    @Test void localDocumentDatesUseRfc3339AndDocumentIdRemainsAQueryParameter() throws Exception {
        try (var server = new MockSiigoServer(); var api = api(server)) {
            server.enqueue(200, "{\"pagination\":{\"page\":1,\"page_size\":25,\"total_results\":0},\"results\":[]}");
            api.getJournalService().getJournals(new JournalsFilter().setDateStart(LocalDate.of(2026, 8, 1))
                    .setDateEnd(LocalDate.of(2026, 8, 31)).setDocumentId(9140L));
            var request = server.requests.getFirst();
            assertEquals("GET", request.method()); assertEquals("/v1/journals", request.path());
            Map<String, String> query = decode(request.query());
            assertEquals(Map.of("page", "1", "page_size", "25", "date_start", "2026-08-01T00:00:00Z",
                    "date_end", "2026-08-31T23:59:59Z", "document_id", "9140"), query);
            assertDoesNotThrow(() -> Instant.parse(query.get("date_start")));
            assertDoesNotThrow(() -> Instant.parse(query.get("date_end")));
            assertEquals("", request.body());
        }
    }
    @Test void explicitTimestampOffsetIsEncodedOnceAndSurvivesTransmission() throws Exception {
        try (var server = new MockSiigoServer(); var api = api(server)) {
            server.enqueue(200, "{\"pagination\":{\"page\":1,\"page_size\":25,\"total_results\":0},\"results\":[]}");
            String timestamp = "2026-08-01T00:00:00+05:00";
            api.getJournalService().getJournals(new JournalsFilter().setDateStart(timestamp));
            String query = server.requests.getFirst().query();
            assertEquals(timestamp, decode(query).get("date_start"));
            assertTrue(query.contains("%2B")); assertFalse(query.contains("%252B"));
        }
    }
    private static Map<String, String> decode(String query) {
        Map<String, String> values = new LinkedHashMap<>();
        for (String item : query.split("&")) {
            String[] pair = item.split("=", 2);
            assertNull(values.put(URLDecoder.decode(pair[0], StandardCharsets.UTF_8), URLDecoder.decode(pair[1], StandardCharsets.UTF_8)),
                    "Each query parameter must occur once");
        }
        return values;
    }
    private static SiigoApi api(MockSiigoServer server) {
        return SiigoApi.builder().withCommunicationConfig(CommunicationConfig.builder().setApiUrl(server.url())
                .setPartnerId("test-partner")).setAccessToken("manual").build();
    }
}
