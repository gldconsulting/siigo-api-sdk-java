package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class JournalItem extends ApiModel {
    @JsonProperty("account") private JournalItemAccount account;
    @JsonProperty("customer") private JournalItemCustomer customer;
    @JsonProperty("cost_center") private Long costCenter;
    @JsonProperty("due") private JournalItemDue due;
    @JsonProperty("tax") private JournalItemTax tax;
    @JsonProperty("fixed_asset") private JournalItemFixedAsset fixedAsset;
    @JsonProperty("product") private JournalItemProduct product;
    @JsonProperty("description") private String description;
    @JsonProperty("value") private BigDecimal value;

    public JournalItemAccount getAccount() { return account; }
    public JournalItem setAccount(JournalItemAccount value) { this.account = value; return this; }
    public JournalItemCustomer getCustomer() { return customer; }
    public JournalItem setCustomer(JournalItemCustomer value) { this.customer = value; return this; }
    public Long getCostCenter() { return costCenter; }
    public JournalItem setCostCenter(Long value) { this.costCenter = value; return this; }
    public JournalItemDue getDue() { return due; }
    public JournalItem setDue(JournalItemDue value) { this.due = value; return this; }
    public JournalItemTax getTax() { return tax; }
    public JournalItem setTax(JournalItemTax value) { this.tax = value; return this; }
    public JournalItemFixedAsset getFixedAsset() { return fixedAsset; }
    public JournalItem setFixedAsset(JournalItemFixedAsset value) { this.fixedAsset = value; return this; }
    public JournalItemProduct getProduct() { return product; }
    public JournalItem setProduct(JournalItemProduct value) { this.product = value; return this; }
    public String getDescription() { return description; }
    public JournalItem setDescription(String value) { this.description = value; return this; }
    public BigDecimal getValue() { return value; }
    public JournalItem setValue(BigDecimal value) { this.value = value; return this; }
}
