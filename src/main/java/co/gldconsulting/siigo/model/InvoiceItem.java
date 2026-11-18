package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceItem extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("code") private String code;
    @JsonProperty("quantity") private BigDecimal quantity;
    @JsonProperty("price") private BigDecimal price;
    @JsonProperty("seller") private Long seller;
    @JsonProperty("description") private String description;
    @JsonProperty("discount") private InvoiceItemDiscount discount;
    @JsonProperty("taxes") private List<InvoiceItemTax> taxes;
    @JsonProperty("warehouse") private InvoiceItemWarehouse warehouse;
    @JsonProperty("total") private BigDecimal total;

    public String getId() { return id; }
    public InvoiceItem setId(String value) { this.id = value; return this; }
    public String getCode() { return code; }
    public InvoiceItem setCode(String value) { this.code = value; return this; }
    public BigDecimal getQuantity() { return quantity; }
    public InvoiceItem setQuantity(BigDecimal value) { this.quantity = value; return this; }
    public BigDecimal getPrice() { return price; }
    public InvoiceItem setPrice(BigDecimal value) { this.price = value; return this; }
    public Long getSeller() { return seller; }
    public InvoiceItem setSeller(Long value) { this.seller = value; return this; }
    public String getDescription() { return description; }
    public InvoiceItem setDescription(String value) { this.description = value; return this; }
    public InvoiceItemDiscount getDiscount() { return discount; }
    public InvoiceItem setDiscount(InvoiceItemDiscount value) { this.discount = value; return this; }
    public List<InvoiceItemTax> getTaxes() { return taxes; }
    public InvoiceItem setTaxes(List<InvoiceItemTax> value) { this.taxes = value; return this; }
    public InvoiceItemWarehouse getWarehouse() { return warehouse; }
    public InvoiceItem setWarehouse(InvoiceItemWarehouse value) { this.warehouse = value; return this; }
    public BigDecimal getTotal() { return total; }
    public InvoiceItem setTotal(BigDecimal value) { this.total = value; return this; }
}
