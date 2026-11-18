package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class VoucherItemTax extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("type") private String type;
    @JsonProperty("percentage") private BigDecimal percentage;
    @JsonProperty("value") private BigDecimal value;
    @JsonProperty("base_value") private BigDecimal baseValue;

    public Long getId() { return id; }
    public VoucherItemTax setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public VoucherItemTax setName(String value) { this.name = value; return this; }
    public String getType() { return type; }
    public VoucherItemTax setType(String value) { this.type = value; return this; }
    public BigDecimal getPercentage() { return percentage; }
    public VoucherItemTax setPercentage(BigDecimal value) { this.percentage = value; return this; }
    public BigDecimal getValue() { return value; }
    public VoucherItemTax setValue(BigDecimal value) { this.value = value; return this; }
    public BigDecimal getBaseValue() { return baseValue; }
    public VoucherItemTax setBaseValue(BigDecimal value) { this.baseValue = value; return this; }
}
