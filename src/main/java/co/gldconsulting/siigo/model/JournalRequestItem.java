package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class JournalRequestItem extends ApiModel {
    @JsonProperty("account") private JournalRequestItemAccount account;
    @JsonProperty("customer") private JournalRequestItemCustomer customer;
    @JsonProperty("description") private String description;
    @JsonProperty("cost_center") private Long costCenter;
    @JsonProperty("value") private BigDecimal value;
    @JsonProperty("due") private JournalRequestItemDue due;
    @JsonProperty("tax") private JournalRequestItemTax tax;
    @JsonProperty("fixed_asset") private JournalRequestItemFixedAsset fixedAsset;
    @JsonProperty("product") private JournalRequestItemProduct product;

    public JournalRequestItemAccount getAccount() { return account; }
    public JournalRequestItem setAccount(JournalRequestItemAccount value) { this.account = value; return this; }
    public JournalRequestItemCustomer getCustomer() { return customer; }
    public JournalRequestItem setCustomer(JournalRequestItemCustomer value) { this.customer = value; return this; }
    public String getDescription() { return description; }
    public JournalRequestItem setDescription(String value) { this.description = value; return this; }
    public Long getCostCenter() { return costCenter; }
    public JournalRequestItem setCostCenter(Long value) { this.costCenter = value; return this; }
    public BigDecimal getValue() { return value; }
    public JournalRequestItem setValue(BigDecimal value) { this.value = value; return this; }
    public JournalRequestItemDue getDue() { return due; }
    public JournalRequestItem setDue(JournalRequestItemDue value) { this.due = value; return this; }
    public JournalRequestItemTax getTax() { return tax; }
    public JournalRequestItem setTax(JournalRequestItemTax value) { this.tax = value; return this; }
    public JournalRequestItemFixedAsset getFixedAsset() { return fixedAsset; }
    public JournalRequestItem setFixedAsset(JournalRequestItemFixedAsset value) { this.fixedAsset = value; return this; }
    public JournalRequestItemProduct getProduct() { return product; }
    public JournalRequestItem setProduct(JournalRequestItemProduct value) { this.product = value; return this; }
}
