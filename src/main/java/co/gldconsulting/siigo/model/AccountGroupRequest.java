package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo request; optional fields are omitted when unset. */
public class AccountGroupRequest extends ApiModel {
    @JsonProperty("code") private String code;
    @JsonProperty("name") private String name;

    public String getCode() { return code; }
    public AccountGroupRequest setCode(String value) { this.code = value; return this; }
    public String getName() { return name; }
    public AccountGroupRequest setName(String value) { this.name = value; return this; }
}
