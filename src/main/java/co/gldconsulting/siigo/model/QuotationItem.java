package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class QuotationItem extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("code") private String code;
    @JsonProperty("description") private String description;
    @JsonProperty("quantity") private BigDecimal quantity;
    @JsonProperty("price") private BigDecimal price;
    @JsonProperty("discount") private QuotationItemDiscount discount;
    @JsonProperty("taxes") private List<QuotationItemTax> taxes;
    @JsonProperty("total") private BigDecimal total;

    public String getId() { return id; }
    public QuotationItem setId(String value) { this.id = value; return this; }
    public String getCode() { return code; }
    public QuotationItem setCode(String value) { this.code = value; return this; }
    public String getDescription() { return description; }
    public QuotationItem setDescription(String value) { this.description = value; return this; }
    public BigDecimal getQuantity() { return quantity; }
    public QuotationItem setQuantity(BigDecimal value) { this.quantity = value; return this; }
    public BigDecimal getPrice() { return price; }
    public QuotationItem setPrice(BigDecimal value) { this.price = value; return this; }
    public QuotationItemDiscount getDiscount() { return discount; }
    public QuotationItem setDiscount(QuotationItemDiscount value) { this.discount = value; return this; }
    public List<QuotationItemTax> getTaxes() { return taxes; }
    public QuotationItem setTaxes(List<QuotationItemTax> value) { this.taxes = value; return this; }
    public BigDecimal getTotal() { return total; }
    public QuotationItem setTotal(BigDecimal value) { this.total = value; return this; }
}
