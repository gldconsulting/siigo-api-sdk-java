package co.gldconsulting.siigo.resource.accounting;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.PaymentReceipt;
import co.gldconsulting.siigo.model.PaymentReceiptRequest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/** HTTP contract. Shared headers are supplied exclusively by interceptors. */
public interface PaymentReceiptResource {
    @POST("v1/payment-receipts")
    PaymentReceipt createPaymentReceipt(@Body PaymentReceiptRequest request);
    @GET("v1/payment-receipts/{id}")
    PaymentReceipt getPaymentReceipt(@Path("id") String id);
    @DELETE("v1/payment-receipts/{id}")
    DeleteResponse deletePaymentReceipt(@Path("id") String id);
    @GET("v1/payment-receipts")
    JsonNode getPaymentReceipts(@QueryMap Map<String, String> query);
}
