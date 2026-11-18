package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class FixedAsset extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("group") private String group;
    @JsonProperty("active") private Boolean active;

    public Long getId() { return id; }
    public FixedAsset setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public FixedAsset setName(String value) { this.name = value; return this; }
    public String getGroup() { return group; }
    public FixedAsset setGroup(String value) { this.group = value; return this; }
    public Boolean getActive() { return active; }
    public FixedAsset setActive(Boolean value) { this.active = value; return this; }
}
