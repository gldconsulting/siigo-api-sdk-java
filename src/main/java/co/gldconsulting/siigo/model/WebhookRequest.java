package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo request; optional fields are omitted when unset. */
public class WebhookRequest extends ApiModel {
    @JsonProperty("application_id") private String applicationId;
    @JsonProperty("url") private String url;
    @JsonProperty("topic") private String topic;

    public String getApplicationId() { return applicationId; }
    public WebhookRequest setApplicationId(String value) { this.applicationId = value; return this; }
    public String getUrl() { return url; }
    public WebhookRequest setUrl(String value) { this.url = value; return this; }
    public String getTopic() { return topic; }
    public WebhookRequest setTopic(String value) { this.topic = value; return this; }
}
