package co.gldconsulting.siigo.resource.accounting;

import co.gldconsulting.siigo.model.CreditNote;
import co.gldconsulting.siigo.model.CreditNoteRequest;
import co.gldconsulting.siigo.model.CreditNotesResponse;
import co.gldconsulting.siigo.model.DocumentFile;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/** HTTP contract. Shared headers are supplied exclusively by interceptors. */
public interface CreditNoteResource {
    @GET("v1/credit-notes")
    CreditNotesResponse getCreditNotes(@QueryMap Map<String, String> query);
    @GET("v1/credit-notes/{id}")
    CreditNote getCreditNote(@Path("id") String id);
    @POST("v1/credit-notes")
    CreditNote createCreditNote(@Body CreditNoteRequest request, @Header("Idempotency-Key") String idempotencyKey);
    @GET("v1/credit-notes/{id}/pdf")
    DocumentFile getCreditNotePdf(@Path("id") String id);
}
