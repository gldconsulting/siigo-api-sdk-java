package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class PaymentType extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("name") private String name;
    @JsonProperty("type") private String type;
    @JsonProperty("active") private Boolean active;
    @JsonProperty("due_date") private Boolean dueDate;

    public Long getId() { return id; }
    public PaymentType setId(Long value) { this.id = value; return this; }
    public String getName() { return name; }
    public PaymentType setName(String value) { this.name = value; return this; }
    public String getType() { return type; }
    public PaymentType setType(String value) { this.type = value; return this; }
    public Boolean getActive() { return active; }
    public PaymentType setActive(Boolean value) { this.active = value; return this; }
    public Boolean getDueDate() { return dueDate; }
    public PaymentType setDueDate(Boolean value) { this.dueDate = value; return this; }
}
