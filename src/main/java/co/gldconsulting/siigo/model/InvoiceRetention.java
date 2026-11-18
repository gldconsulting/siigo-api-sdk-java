package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceRetention extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("type") private String type;
    @JsonProperty("percentage") private BigDecimal percentage;
    @JsonProperty("value") private BigDecimal value;

    public Long getId() { return id; }
    public InvoiceRetention setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public InvoiceRetention setName(String value) { this.name = value; return this; }
    public String getType() { return type; }
    public InvoiceRetention setType(String value) { this.type = value; return this; }
    public BigDecimal getPercentage() { return percentage; }
    public InvoiceRetention setPercentage(BigDecimal value) { this.percentage = value; return this; }
    public BigDecimal getValue() { return value; }
    public InvoiceRetention setValue(BigDecimal value) { this.value = value; return this; }
}
