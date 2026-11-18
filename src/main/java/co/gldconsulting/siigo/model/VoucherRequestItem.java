package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class VoucherRequestItem extends ApiModel {
    @JsonProperty("due") private VoucherRequestItemDue due;
    @JsonProperty("value") private BigDecimal value;
    @JsonProperty("taxes") private List<VoucherRequestItemTax> taxes;
    @JsonProperty("discounts") private List<VoucherRequestItemDiscount> discounts;
    @JsonProperty("account") private VoucherRequestItemAccount account;
    @JsonProperty("description") private String description;

    public VoucherRequestItemDue getDue() { return due; }
    public VoucherRequestItem setDue(VoucherRequestItemDue value) { this.due = value; return this; }
    public BigDecimal getValue() { return value; }
    public VoucherRequestItem setValue(BigDecimal value) { this.value = value; return this; }
    public List<VoucherRequestItemTax> getTaxes() { return taxes; }
    public VoucherRequestItem setTaxes(List<VoucherRequestItemTax> value) { this.taxes = value; return this; }
    public List<VoucherRequestItemDiscount> getDiscounts() { return discounts; }
    public VoucherRequestItem setDiscounts(List<VoucherRequestItemDiscount> value) { this.discounts = value; return this; }
    public VoucherRequestItemAccount getAccount() { return account; }
    public VoucherRequestItem setAccount(VoucherRequestItemAccount value) { this.account = value; return this; }
    public String getDescription() { return description; }
    public VoucherRequestItem setDescription(String value) { this.description = value; return this; }
}
