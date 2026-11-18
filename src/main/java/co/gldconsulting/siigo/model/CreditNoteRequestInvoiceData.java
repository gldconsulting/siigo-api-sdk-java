package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

/** Siigo model; optional fields are omitted when unset. */
public class CreditNoteRequestInvoiceData extends ApiModel {
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("prefix") private String prefix;
    @JsonProperty("number") private String number;
    @JsonProperty("cufe") private String cufe;

    public LocalDate getDate() { return date; }
    public CreditNoteRequestInvoiceData setDate(LocalDate value) { this.date = value; return this; }
    public String getPrefix() { return prefix; }
    public CreditNoteRequestInvoiceData setPrefix(String value) { this.prefix = value; return this; }
    public String getNumber() { return number; }
    public CreditNoteRequestInvoiceData setNumber(String value) { this.number = value; return this; }
    public String getCufe() { return cufe; }
    public CreditNoteRequestInvoiceData setCufe(String value) { this.cufe = value; return this; }
}
