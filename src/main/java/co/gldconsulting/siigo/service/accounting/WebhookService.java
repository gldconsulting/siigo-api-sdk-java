package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.Webhook;
import co.gldconsulting.siigo.model.WebhookRequest;
import co.gldconsulting.siigo.model.WebhooksResponse;
import java.util.List;

/** Siigo Webhook operations; authentication and Partner-Id are configured once on SiigoApi. */
public interface WebhookService {
    WebhooksResponse getWebhooks(WebhooksFilter filter);
    default WebhooksResponse getWebhooks() { return getWebhooks(new WebhooksFilter()); }
    Webhook createWebhook(WebhookRequest request);
    Webhook updateWebhook(WebhookRequest request);
    DeleteResponse deleteWebhook(String id);
    List<Webhook> getAllWebhooks(WebhooksFilter filter);
}
