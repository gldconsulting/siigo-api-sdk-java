package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class CustomerRequestContact extends ApiModel {
    @JsonProperty("first_name") private String firstName;
    @JsonProperty("last_name") private String lastName;
    @JsonProperty("email") private String email;
    @JsonProperty("phone") private CustomerRequestContactPhone phone;

    public String getFirstName() { return firstName; }
    public CustomerRequestContact setFirstName(String value) { this.firstName = value; return this; }
    public String getLastName() { return lastName; }
    public CustomerRequestContact setLastName(String value) { this.lastName = value; return this; }
    public String getEmail() { return email; }
    public CustomerRequestContact setEmail(String value) { this.email = value; return this; }
    public CustomerRequestContactPhone getPhone() { return phone; }
    public CustomerRequestContact setPhone(CustomerRequestContactPhone value) { this.phone = value; return this; }
}
