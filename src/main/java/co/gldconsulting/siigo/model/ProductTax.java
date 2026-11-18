package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class ProductTax extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("type") private String type;
    @JsonProperty("percentage") private BigDecimal percentage;

    public Long getId() { return id; }
    public ProductTax setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public ProductTax setName(String value) { this.name = value; return this; }
    public String getType() { return type; }
    public ProductTax setType(String value) { this.type = value; return this; }
    public BigDecimal getPercentage() { return percentage; }
    public ProductTax setPercentage(BigDecimal value) { this.percentage = value; return this; }
}
