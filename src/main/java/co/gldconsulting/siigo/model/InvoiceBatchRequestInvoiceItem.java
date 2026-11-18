package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceBatchRequestInvoiceItem extends ApiModel {
    @JsonProperty("code") private String code;
    @JsonProperty("description") private String description;
    @JsonProperty("warehouse") private Long warehouse;
    @JsonProperty("quantity") private BigDecimal quantity;
    @JsonProperty("price") private BigDecimal price;
    @JsonProperty("taxed_price") private BigDecimal taxedPrice;
    @JsonProperty("total_price") private BigDecimal totalPrice;
    @JsonProperty("discount") private BigDecimal discount;
    @JsonProperty("seller") private Long seller;
    @JsonProperty("vat_excluded") private Boolean vatExcluded;
    @JsonProperty("taxes") private List<InvoiceBatchRequestInvoiceItemTax> taxes;

    public String getCode() { return code; }
    public InvoiceBatchRequestInvoiceItem setCode(String value) { this.code = value; return this; }
    public String getDescription() { return description; }
    public InvoiceBatchRequestInvoiceItem setDescription(String value) { this.description = value; return this; }
    public Long getWarehouse() { return warehouse; }
    public InvoiceBatchRequestInvoiceItem setWarehouse(Long value) { this.warehouse = value; return this; }
    public BigDecimal getQuantity() { return quantity; }
    public InvoiceBatchRequestInvoiceItem setQuantity(BigDecimal value) { this.quantity = value; return this; }
    public BigDecimal getPrice() { return price; }
    public InvoiceBatchRequestInvoiceItem setPrice(BigDecimal value) { this.price = value; return this; }
    public BigDecimal getTaxedPrice() { return taxedPrice; }
    public InvoiceBatchRequestInvoiceItem setTaxedPrice(BigDecimal value) { this.taxedPrice = value; return this; }
    public BigDecimal getTotalPrice() { return totalPrice; }
    public InvoiceBatchRequestInvoiceItem setTotalPrice(BigDecimal value) { this.totalPrice = value; return this; }
    public BigDecimal getDiscount() { return discount; }
    public InvoiceBatchRequestInvoiceItem setDiscount(BigDecimal value) { this.discount = value; return this; }
    public Long getSeller() { return seller; }
    public InvoiceBatchRequestInvoiceItem setSeller(Long value) { this.seller = value; return this; }
    public Boolean getVatExcluded() { return vatExcluded; }
    public InvoiceBatchRequestInvoiceItem setVatExcluded(Boolean value) { this.vatExcluded = value; return this; }
    public List<InvoiceBatchRequestInvoiceItemTax> getTaxes() { return taxes; }
    public InvoiceBatchRequestInvoiceItem setTaxes(List<InvoiceBatchRequestInvoiceItemTax> value) { this.taxes = value; return this; }
}
