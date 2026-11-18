package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class MailResponse extends ApiModel {
    @JsonProperty("status") private String status;
    @JsonProperty("observations") private String observations;

    public String getStatus() { return status; }
    public MailResponse setStatus(String value) { this.status = value; return this; }
    public String getObservations() { return observations; }
    public MailResponse setObservations(String value) { this.observations = value; return this; }
}
