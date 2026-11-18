package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class CustomerContact extends ApiModel {
    @JsonProperty("first_name") private String firstName;
    @JsonProperty("last_name") private String lastName;
    @JsonProperty("email") private String email;
    @JsonProperty("phone") private CustomerContactPhone phone;

    public String getFirstName() { return firstName; }
    public CustomerContact setFirstName(String value) { this.firstName = value; return this; }
    public String getLastName() { return lastName; }
    public CustomerContact setLastName(String value) { this.lastName = value; return this; }
    public String getEmail() { return email; }
    public CustomerContact setEmail(String value) { this.email = value; return this; }
    public CustomerContactPhone getPhone() { return phone; }
    public CustomerContact setPhone(CustomerContactPhone value) { this.phone = value; return this; }
}
