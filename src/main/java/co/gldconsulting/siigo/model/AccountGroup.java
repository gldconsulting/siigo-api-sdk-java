package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class AccountGroup extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("active") private Boolean active;

    public Long getId() { return id; }
    public AccountGroup setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public AccountGroup setName(String value) { this.name = value; return this; }
    public Boolean getActive() { return active; }
    public AccountGroup setActive(Boolean value) { this.active = value; return this; }
}
