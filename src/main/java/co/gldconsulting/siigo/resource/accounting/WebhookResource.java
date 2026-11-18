package co.gldconsulting.siigo.resource.accounting;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.Webhook;
import co.gldconsulting.siigo.model.WebhookRequest;
import co.gldconsulting.siigo.model.WebhooksResponse;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/** HTTP contract. Shared headers are supplied exclusively by interceptors. */
public interface WebhookResource {
    @GET("v1/webhooks")
    WebhooksResponse getWebhooks(@QueryMap Map<String, String> query);
    @POST("v1/webhooks")
    Webhook createWebhook(@Body WebhookRequest request);
    @PUT("v1/webhooks")
    Webhook updateWebhook(@Body WebhookRequest request);
    @DELETE("v1/webhooks/{id}")
    DeleteResponse deleteWebhook(@Path("id") String id);
}
