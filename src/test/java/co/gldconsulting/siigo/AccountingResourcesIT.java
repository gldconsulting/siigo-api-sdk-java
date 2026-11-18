package co.gldconsulting.siigo;


import co.gldconsulting.siigo.model.DocumentKind;
import co.gldconsulting.siigo.model.JournalRequest;
import co.gldconsulting.siigo.model.JournalRequestDocument;
import co.gldconsulting.siigo.model.JournalRequestItem;
import co.gldconsulting.siigo.model.JournalRequestItemAccount;
import co.gldconsulting.siigo.service.reporting.AccountsPayableFilter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountingResourcesIT {
    private static SiigoApi api(MockSiigoServer server) { return SiigoApi.builder().withCommunicationConfig(CommunicationConfig.builder().setApiUrl(server.url()).setPartnerId("test-partner")).setAccessToken("manual").build(); }
    @Test void journalUsesDocumentScopedIdempotencyAndExactDecimalJson() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer(); SiigoApi api = api(server)) {
            server.enqueue(201, "{\"id\":\"journal-one\",\"date\":\"2026-08-31\"}");
            BigDecimal amount = new BigDecimal("1200.55");
            JournalRequest request = new JournalRequest().setDocument(new JournalRequestDocument().setId(1L)).setDate(LocalDate.of(2026, 8, 31))
                .setItems(List.of(new JournalRequestItem().setAccount(new JournalRequestItemAccount().setCode("11050501").setMovement("Debit")).setValue(amount),
                                  new JournalRequestItem().setAccount(new JournalRequestItemAccount().setCode("11100501").setMovement("Credit")).setValue(amount)));
            assertEquals("journal-one", api.getJournalService().createJournal(request, "bankAugust1").getId());
            MockSiigoServer.Request captured = server.requests.getFirst();
            assertEquals("/v1/journals", captured.path()); assertEquals("POST", captured.method()); assertEquals("bankAugust1", captured.header("Idempotency-Key"));
            JsonNode body = new ObjectMapper().readTree(captured.body());
            assertEquals("2026-08-31", body.get("date").asText()); assertEquals("Debit", body.get("items").get(0).get("account").get("movement").asText());
            assertTrue(captured.body().contains("1200.55")); assertFalse(captured.body().contains("access_token"));
        }
    }
    @Test void catalogsAndEncodedDocumentsUsePublishedShapes() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer(); SiigoApi api = api(server)) {
            server.enqueue(200, "[{\"id\":42,\"type\":\"FC\",\"name\":\"Purchase\"}]");
            server.enqueue(200, "{\"id\":\"invoice-one\",\"base64\":\"UERG\"}");
            assertEquals("FC", api.getCatalogService().getDocumentTypes(DocumentKind.FC).getFirst().getType());
            assertArrayEquals("PDF".getBytes(java.nio.charset.StandardCharsets.UTF_8), api.getInvoiceService().getInvoicePdf("invoice-one").getBytes());
            assertEquals("type=FC", server.requests.getFirst().query()); assertEquals("/v1/invoices/invoice-one/pdf", server.requests.getLast().path());
        }
    }
    @Test void accountsPayableDecodesNestedValueAndRejectsConflictingDateAliases() throws Exception {
        try (MockSiigoServer server = new MockSiigoServer(); SiigoApi api = api(server)) {
            server.enqueue(200, "{\"value\":{\"pagination\":{\"page\":1,\"page_size\":25,\"total_results\":1},\"results\":[{\"due\":{\"balance\":123.45},\"provider\":{\"identification\":\"123\"}}]}}");
            var result = api.getReportService().getAccountsPayable(new AccountsPayableFilter().setDueDateStart(LocalDate.of(2026, 8, 1)));
            assertEquals(new BigDecimal("123.45"), result.getValue().getResults().getFirst().getDue().getBalance());
            assertThrows(IllegalArgumentException.class, () -> api.getReportService().getAccountsPayable(new AccountsPayableFilter().setDueDateEnd("2026-08-31").setDateEnd("2026-08-31")));
            assertEquals(1, server.requests.size());
        }
    }
}
