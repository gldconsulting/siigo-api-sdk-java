package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class CustomerRequestPhone extends ApiModel {
    @JsonProperty("number") private String number;
    @JsonProperty("indicative") private String indicative;
    @JsonProperty("extension") private String extension;

    public String getNumber() { return number; }
    public CustomerRequestPhone setNumber(String value) { this.number = value; return this; }
    public String getIndicative() { return indicative; }
    public CustomerRequestPhone setIndicative(String value) { this.indicative = value; return this; }
    public String getExtension() { return extension; }
    public CustomerRequestPhone setExtension(String value) { this.extension = value; return this; }
}
