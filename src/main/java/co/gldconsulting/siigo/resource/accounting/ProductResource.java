package co.gldconsulting.siigo.resource.accounting;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.Product;
import co.gldconsulting.siigo.model.ProductRequest;
import co.gldconsulting.siigo.model.ProductsResponse;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/** HTTP contract. Shared headers are supplied exclusively by interceptors. */
public interface ProductResource {
    @GET("v1/products")
    ProductsResponse getProducts(@QueryMap Map<String, String> query);
    @GET("v1/products/{id}")
    Product getProduct(@Path("id") String id);
    @POST("v1/products")
    Product createProduct(@Body ProductRequest request);
    @PUT("v1/products/{id}")
    Product updateProduct(@Path("id") String id, @Body ProductRequest request);
    @DELETE("v1/products/{id}")
    DeleteResponse deleteProduct(@Path("id") String id);
}
