package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class PurchaseItem extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("type") private String type;
    @JsonProperty("code") private String code;
    @JsonProperty("quantity") private BigDecimal quantity;
    @JsonProperty("price") private BigDecimal price;
    @JsonProperty("description") private String description;
    @JsonProperty("total") private BigDecimal total;

    public String getId() { return id; }
    public PurchaseItem setId(String value) { this.id = value; return this; }
    public String getType() { return type; }
    public PurchaseItem setType(String value) { this.type = value; return this; }
    public String getCode() { return code; }
    public PurchaseItem setCode(String value) { this.code = value; return this; }
    public BigDecimal getQuantity() { return quantity; }
    public PurchaseItem setQuantity(BigDecimal value) { this.quantity = value; return this; }
    public BigDecimal getPrice() { return price; }
    public PurchaseItem setPrice(BigDecimal value) { this.price = value; return this; }
    public String getDescription() { return description; }
    public PurchaseItem setDescription(String value) { this.description = value; return this; }
    public BigDecimal getTotal() { return total; }
    public PurchaseItem setTotal(BigDecimal value) { this.total = value; return this; }
}
