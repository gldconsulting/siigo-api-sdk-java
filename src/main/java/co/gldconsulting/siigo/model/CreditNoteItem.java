package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class CreditNoteItem extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("code") private String code;
    @JsonProperty("quantity") private BigDecimal quantity;
    @JsonProperty("price") private BigDecimal price;
    @JsonProperty("seller") private Long seller;
    @JsonProperty("description") private String description;
    @JsonProperty("discount") private CreditNoteItemDiscount discount;
    @JsonProperty("taxes") private List<CreditNoteItemTax> taxes;
    @JsonProperty("warehouse") private CreditNoteItemWarehouse warehouse;
    @JsonProperty("total") private BigDecimal total;

    public String getId() { return id; }
    public CreditNoteItem setId(String value) { this.id = value; return this; }
    public String getCode() { return code; }
    public CreditNoteItem setCode(String value) { this.code = value; return this; }
    public BigDecimal getQuantity() { return quantity; }
    public CreditNoteItem setQuantity(BigDecimal value) { this.quantity = value; return this; }
    public BigDecimal getPrice() { return price; }
    public CreditNoteItem setPrice(BigDecimal value) { this.price = value; return this; }
    public Long getSeller() { return seller; }
    public CreditNoteItem setSeller(Long value) { this.seller = value; return this; }
    public String getDescription() { return description; }
    public CreditNoteItem setDescription(String value) { this.description = value; return this; }
    public CreditNoteItemDiscount getDiscount() { return discount; }
    public CreditNoteItem setDiscount(CreditNoteItemDiscount value) { this.discount = value; return this; }
    public List<CreditNoteItemTax> getTaxes() { return taxes; }
    public CreditNoteItem setTaxes(List<CreditNoteItemTax> value) { this.taxes = value; return this; }
    public CreditNoteItemWarehouse getWarehouse() { return warehouse; }
    public CreditNoteItem setWarehouse(CreditNoteItemWarehouse value) { this.warehouse = value; return this; }
    public BigDecimal getTotal() { return total; }
    public CreditNoteItem setTotal(BigDecimal value) { this.total = value; return this; }
}
