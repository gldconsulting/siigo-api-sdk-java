package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class MiscIncome extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;

    public Long getId() { return id; }
    public MiscIncome setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public MiscIncome setName(String value) { this.name = value; return this; }
}
