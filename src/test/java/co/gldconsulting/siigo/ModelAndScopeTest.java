package co.gldconsulting.siigo;


import co.gldconsulting.siigo.model.Authentication;
import co.gldconsulting.siigo.model.AuthenticationCredentials;
import co.gldconsulting.siigo.model.ProductRequest;
import co.gldconsulting.siigo.model.InvoiceRequest;
import co.gldconsulting.siigo.service.accounting.InvoicesFilter;
import co.gldconsulting.siigo.service.accounting.JournalsFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModelAndScopeTest {
    @Test void optionalNullsAreOmittedButFalseValuesAndUnknownExtensionsSurvive() throws Exception {
        ObjectMapper mapper = new SerializationFactory(SerializationConfig.builder().build()).getObjectMapper();
        ProductRequest product = mapper.readValue("{\"active\":false,\"future_vendor_field\":{\"enabled\":true}}", ProductRequest.class);
        String json = mapper.writeValueAsString(product);
        assertTrue(json.contains("\"active\":false")); assertTrue(json.contains("future_vendor_field")); assertFalse(json.contains("\"code\":null"));
        InvoiceRequest invoice = new InvoiceRequest().setDate(LocalDate.of(2026, 8, 31));
        assertEquals("2026-08-31", mapper.readTree(mapper.writeValueAsString(invoice)).get("date").asText());
    }
    @Test void filtersOwnTheirParametersAndReturnedMapsAreSnapshots() {
        InvoicesFilter invoices = new InvoicesFilter().setDateStart("2026-08-01"); JournalsFilter journals = new JournalsFilter().setDateStart("2026-09-01");
        invoices.toQueryMap().put("date_start", "invalid");
        assertEquals("2026-08-01", invoices.getDateStart()); assertEquals("2026-09-01", journals.getDateStart());
        assertThrows(IllegalArgumentException.class, () -> invoices.setPageSize(0));
    }
    @Test void secretsAreNotIncludedInDiagnosticStrings() {
        assertFalse(new Authentication().setAccessToken("sensitive-token").toString().contains("sensitive-token"));
        assertFalse(new AuthenticationCredentials().setAccessKey("sensitive-key").toString().contains("sensitive-key"));
    }
    @Test void partnerConfigurationIsRequiredAndRemotePlainHttpIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> CommunicationConfig.builder().build());
        assertThrows(IllegalArgumentException.class, () -> CommunicationConfig.builder().setApiUrl("http://example.test/"));
        assertThrows(IllegalStateException.class, () -> SiigoApi.builder().build());
    }
}
