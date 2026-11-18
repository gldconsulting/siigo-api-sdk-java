package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceRequestCustomerCustomField extends ApiModel {
    @JsonProperty("key") private String key;
    @JsonProperty("value") private String value;

    public String getKey() { return key; }
    public InvoiceRequestCustomerCustomField setKey(String value) { this.key = value; return this; }
    public String getValue() { return value; }
    public InvoiceRequestCustomerCustomField setValue(String value) { this.value = value; return this; }
}
