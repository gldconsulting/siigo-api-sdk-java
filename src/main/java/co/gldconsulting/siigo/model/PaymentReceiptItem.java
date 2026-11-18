package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class PaymentReceiptItem extends ApiModel {
    @JsonProperty("due") private PaymentReceiptItemDue due;
    @JsonProperty("value") private BigDecimal value;

    public PaymentReceiptItemDue getDue() { return due; }
    public PaymentReceiptItem setDue(PaymentReceiptItemDue value) { this.due = value; return this; }
    public BigDecimal getValue() { return value; }
    public PaymentReceiptItem setValue(BigDecimal value) { this.value = value; return this; }
}
