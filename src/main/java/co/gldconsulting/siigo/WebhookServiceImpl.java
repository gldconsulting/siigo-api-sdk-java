package co.gldconsulting.siigo;

import co.gldconsulting.siigo.model.DeleteResponse;
import co.gldconsulting.siigo.model.Webhook;
import co.gldconsulting.siigo.model.WebhookRequest;
import co.gldconsulting.siigo.model.WebhooksResponse;
import co.gldconsulting.siigo.resource.accounting.WebhookResource;
import co.gldconsulting.siigo.service.accounting.WebhookService;
import co.gldconsulting.siigo.service.accounting.WebhooksFilter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class WebhookServiceImpl implements WebhookService {
    private final WebhookResource resource;
    WebhookServiceImpl(WebhookResource resource) { this.resource = resource; }
    @Override public WebhooksResponse getWebhooks(WebhooksFilter filter) { return resource.getWebhooks(Objects.requireNonNull(filter, "filter").toQueryMap()); }
    @Override public Webhook createWebhook(WebhookRequest request) { return resource.createWebhook(Objects.requireNonNull(request, "request")); }
    @Override public Webhook updateWebhook(WebhookRequest request) { return resource.updateWebhook(Objects.requireNonNull(request, "request")); }
    @Override public DeleteResponse deleteWebhook(String id) { return resource.deleteWebhook(Preconditions.id(id)); }
    @Override public List<Webhook> getAllWebhooks(WebhooksFilter filter) { return Pages.all(Objects.requireNonNull(filter).toQueryMap(), resource::getWebhooks, Webhook::getId); }
}
