package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class ElectronicErrors extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("errors") private List<ElectronicErrorsError> errors;

    public String getId() { return id; }
    public ElectronicErrors setId(String value) { this.id = value; return this; }
    public List<ElectronicErrorsError> getErrors() { return errors; }
    public ElectronicErrors setErrors(List<ElectronicErrorsError> value) { this.errors = value; return this; }
}
