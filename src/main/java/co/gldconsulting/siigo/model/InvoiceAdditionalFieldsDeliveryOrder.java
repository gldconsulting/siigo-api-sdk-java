package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceAdditionalFieldsDeliveryOrder extends ApiModel {
    @JsonProperty("prefix") private String prefix;
    @JsonProperty("number") private String number;
    @JsonProperty("date") private LocalDate date;

    public String getPrefix() { return prefix; }
    public InvoiceAdditionalFieldsDeliveryOrder setPrefix(String value) { this.prefix = value; return this; }
    public String getNumber() { return number; }
    public InvoiceAdditionalFieldsDeliveryOrder setNumber(String value) { this.number = value; return this; }
    public LocalDate getDate() { return date; }
    public InvoiceAdditionalFieldsDeliveryOrder setDate(LocalDate value) { this.date = value; return this; }
}
