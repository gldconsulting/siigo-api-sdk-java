package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class PaymentReceiptPayment extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("value") private BigDecimal value;

    public Long getId() { return id; }
    public PaymentReceiptPayment setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public PaymentReceiptPayment setName(String value) { this.name = value; return this; }
    public BigDecimal getValue() { return value; }
    public PaymentReceiptPayment setValue(BigDecimal value) { this.value = value; return this; }
}
