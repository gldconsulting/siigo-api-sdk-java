package co.gldconsulting.siigo.examples.accounting;

import co.gldconsulting.siigo.CommunicationConfig;
import co.gldconsulting.siigo.SiigoApi;
import co.gldconsulting.siigo.model.AuthenticationCredentials;
import co.gldconsulting.siigo.service.accounting.PurchasesFilter;
import java.time.LocalDate;

/** Read-only example; credentials come from the invoking application's environment. */
public final class GetPurchasesExample {
    private GetPurchasesExample() { }
    public static void main(String[] args) {
        LocalDate from = LocalDate.parse(args[0]), to = LocalDate.parse(args[1]);
        try (SiigoApi api = SiigoApi.builder()
                .withCommunicationConfig(CommunicationConfig.builder().setPartnerId(System.getenv("SIIGO_PARTNER_ID")))
                .setCredentials(new AuthenticationCredentials().setUsername(System.getenv("SIIGO_USERNAME")).setAccessKey(System.getenv("SIIGO_ACCESS_KEY")))
                .build()) {
            var purchases = api.getPurchaseService().getPurchasesByDate(from, to, new PurchasesFilter().setPageSize(100));
            purchases.forEach(p -> System.out.printf("%s %s %s%n", p.getDate(), p.getName(), p.getTotal()));
        }
    }
}
