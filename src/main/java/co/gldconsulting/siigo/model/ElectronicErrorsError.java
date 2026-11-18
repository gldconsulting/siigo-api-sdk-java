package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class ElectronicErrorsError extends ApiModel {
    @JsonProperty("message") private String message;

    public String getMessage() { return message; }
    public ElectronicErrorsError setMessage(String value) { this.message = value; return this; }
}
