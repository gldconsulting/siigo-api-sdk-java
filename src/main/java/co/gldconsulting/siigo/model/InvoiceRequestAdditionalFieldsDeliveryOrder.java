package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceRequestAdditionalFieldsDeliveryOrder extends ApiModel {
    @JsonProperty("prefix") private String prefix;
    @JsonProperty("number") private String number;
    @JsonProperty("date") private LocalDate date;

    public String getPrefix() { return prefix; }
    public InvoiceRequestAdditionalFieldsDeliveryOrder setPrefix(String value) { this.prefix = value; return this; }
    public String getNumber() { return number; }
    public InvoiceRequestAdditionalFieldsDeliveryOrder setNumber(String value) { this.number = value; return this; }
    public LocalDate getDate() { return date; }
    public InvoiceRequestAdditionalFieldsDeliveryOrder setDate(LocalDate value) { this.date = value; return this; }
}
