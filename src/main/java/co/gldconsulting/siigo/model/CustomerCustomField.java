package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class CustomerCustomField extends ApiModel {
    @JsonProperty("key") private String key;
    @JsonProperty("value") private String value;

    public String getKey() { return key; }
    public CustomerCustomField setKey(String value) { this.key = value; return this; }
    public String getValue() { return value; }
    public CustomerCustomField setValue(String value) { this.value = value; return this; }
}
