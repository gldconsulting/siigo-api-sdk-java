package co.gldconsulting.siigo.resource.accounting;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.Quotation;
import co.gldconsulting.siigo.model.QuotationRequest;
import co.gldconsulting.siigo.model.QuotationsResponse;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/** HTTP contract. Shared headers are supplied exclusively by interceptors. */
public interface QuotationResource {
    @GET("v1/quotations")
    QuotationsResponse getQuotations(@QueryMap Map<String, String> query);
    @GET("v1/quotations/{id}")
    Quotation getQuotation(@Path("id") String id);
    @POST("v1/quotations")
    Quotation createQuotation(@Body QuotationRequest request);
    @PUT("v1/quotations/{id}")
    Quotation updateQuotation(@Path("id") String id, @Body QuotationRequest request);
    @DELETE("v1/quotations/{id}")
    DeleteResponse deleteQuotation(@Path("id") String id);
}
