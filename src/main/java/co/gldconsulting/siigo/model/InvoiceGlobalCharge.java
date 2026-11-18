package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceGlobalCharge extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("percentage") private BigDecimal percentage;
    @JsonProperty("value") private BigDecimal value;

    public Long getId() { return id; }
    public InvoiceGlobalCharge setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public InvoiceGlobalCharge setName(String value) { this.name = value; return this; }
    public BigDecimal getPercentage() { return percentage; }
    public InvoiceGlobalCharge setPercentage(BigDecimal value) { this.percentage = value; return this; }
    public BigDecimal getValue() { return value; }
    public InvoiceGlobalCharge setValue(BigDecimal value) { this.value = value; return this; }
}
