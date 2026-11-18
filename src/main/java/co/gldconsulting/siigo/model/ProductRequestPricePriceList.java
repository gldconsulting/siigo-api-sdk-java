package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class ProductRequestPricePriceList extends ApiModel {
    @JsonProperty("position") private Long position;
    @JsonProperty("value") private BigDecimal value;

    public Long getPosition() { return position; }
    public ProductRequestPricePriceList setPosition(Long value) { this.position = value; return this; }
    public BigDecimal getValue() { return value; }
    public ProductRequestPricePriceList setValue(BigDecimal value) { this.value = value; return this; }
}
