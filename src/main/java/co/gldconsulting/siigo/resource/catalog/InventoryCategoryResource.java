package co.gldconsulting.siigo.resource.catalog;

import co.gldconsulting.siigo.model.AccountGroup;
import co.gldconsulting.siigo.model.AccountGroupRequest;
import java.util.List;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/** HTTP contract. Shared headers are supplied exclusively by interceptors. */
public interface InventoryCategoryResource {
    @GET("v1/account-groups")
    List<AccountGroup> getAccountGroups();
    @POST("v1/account-groups")
    AccountGroup createAccountGroup(@Body AccountGroupRequest request);
    @PUT("v1/account-groups/{id}")
    AccountGroup updateAccountGroup(@Path("id") Long id, @Body AccountGroupRequest request);
}
