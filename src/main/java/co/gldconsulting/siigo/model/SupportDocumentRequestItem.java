package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class SupportDocumentRequestItem extends ApiModel {
    @JsonProperty("type") private String type;
    @JsonProperty("code") private String code;
    @JsonProperty("description") private String description;
    @JsonProperty("quantity") private BigDecimal quantity;
    @JsonProperty("price") private BigDecimal price;
    @JsonProperty("discount") private BigDecimal discount;
    @JsonProperty("taxes") private List<SupportDocumentRequestItemTax> taxes;

    public String getType() { return type; }
    public SupportDocumentRequestItem setType(String value) { this.type = value; return this; }
    public String getCode() { return code; }
    public SupportDocumentRequestItem setCode(String value) { this.code = value; return this; }
    public String getDescription() { return description; }
    public SupportDocumentRequestItem setDescription(String value) { this.description = value; return this; }
    public BigDecimal getQuantity() { return quantity; }
    public SupportDocumentRequestItem setQuantity(BigDecimal value) { this.quantity = value; return this; }
    public BigDecimal getPrice() { return price; }
    public SupportDocumentRequestItem setPrice(BigDecimal value) { this.price = value; return this; }
    public BigDecimal getDiscount() { return discount; }
    public SupportDocumentRequestItem setDiscount(BigDecimal value) { this.discount = value; return this; }
    public List<SupportDocumentRequestItemTax> getTaxes() { return taxes; }
    public SupportDocumentRequestItem setTaxes(List<SupportDocumentRequestItemTax> value) { this.taxes = value; return this; }
}
