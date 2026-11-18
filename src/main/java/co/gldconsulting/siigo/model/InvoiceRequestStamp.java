package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceRequestStamp extends ApiModel {
    @JsonProperty("send") private Boolean send;

    public Boolean getSend() { return send; }
    public InvoiceRequestStamp setSend(Boolean value) { this.send = value; return this; }
}
