package co.gldconsulting.siigo.resource.accounting;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.Purchase;
import co.gldconsulting.siigo.model.PurchaseRequest;
import co.gldconsulting.siigo.model.PurchasesResponse;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/** HTTP contract. Shared headers are supplied exclusively by interceptors. */
public interface PurchaseResource {
    @GET("v1/purchases")
    PurchasesResponse getPurchases(@QueryMap Map<String, String> query);
    @GET("v1/purchases/{id}")
    Purchase getPurchase(@Path("id") String id);
    @POST("v1/purchases")
    Purchase createPurchase(@Body PurchaseRequest request);
    @PUT("v1/purchases/{id}")
    Purchase updatePurchase(@Path("id") String id, @Body PurchaseRequest request);
    @DELETE("v1/purchases/{id}")
    DeleteResponse deletePurchase(@Path("id") String id);
}
