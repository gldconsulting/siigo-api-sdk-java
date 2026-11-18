package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

/** Siigo model; optional fields are omitted when unset. */
public class SupportDocumentRequestPayment extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("value") private BigDecimal value;
    @JsonProperty("due_date") private LocalDate dueDate;

    public Long getId() { return id; }
    public SupportDocumentRequestPayment setId(Long value) { this.id = value; return this; }
    public BigDecimal getValue() { return value; }
    public SupportDocumentRequestPayment setValue(BigDecimal value) { this.value = value; return this; }
    public LocalDate getDueDate() { return dueDate; }
    public SupportDocumentRequestPayment setDueDate(LocalDate value) { this.dueDate = value; return this; }
}
