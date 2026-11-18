package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class CreditNoteItemDiscount extends ApiModel {
    @JsonProperty("percentage") private BigDecimal percentage;
    @JsonProperty("value") private BigDecimal value;

    public BigDecimal getPercentage() { return percentage; }
    public CreditNoteItemDiscount setPercentage(BigDecimal value) { this.percentage = value; return this; }
    public BigDecimal getValue() { return value; }
    public CreditNoteItemDiscount setValue(BigDecimal value) { this.value = value; return this; }
}
