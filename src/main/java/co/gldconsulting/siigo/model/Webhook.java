package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class Webhook extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("application_id") private String applicationId;
    @JsonProperty("url") private String url;
    @JsonProperty("topic") private String topic;
    @JsonProperty("company_key") private String companyKey;
    @JsonProperty("active") private Boolean active;
    @JsonProperty("created_at") private String createdAt;

    public String getId() { return id; }
    public Webhook setId(String value) { this.id = value; return this; }
    public String getApplicationId() { return applicationId; }
    public Webhook setApplicationId(String value) { this.applicationId = value; return this; }
    public String getUrl() { return url; }
    public Webhook setUrl(String value) { this.url = value; return this; }
    public String getTopic() { return topic; }
    public Webhook setTopic(String value) { this.topic = value; return this; }
    public String getCompanyKey() { return companyKey; }
    public Webhook setCompanyKey(String value) { this.companyKey = value; return this; }
    public Boolean getActive() { return active; }
    public Webhook setActive(Boolean value) { this.active = value; return this; }
    public String getCreatedAt() { return createdAt; }
    public Webhook setCreatedAt(String value) { this.createdAt = value; return this; }
}
