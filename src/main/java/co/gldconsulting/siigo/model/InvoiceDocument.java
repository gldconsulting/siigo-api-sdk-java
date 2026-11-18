package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceDocument extends ApiModel {
    @JsonProperty("id") private Long id;

    public Long getId() { return id; }
    public InvoiceDocument setId(Long value) { this.id = value; return this; }
}
