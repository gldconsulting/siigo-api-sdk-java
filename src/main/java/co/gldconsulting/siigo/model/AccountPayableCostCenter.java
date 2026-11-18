package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class AccountPayableCostCenter extends ApiModel {
    @JsonProperty("code") private Long code;
    @JsonProperty("name") private String name;

    public Long getCode() { return code; }
    public AccountPayableCostCenter setCode(Long value) { this.code = value; return this; }
    public String getName() { return name; }
    public AccountPayableCostCenter setName(String value) { this.name = value; return this; }
}
