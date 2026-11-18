package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class ProductWarehouse extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("quantity") private BigDecimal quantity;

    public Long getId() { return id; }
    public ProductWarehouse setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public ProductWarehouse setName(String value) { this.name = value; return this; }
    public BigDecimal getQuantity() { return quantity; }
    public ProductWarehouse setQuantity(BigDecimal value) { this.quantity = value; return this; }
}
