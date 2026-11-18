package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class CustomerFiscalResponsibility extends ApiModel {
    @JsonProperty("code") private String code;
    @JsonProperty("name") private String name;

    public String getCode() { return code; }
    public CustomerFiscalResponsibility setCode(String value) { this.code = value; return this; }
    public String getName() { return name; }
    public CustomerFiscalResponsibility setName(String value) { this.name = value; return this; }
}
