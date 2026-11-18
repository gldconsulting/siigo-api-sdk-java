package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class CostCenter extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("code") private String code;
    @JsonProperty("name") private String name;
    @JsonProperty("active") private Boolean active;

    public Long getId() { return id; }
    public CostCenter setId(Long value) { this.id = value; return this; }
    public String getCode() { return code; }
    public CostCenter setCode(String value) { this.code = value; return this; }
    public String getName() { return name; }
    public CostCenter setName(String value) { this.name = value; return this; }
    public Boolean getActive() { return active; }
    public CostCenter setActive(Boolean value) { this.active = value; return this; }
}
