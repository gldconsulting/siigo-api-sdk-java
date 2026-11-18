package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class PurchaseRequestItem extends ApiModel {
    @JsonProperty("type") private String type;
    @JsonProperty("code") private String code;
    @JsonProperty("description") private String description;
    @JsonProperty("quantity") private BigDecimal quantity;
    @JsonProperty("price") private BigDecimal price;

    public String getType() { return type; }
    public PurchaseRequestItem setType(String value) { this.type = value; return this; }
    public String getCode() { return code; }
    public PurchaseRequestItem setCode(String value) { this.code = value; return this; }
    public String getDescription() { return description; }
    public PurchaseRequestItem setDescription(String value) { this.description = value; return this; }
    public BigDecimal getQuantity() { return quantity; }
    public PurchaseRequestItem setQuantity(BigDecimal value) { this.quantity = value; return this; }
    public BigDecimal getPrice() { return price; }
    public PurchaseRequestItem setPrice(BigDecimal value) { this.price = value; return this; }
}
