package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class Warehouse extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("active") private Boolean active;
    @JsonProperty("has_movements") private Boolean hasMovements;

    public Long getId() { return id; }
    public Warehouse setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public Warehouse setName(String value) { this.name = value; return this; }
    public Boolean getActive() { return active; }
    public Warehouse setActive(Boolean value) { this.active = value; return this; }
    public Boolean getHasMovements() { return hasMovements; }
    public Warehouse setHasMovements(Boolean value) { this.hasMovements = value; return this; }
}
