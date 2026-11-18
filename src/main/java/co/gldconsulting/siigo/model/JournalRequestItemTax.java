package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class JournalRequestItemTax extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("percentage") private BigDecimal percentage;
    @JsonProperty("base_value") private BigDecimal baseValue;

    public Long getId() { return id; }
    public JournalRequestItemTax setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public JournalRequestItemTax setName(String value) { this.name = value; return this; }
    public BigDecimal getPercentage() { return percentage; }
    public JournalRequestItemTax setPercentage(BigDecimal value) { this.percentage = value; return this; }
    public BigDecimal getBaseValue() { return baseValue; }
    public JournalRequestItemTax setBaseValue(BigDecimal value) { this.baseValue = value; return this; }
}
