package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class CreditNoteItemTax extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("type") private String type;
    @JsonProperty("percentage") private BigDecimal percentage;
    @JsonProperty("value") private BigDecimal value;
    @JsonProperty("base_value") private BigDecimal baseValue;

    public Long getId() { return id; }
    public CreditNoteItemTax setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public CreditNoteItemTax setName(String value) { this.name = value; return this; }
    public String getType() { return type; }
    public CreditNoteItemTax setType(String value) { this.type = value; return this; }
    public BigDecimal getPercentage() { return percentage; }
    public CreditNoteItemTax setPercentage(BigDecimal value) { this.percentage = value; return this; }
    public BigDecimal getValue() { return value; }
    public CreditNoteItemTax setValue(BigDecimal value) { this.value = value; return this; }
    public BigDecimal getBaseValue() { return baseValue; }
    public CreditNoteItemTax setBaseValue(BigDecimal value) { this.baseValue = value; return this; }
}
