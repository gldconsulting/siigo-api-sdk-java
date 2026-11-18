package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class QuotationItemTax extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("type") private String type;
    @JsonProperty("percentage") private BigDecimal percentage;
    @JsonProperty("value") private BigDecimal value;

    public Long getId() { return id; }
    public QuotationItemTax setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public QuotationItemTax setName(String value) { this.name = value; return this; }
    public String getType() { return type; }
    public QuotationItemTax setType(String value) { this.type = value; return this; }
    public BigDecimal getPercentage() { return percentage; }
    public QuotationItemTax setPercentage(BigDecimal value) { this.percentage = value; return this; }
    public BigDecimal getValue() { return value; }
    public QuotationItemTax setValue(BigDecimal value) { this.value = value; return this; }
}
