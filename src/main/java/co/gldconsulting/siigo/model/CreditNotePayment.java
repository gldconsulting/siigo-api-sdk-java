package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

/** Siigo model; optional fields are omitted when unset. */
public class CreditNotePayment extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("value") private BigDecimal value;
    @JsonProperty("due_date") private LocalDate dueDate;

    public Long getId() { return id; }
    public CreditNotePayment setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public CreditNotePayment setName(String value) { this.name = value; return this; }
    public BigDecimal getValue() { return value; }
    public CreditNotePayment setValue(BigDecimal value) { this.value = value; return this; }
    public LocalDate getDueDate() { return dueDate; }
    public CreditNotePayment setDueDate(LocalDate value) { this.dueDate = value; return this; }
}
