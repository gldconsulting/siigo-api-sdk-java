package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.math.BigDecimal;
import java.time.LocalDate;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceRequestPayment extends ApiModel {
    @JsonProperty("id") private JsonNode id;
    @JsonProperty("value") private BigDecimal value;
    @JsonProperty("due_date") private LocalDate dueDate;

    public JsonNode getId() { return id; }
    public InvoiceRequestPayment setId(JsonNode value) { this.id = value; return this; }
    public BigDecimal getValue() { return value; }
    public InvoiceRequestPayment setValue(BigDecimal value) { this.value = value; return this; }
    public LocalDate getDueDate() { return dueDate; }
    public InvoiceRequestPayment setDueDate(LocalDate value) { this.dueDate = value; return this; }
}
