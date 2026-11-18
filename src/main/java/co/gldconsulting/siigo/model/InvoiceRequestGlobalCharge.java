package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceRequestGlobalCharge extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("percentage") private BigDecimal percentage;

    public Long getId() { return id; }
    public InvoiceRequestGlobalCharge setId(Long value) { this.id = value; return this; }
    public BigDecimal getPercentage() { return percentage; }
    public InvoiceRequestGlobalCharge setPercentage(BigDecimal value) { this.percentage = value; return this; }
}
