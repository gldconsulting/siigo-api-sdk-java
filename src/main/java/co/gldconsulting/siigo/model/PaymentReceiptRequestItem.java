package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class PaymentReceiptRequestItem extends ApiModel {
    @JsonProperty("account") private PaymentReceiptRequestItemAccount account;
    @JsonProperty("description") private String description;
    @JsonProperty("value") private BigDecimal value;
    @JsonProperty("due") private PaymentReceiptRequestItemDue due;
    @JsonProperty("tax") private PaymentReceiptRequestItemTax tax;

    public PaymentReceiptRequestItemAccount getAccount() { return account; }
    public PaymentReceiptRequestItem setAccount(PaymentReceiptRequestItemAccount value) { this.account = value; return this; }
    public String getDescription() { return description; }
    public PaymentReceiptRequestItem setDescription(String value) { this.description = value; return this; }
    public BigDecimal getValue() { return value; }
    public PaymentReceiptRequestItem setValue(BigDecimal value) { this.value = value; return this; }
    public PaymentReceiptRequestItemDue getDue() { return due; }
    public PaymentReceiptRequestItem setDue(PaymentReceiptRequestItemDue value) { this.due = value; return this; }
    public PaymentReceiptRequestItemTax getTax() { return tax; }
    public PaymentReceiptRequestItem setTax(PaymentReceiptRequestItemTax value) { this.tax = value; return this; }
}
