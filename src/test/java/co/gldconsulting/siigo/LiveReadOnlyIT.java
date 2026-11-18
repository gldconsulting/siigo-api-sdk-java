package co.gldconsulting.siigo;


import co.gldconsulting.siigo.model.AuthenticationCredentials;
import co.gldconsulting.siigo.model.DocumentKind;
import co.gldconsulting.siigo.service.accounting.PurchasesFilter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import static org.junit.jupiter.api.Assertions.*;

/** Explicitly opt-in; performs only authentication and read-only operations on real Siigo. */
@EnabledIfEnvironmentVariable(named = "SIIGO_LIVE_TESTS", matches = "true")
class LiveReadOnlyIT {
    private SiigoApi api() {
        String partner = System.getenv("SIIGO_PARTNER_ID");
        var builder = SiigoApi.builder().withCommunicationConfig(CommunicationConfig.builder().setPartnerId(partner));
        String token = System.getenv("SIIGO_ACCESS_TOKEN");
        if (token != null && !token.isBlank()) builder.setAccessToken(token);
        else builder.setCredentials(new AuthenticationCredentials().setUsername(System.getenv("SIIGO_USERNAME")).setAccessKey(System.getenv("SIIGO_ACCESS_KEY")));
        return builder.build();
    }
    @Test void readsPurchaseDocumentCatalog() { try (SiigoApi api = api()) { assertNotNull(api.getCatalogService().getDocumentTypes(DocumentKind.FC)); } }
    @Test void readsOnePurchasesPage() {
        try (SiigoApi api = api()) {
            var page = api.getPurchaseService().getPurchases(new PurchasesFilter().setPageSize(2));
            assertNotNull(page.getPagination()); assertEquals(1, page.getPagination().getPage()); assertTrue(page.getResults().size() <= 2);
        }
    }
}
