package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.PaymentReceipt;
import co.gldconsulting.siigo.model.PaymentReceiptRequest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

/** Siigo PaymentReceipt operations; authentication and Partner-Id are configured once on SiigoApi. */
public interface PaymentReceiptService {
    PaymentReceipt createPaymentReceipt(PaymentReceiptRequest request);
    PaymentReceipt getPaymentReceipt(String id);
    DeleteResponse deletePaymentReceipt(String id);
    JsonNode getPaymentReceipts(PaymentReceiptsFilter filter);
    default JsonNode getPaymentReceipts() { return getPaymentReceipts(new PaymentReceiptsFilter()); }
}
