package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class PaymentReceiptMetadata extends ApiModel {
    @JsonProperty("created") private String created;
    @JsonProperty("last_updated") private String lastUpdated;

    public String getCreated() { return created; }
    public PaymentReceiptMetadata setCreated(String value) { this.created = value; return this; }
    public String getLastUpdated() { return lastUpdated; }
    public PaymentReceiptMetadata setLastUpdated(String value) { this.lastUpdated = value; return this; }
}
