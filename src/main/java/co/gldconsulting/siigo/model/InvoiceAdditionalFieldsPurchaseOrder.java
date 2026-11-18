package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceAdditionalFieldsPurchaseOrder extends ApiModel {
    @JsonProperty("prefix") private String prefix;
    @JsonProperty("number") private String number;

    public String getPrefix() { return prefix; }
    public InvoiceAdditionalFieldsPurchaseOrder setPrefix(String value) { this.prefix = value; return this; }
    public String getNumber() { return number; }
    public InvoiceAdditionalFieldsPurchaseOrder setNumber(String value) { this.number = value; return this; }
}
