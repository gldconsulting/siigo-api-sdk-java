package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceBatchRequestInvoiceStamp extends ApiModel {
    @JsonProperty("send") private Boolean send;

    public Boolean getSend() { return send; }
    public InvoiceBatchRequestInvoiceStamp setSend(Boolean value) { this.send = value; return this; }
}
