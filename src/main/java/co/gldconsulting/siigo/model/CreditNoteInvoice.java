package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class CreditNoteInvoice extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("name") private String name;

    public String getId() { return id; }
    public CreditNoteInvoice setId(String value) { this.id = value; return this; }
    public String getName() { return name; }
    public CreditNoteInvoice setName(String value) { this.name = value; return this; }
}
