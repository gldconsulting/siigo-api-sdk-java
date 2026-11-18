package co.gldconsulting.siigo.resource.accounting;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.DocumentFile;
import co.gldconsulting.siigo.model.ElectronicErrors;
import co.gldconsulting.siigo.model.Invoice;
import co.gldconsulting.siigo.model.InvoiceBatchRequest;
import co.gldconsulting.siigo.model.InvoiceBatchResponse;
import co.gldconsulting.siigo.model.InvoiceMailRequest;
import co.gldconsulting.siigo.model.InvoiceRequest;
import co.gldconsulting.siigo.model.InvoicesResponse;
import co.gldconsulting.siigo.model.MailResponse;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/** HTTP contract. Shared headers are supplied exclusively by interceptors. */
public interface InvoiceResource {
    @GET("v1/invoices")
    InvoicesResponse getInvoices(@QueryMap Map<String, String> query);
    @GET("v1/invoices/{id}")
    Invoice getInvoice(@Path("id") String id);
    @POST("v1/invoices")
    Invoice createInvoice(@Body InvoiceRequest request, @Header("Idempotency-Key") String idempotencyKey);
    @PUT("v1/invoices/{id}")
    Invoice updateInvoice(@Path("id") String id, @Body InvoiceRequest request);
    @DELETE("v1/invoices/{id}")
    DeleteResponse deleteInvoice(@Path("id") String id);
    @POST("v1/invoices/{id}/annul")
    DeleteResponse annulInvoice(@Path("id") String id);
    @GET("v1/invoices/{id}/stamp/errors")
    ElectronicErrors getElectronicErrors(@Path("id") String id);
    @GET("v1/invoices/{id}/pdf")
    DocumentFile getInvoicePdf(@Path("id") String id);
    @GET("v1/invoices/{id}/xml")
    DocumentFile getInvoiceXml(@Path("id") String id);
    @POST("v1/invoices/{id}/mail")
    MailResponse sendInvoiceByEmail(@Path("id") String id, @Body InvoiceMailRequest request);
    @POST("v1/invoices/batch")
    InvoiceBatchResponse createInvoiceBatch(@Body InvoiceBatchRequest request);
}
