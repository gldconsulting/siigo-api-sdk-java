package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.math.BigDecimal;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class CreditNoteRequestItem extends ApiModel {
    @JsonProperty("code") private String code;
    @JsonProperty("description") private String description;
    @JsonProperty("taxes") private List<CreditNoteRequestItemTax> taxes;
    @JsonProperty("quantity") private JsonNode quantity;
    @JsonProperty("price") private BigDecimal price;
    @JsonProperty("warehouse") private Long warehouse;
    @JsonProperty("taxed_price") private BigDecimal taxedPrice;
    @JsonProperty("total_price") private BigDecimal totalPrice;
    @JsonProperty("discount") private BigDecimal discount;
    @JsonProperty("seller") private Long seller;
    @JsonProperty("vat_excluded") private Boolean vatExcluded;

    public String getCode() { return code; }
    public CreditNoteRequestItem setCode(String value) { this.code = value; return this; }
    public String getDescription() { return description; }
    public CreditNoteRequestItem setDescription(String value) { this.description = value; return this; }
    public List<CreditNoteRequestItemTax> getTaxes() { return taxes; }
    public CreditNoteRequestItem setTaxes(List<CreditNoteRequestItemTax> value) { this.taxes = value; return this; }
    public JsonNode getQuantity() { return quantity; }
    public CreditNoteRequestItem setQuantity(JsonNode value) { this.quantity = value; return this; }
    public BigDecimal getPrice() { return price; }
    public CreditNoteRequestItem setPrice(BigDecimal value) { this.price = value; return this; }
    public Long getWarehouse() { return warehouse; }
    public CreditNoteRequestItem setWarehouse(Long value) { this.warehouse = value; return this; }
    public BigDecimal getTaxedPrice() { return taxedPrice; }
    public CreditNoteRequestItem setTaxedPrice(BigDecimal value) { this.taxedPrice = value; return this; }
    public BigDecimal getTotalPrice() { return totalPrice; }
    public CreditNoteRequestItem setTotalPrice(BigDecimal value) { this.totalPrice = value; return this; }
    public BigDecimal getDiscount() { return discount; }
    public CreditNoteRequestItem setDiscount(BigDecimal value) { this.discount = value; return this; }
    public Long getSeller() { return seller; }
    public CreditNoteRequestItem setSeller(Long value) { this.seller = value; return this; }
    public Boolean getVatExcluded() { return vatExcluded; }
    public CreditNoteRequestItem setVatExcluded(Boolean value) { this.vatExcluded = value; return this; }
}
