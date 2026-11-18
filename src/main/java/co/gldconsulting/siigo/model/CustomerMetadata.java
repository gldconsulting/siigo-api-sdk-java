package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/** Siigo model; optional fields are omitted when unset. */
public class CustomerMetadata extends ApiModel {
    @JsonProperty("created") private String created;
    @JsonProperty("last_updated") private JsonNode lastUpdated;

    public String getCreated() { return created; }
    public CustomerMetadata setCreated(String value) { this.created = value; return this; }
    public JsonNode getLastUpdated() { return lastUpdated; }
    public CustomerMetadata setLastUpdated(JsonNode value) { this.lastUpdated = value; return this; }
}
