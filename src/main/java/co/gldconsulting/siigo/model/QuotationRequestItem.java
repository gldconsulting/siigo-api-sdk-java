package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class QuotationRequestItem extends ApiModel {
    @JsonProperty("code") private String code;
    @JsonProperty("description") private String description;
    @JsonProperty("quantity") private BigDecimal quantity;
    @JsonProperty("price") private BigDecimal price;
    @JsonProperty("taxes") private List<QuotationRequestItemTax> taxes;
    @JsonProperty("discount") private BigDecimal discount;

    public String getCode() { return code; }
    public QuotationRequestItem setCode(String value) { this.code = value; return this; }
    public String getDescription() { return description; }
    public QuotationRequestItem setDescription(String value) { this.description = value; return this; }
    public BigDecimal getQuantity() { return quantity; }
    public QuotationRequestItem setQuantity(BigDecimal value) { this.quantity = value; return this; }
    public BigDecimal getPrice() { return price; }
    public QuotationRequestItem setPrice(BigDecimal value) { this.price = value; return this; }
    public List<QuotationRequestItemTax> getTaxes() { return taxes; }
    public QuotationRequestItem setTaxes(List<QuotationRequestItemTax> value) { this.taxes = value; return this; }
    public BigDecimal getDiscount() { return discount; }
    public QuotationRequestItem setDiscount(BigDecimal value) { this.discount = value; return this; }
}
