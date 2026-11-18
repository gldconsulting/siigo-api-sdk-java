package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class DeleteResponse extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("deleted") private Boolean deleted;

    public String getId() { return id; }
    public DeleteResponse setId(String value) { this.id = value; return this; }
    public Boolean getDeleted() { return deleted; }
    public DeleteResponse setDeleted(Boolean value) { this.deleted = value; return this; }
}
