package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class CreditNoteStamp extends ApiModel {
    @JsonProperty("status") private String status;
    @JsonProperty("cufe") private String cufe;
    @JsonProperty("cude") private String cude;
    @JsonProperty("observations") private String observations;
    @JsonProperty("errors") private String errors;

    public String getStatus() { return status; }
    public CreditNoteStamp setStatus(String value) { this.status = value; return this; }
    public String getCufe() { return cufe; }
    public CreditNoteStamp setCufe(String value) { this.cufe = value; return this; }
    public String getCude() { return cude; }
    public CreditNoteStamp setCude(String value) { this.cude = value; return this; }
    public String getObservations() { return observations; }
    public CreditNoteStamp setObservations(String value) { this.observations = value; return this; }
    public String getErrors() { return errors; }
    public CreditNoteStamp setErrors(String value) { this.errors = value; return this; }
}
