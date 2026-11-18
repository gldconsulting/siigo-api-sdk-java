package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class DocumentTypeGlobalDiscount extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("percentage") private BigDecimal percentage;
    @JsonProperty("active") private Boolean active;

    public Long getId() { return id; }
    public DocumentTypeGlobalDiscount setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public DocumentTypeGlobalDiscount setName(String value) { this.name = value; return this; }
    public BigDecimal getPercentage() { return percentage; }
    public DocumentTypeGlobalDiscount setPercentage(BigDecimal value) { this.percentage = value; return this; }
    public Boolean getActive() { return active; }
    public DocumentTypeGlobalDiscount setActive(Boolean value) { this.active = value; return this; }
}
