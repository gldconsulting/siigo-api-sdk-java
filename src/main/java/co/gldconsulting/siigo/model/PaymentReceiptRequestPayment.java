package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class PaymentReceiptRequestPayment extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("value") private BigDecimal value;

    public Long getId() { return id; }
    public PaymentReceiptRequestPayment setId(Long value) { this.id = value; return this; }
    public BigDecimal getValue() { return value; }
    public PaymentReceiptRequestPayment setValue(BigDecimal value) { this.value = value; return this; }
}
