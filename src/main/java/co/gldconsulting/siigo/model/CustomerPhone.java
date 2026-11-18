package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class CustomerPhone extends ApiModel {
    @JsonProperty("indicative") private String indicative;
    @JsonProperty("number") private String number;
    @JsonProperty("extension") private String extension;

    public String getIndicative() { return indicative; }
    public CustomerPhone setIndicative(String value) { this.indicative = value; return this; }
    public String getNumber() { return number; }
    public CustomerPhone setNumber(String value) { this.number = value; return this; }
    public String getExtension() { return extension; }
    public CustomerPhone setExtension(String value) { this.extension = value; return this; }
}
