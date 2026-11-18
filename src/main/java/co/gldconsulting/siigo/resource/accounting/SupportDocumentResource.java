package co.gldconsulting.siigo.resource.accounting;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.SupportDocument;
import co.gldconsulting.siigo.model.SupportDocumentRequest;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/** HTTP contract. Shared headers are supplied exclusively by interceptors. */
public interface SupportDocumentResource {
    @POST("v1/purchase-support-documents")
    SupportDocument createSupportDocument(@Body SupportDocumentRequest request);
    @GET("v1/purchase-support-documents/{id}")
    SupportDocument getSupportDocument(@Path("id") String id);
    @DELETE("v1/purchase-support-documents/{id}")
    DeleteResponse deleteSupportDocument(@Path("id") String id);
    @PUT("v1/purchase-support-documents/{id}")
    SupportDocument updateSupportDocument(@Path("id") String id, @Body SupportDocumentRequest request);
}
