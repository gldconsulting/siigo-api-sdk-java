package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class Journal extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("document") private JournalDocument document;
    @JsonProperty("number") private Long number;
    @JsonProperty("name") private String name;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("currency") private JournalCurrency currency;
    @JsonProperty("items") private List<JournalItem> items;
    @JsonProperty("observations") private String observations;
    @JsonProperty("metadata") private JournalMetadata metadata;

    public String getId() { return id; }
    public Journal setId(String value) { this.id = value; return this; }
    public JournalDocument getDocument() { return document; }
    public Journal setDocument(JournalDocument value) { this.document = value; return this; }
    public Long getNumber() { return number; }
    public Journal setNumber(Long value) { this.number = value; return this; }
    public String getName() { return name; }
    public Journal setName(String value) { this.name = value; return this; }
    public LocalDate getDate() { return date; }
    public Journal setDate(LocalDate value) { this.date = value; return this; }
    public JournalCurrency getCurrency() { return currency; }
    public Journal setCurrency(JournalCurrency value) { this.currency = value; return this; }
    public List<JournalItem> getItems() { return items; }
    public Journal setItems(List<JournalItem> value) { this.items = value; return this; }
    public String getObservations() { return observations; }
    public Journal setObservations(String value) { this.observations = value; return this; }
    public JournalMetadata getMetadata() { return metadata; }
    public Journal setMetadata(JournalMetadata value) { this.metadata = value; return this; }
}
