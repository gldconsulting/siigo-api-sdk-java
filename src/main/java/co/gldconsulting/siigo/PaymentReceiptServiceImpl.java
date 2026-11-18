package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.PaymentReceipt;
import co.gldconsulting.siigo.model.PaymentReceiptRequest;
import co.gldconsulting.siigo.resource.accounting.PaymentReceiptResource;
import co.gldconsulting.siigo.service.accounting.PaymentReceiptService;
import co.gldconsulting.siigo.service.accounting.PaymentReceiptsFilter;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class PaymentReceiptServiceImpl implements PaymentReceiptService {
    private final PaymentReceiptResource resource;
    PaymentReceiptServiceImpl(PaymentReceiptResource resource) { this.resource = resource; }
    @Override public PaymentReceipt createPaymentReceipt(PaymentReceiptRequest request) { return resource.createPaymentReceipt(Objects.requireNonNull(request, "request")); }
    @Override public PaymentReceipt getPaymentReceipt(String id) { return resource.getPaymentReceipt(Preconditions.id(id)); }
    @Override public DeleteResponse deletePaymentReceipt(String id) { return resource.deletePaymentReceipt(Preconditions.id(id)); }
    @Override public JsonNode getPaymentReceipts(PaymentReceiptsFilter filter) { return resource.getPaymentReceipts(Objects.requireNonNull(filter, "filter").toQueryMap()); }
}
