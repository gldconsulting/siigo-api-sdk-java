package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class PriceList extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("active") private Boolean active;
    @JsonProperty("position") private Long position;

    public Long getId() { return id; }
    public PriceList setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public PriceList setName(String value) { this.name = value; return this; }
    public Boolean getActive() { return active; }
    public PriceList setActive(Boolean value) { this.active = value; return this; }
    public Long getPosition() { return position; }
    public PriceList setPosition(Long value) { this.position = value; return this; }
}
