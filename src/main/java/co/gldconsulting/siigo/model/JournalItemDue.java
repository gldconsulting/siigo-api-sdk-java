package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

/** Siigo model; optional fields are omitted when unset. */
public class JournalItemDue extends ApiModel {
    @JsonProperty("prefix") private String prefix;
    @JsonProperty("consecutive") private Long consecutive;
    @JsonProperty("quote") private Long quote;
    @JsonProperty("date") private LocalDate date;

    public String getPrefix() { return prefix; }
    public JournalItemDue setPrefix(String value) { this.prefix = value; return this; }
    public Long getConsecutive() { return consecutive; }
    public JournalItemDue setConsecutive(Long value) { this.consecutive = value; return this; }
    public Long getQuote() { return quote; }
    public JournalItemDue setQuote(Long value) { this.quote = value; return this; }
    public LocalDate getDate() { return date; }
    public JournalItemDue setDate(LocalDate value) { this.date = value; return this; }
}
