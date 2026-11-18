package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class QuotationMetadata extends ApiModel {
    @JsonProperty("created") private String created;
    @JsonProperty("last_updated") private String lastUpdated;

    public String getCreated() { return created; }
    public QuotationMetadata setCreated(String value) { this.created = value; return this; }
    public String getLastUpdated() { return lastUpdated; }
    public QuotationMetadata setLastUpdated(String value) { this.lastUpdated = value; return this; }
}
