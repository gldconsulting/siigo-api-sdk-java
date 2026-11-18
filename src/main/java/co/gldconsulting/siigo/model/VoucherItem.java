package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class VoucherItem extends ApiModel {
    @JsonProperty("due") private VoucherItemDue due;
    @JsonProperty("tax") private VoucherItemTax tax;
    @JsonProperty("description") private String description;
    @JsonProperty("value") private BigDecimal value;

    public VoucherItemDue getDue() { return due; }
    public VoucherItem setDue(VoucherItemDue value) { this.due = value; return this; }
    public VoucherItemTax getTax() { return tax; }
    public VoucherItem setTax(VoucherItemTax value) { this.tax = value; return this; }
    public String getDescription() { return description; }
    public VoucherItem setDescription(String value) { this.description = value; return this; }
    public BigDecimal getValue() { return value; }
    public VoucherItem setValue(BigDecimal value) { this.value = value; return this; }
}
