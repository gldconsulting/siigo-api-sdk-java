package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.math.BigDecimal;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceRequestItem extends ApiModel {
    @JsonProperty("code") private String code;
    @JsonProperty("description") private String description;
    @JsonProperty("taxes") private List<InvoiceRequestItemTax> taxes;
    @JsonProperty("quantity") private JsonNode quantity;
    @JsonProperty("price") private BigDecimal price;
    @JsonProperty("warehouse") private Long warehouse;
    @JsonProperty("taxed_price") private BigDecimal taxedPrice;
    @JsonProperty("total_price") private BigDecimal totalPrice;
    @JsonProperty("discount") private BigDecimal discount;
    @JsonProperty("seller") private Long seller;
    @JsonProperty("vat_excluded") private Boolean vatExcluded;
    @JsonProperty("tax_base") private Long taxBase;
    @JsonProperty("taxpayer") private String taxpayer;
    @JsonProperty("transport") private InvoiceRequestItemTransport transport;

    public String getCode() { return code; }
    public InvoiceRequestItem setCode(String value) { this.code = value; return this; }
    public String getDescription() { return description; }
    public InvoiceRequestItem setDescription(String value) { this.description = value; return this; }
    public List<InvoiceRequestItemTax> getTaxes() { return taxes; }
    public InvoiceRequestItem setTaxes(List<InvoiceRequestItemTax> value) { this.taxes = value; return this; }
    public JsonNode getQuantity() { return quantity; }
    public InvoiceRequestItem setQuantity(JsonNode value) { this.quantity = value; return this; }
    public BigDecimal getPrice() { return price; }
    public InvoiceRequestItem setPrice(BigDecimal value) { this.price = value; return this; }
    public Long getWarehouse() { return warehouse; }
    public InvoiceRequestItem setWarehouse(Long value) { this.warehouse = value; return this; }
    public BigDecimal getTaxedPrice() { return taxedPrice; }
    public InvoiceRequestItem setTaxedPrice(BigDecimal value) { this.taxedPrice = value; return this; }
    public BigDecimal getTotalPrice() { return totalPrice; }
    public InvoiceRequestItem setTotalPrice(BigDecimal value) { this.totalPrice = value; return this; }
    public BigDecimal getDiscount() { return discount; }
    public InvoiceRequestItem setDiscount(BigDecimal value) { this.discount = value; return this; }
    public Long getSeller() { return seller; }
    public InvoiceRequestItem setSeller(Long value) { this.seller = value; return this; }
    public Boolean getVatExcluded() { return vatExcluded; }
    public InvoiceRequestItem setVatExcluded(Boolean value) { this.vatExcluded = value; return this; }
    public Long getTaxBase() { return taxBase; }
    public InvoiceRequestItem setTaxBase(Long value) { this.taxBase = value; return this; }
    public String getTaxpayer() { return taxpayer; }
    public InvoiceRequestItem setTaxpayer(String value) { this.taxpayer = value; return this; }
    public InvoiceRequestItemTransport getTransport() { return transport; }
    public InvoiceRequestItem setTransport(InvoiceRequestItemTransport value) { this.transport = value; return this; }
}
