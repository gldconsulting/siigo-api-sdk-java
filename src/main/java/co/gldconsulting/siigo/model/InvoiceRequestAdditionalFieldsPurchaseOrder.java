package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceRequestAdditionalFieldsPurchaseOrder extends ApiModel {
    @JsonProperty("prefix") private String prefix;
    @JsonProperty("number") private String number;

    public String getPrefix() { return prefix; }
    public InvoiceRequestAdditionalFieldsPurchaseOrder setPrefix(String value) { this.prefix = value; return this; }
    public String getNumber() { return number; }
    public InvoiceRequestAdditionalFieldsPurchaseOrder setNumber(String value) { this.number = value; return this; }
}
