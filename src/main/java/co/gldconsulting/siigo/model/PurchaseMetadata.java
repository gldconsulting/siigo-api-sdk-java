package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class PurchaseMetadata extends ApiModel {
    @JsonProperty("created") private String created;

    public String getCreated() { return created; }
    public PurchaseMetadata setCreated(String value) { this.created = value; return this; }
}
