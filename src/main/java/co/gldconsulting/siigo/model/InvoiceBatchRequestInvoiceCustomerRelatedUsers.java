package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceBatchRequestInvoiceCustomerRelatedUsers extends ApiModel {
    @JsonProperty("seller_id") private Long sellerId;
    @JsonProperty("collector_id") private Long collectorId;

    public Long getSellerId() { return sellerId; }
    public InvoiceBatchRequestInvoiceCustomerRelatedUsers setSellerId(Long value) { this.sellerId = value; return this; }
    public Long getCollectorId() { return collectorId; }
    public InvoiceBatchRequestInvoiceCustomerRelatedUsers setCollectorId(Long value) { this.collectorId = value; return this; }
}
