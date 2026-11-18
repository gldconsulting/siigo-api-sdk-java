package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceMail extends ApiModel {
    @JsonProperty("status") private String status;
    @JsonProperty("observations") private String observations;

    public String getStatus() { return status; }
    public InvoiceMail setStatus(String value) { this.status = value; return this; }
    public String getObservations() { return observations; }
    public InvoiceMail setObservations(String value) { this.observations = value; return this; }
}
