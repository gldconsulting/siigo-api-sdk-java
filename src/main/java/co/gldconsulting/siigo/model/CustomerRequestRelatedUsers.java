package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class CustomerRequestRelatedUsers extends ApiModel {
    @JsonProperty("seller_id") private Long sellerId;
    @JsonProperty("collector_id") private Long collectorId;

    public Long getSellerId() { return sellerId; }
    public CustomerRequestRelatedUsers setSellerId(Long value) { this.sellerId = value; return this; }
    public Long getCollectorId() { return collectorId; }
    public CustomerRequestRelatedUsers setCollectorId(Long value) { this.collectorId = value; return this; }
}
