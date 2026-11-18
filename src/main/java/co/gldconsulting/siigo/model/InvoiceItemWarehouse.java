package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceItemWarehouse extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;

    public Long getId() { return id; }
    public InvoiceItemWarehouse setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public InvoiceItemWarehouse setName(String value) { this.name = value; return this; }
}
