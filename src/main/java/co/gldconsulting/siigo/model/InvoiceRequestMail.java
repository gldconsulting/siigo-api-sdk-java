package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceRequestMail extends ApiModel {
    @JsonProperty("send") private Boolean send;

    public Boolean getSend() { return send; }
    public InvoiceRequestMail setSend(Boolean value) { this.send = value; return this; }
}
