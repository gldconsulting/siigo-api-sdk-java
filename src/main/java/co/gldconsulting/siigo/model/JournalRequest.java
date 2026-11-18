package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.List;

/** Siigo request; optional fields are omitted when unset. */
public class JournalRequest extends ApiModel {
    @JsonProperty("document") private JournalRequestDocument document;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("currency") private JournalRequestCurrency currency;
    @JsonProperty("items") private List<JournalRequestItem> items;
    @JsonProperty("observations") private String observations;
    @JsonProperty("number") private Long number;

    public JournalRequestDocument getDocument() { return document; }
    public JournalRequest setDocument(JournalRequestDocument value) { this.document = value; return this; }
    public LocalDate getDate() { return date; }
    public JournalRequest setDate(LocalDate value) { this.date = value; return this; }
    public JournalRequestCurrency getCurrency() { return currency; }
    public JournalRequest setCurrency(JournalRequestCurrency value) { this.currency = value; return this; }
    public List<JournalRequestItem> getItems() { return items; }
    public JournalRequest setItems(List<JournalRequestItem> value) { this.items = value; return this; }
    public String getObservations() { return observations; }
    public JournalRequest setObservations(String value) { this.observations = value; return this; }
    public Long getNumber() { return number; }
    public JournalRequest setNumber(Long value) { this.number = value; return this; }
}
