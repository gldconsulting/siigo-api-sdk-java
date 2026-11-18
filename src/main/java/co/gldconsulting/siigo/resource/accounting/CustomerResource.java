package co.gldconsulting.siigo.resource.accounting;

import co.gldconsulting.siigo.model.Customer;
import co.gldconsulting.siigo.model.CustomerRequest;
import co.gldconsulting.siigo.model.CustomersResponse;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/** HTTP contract. Shared headers are supplied exclusively by interceptors. */
public interface CustomerResource {
    @GET("v1/customers")
    CustomersResponse getCustomers(@QueryMap Map<String, String> query);
    @GET("v1/customers/{id}")
    Customer getCustomer(@Path("id") String id);
    @POST("v1/customers")
    Customer createCustomer(@Body CustomerRequest request);
    @PUT("v1/customers/{id}")
    Customer updateCustomer(@Path("id") String id, @Body CustomerRequest request);
}
