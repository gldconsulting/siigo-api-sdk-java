package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class ProductPricePriceList extends ApiModel {
    @JsonProperty("position") private Long position;
    @JsonProperty("name") private String name;
    @JsonProperty("value") private BigDecimal value;

    public Long getPosition() { return position; }
    public ProductPricePriceList setPosition(Long value) { this.position = value; return this; }
    public String getName() { return name; }
    public ProductPricePriceList setName(String value) { this.name = value; return this; }
    public BigDecimal getValue() { return value; }
    public ProductPricePriceList setValue(BigDecimal value) { this.value = value; return this; }
}
