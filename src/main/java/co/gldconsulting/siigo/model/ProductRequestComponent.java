package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class ProductRequestComponent extends ApiModel {
    @JsonProperty("code") private String code;
    @JsonProperty("quantity") private BigDecimal quantity;

    public String getCode() { return code; }
    public ProductRequestComponent setCode(String value) { this.code = value; return this; }
    public BigDecimal getQuantity() { return quantity; }
    public ProductRequestComponent setQuantity(BigDecimal value) { this.quantity = value; return this; }
}
