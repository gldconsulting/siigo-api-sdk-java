package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class PurchaseRequestPayment extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("value") private BigDecimal value;
    @JsonProperty("name") private String name;

    public Long getId() { return id; }
    public PurchaseRequestPayment setId(Long value) { this.id = value; return this; }
    public BigDecimal getValue() { return value; }
    public PurchaseRequestPayment setValue(BigDecimal value) { this.value = value; return this; }
    public String getName() { return name; }
    public PurchaseRequestPayment setName(String value) { this.name = value; return this; }
}
