package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceRequestCustomerContact extends ApiModel {
    @JsonProperty("first_name") private String firstName;
    @JsonProperty("last_name") private String lastName;
    @JsonProperty("email") private String email;
    @JsonProperty("phone") private InvoiceRequestCustomerContactPhone phone;

    public String getFirstName() { return firstName; }
    public InvoiceRequestCustomerContact setFirstName(String value) { this.firstName = value; return this; }
    public String getLastName() { return lastName; }
    public InvoiceRequestCustomerContact setLastName(String value) { this.lastName = value; return this; }
    public String getEmail() { return email; }
    public InvoiceRequestCustomerContact setEmail(String value) { this.email = value; return this; }
    public InvoiceRequestCustomerContactPhone getPhone() { return phone; }
    public InvoiceRequestCustomerContact setPhone(InvoiceRequestCustomerContactPhone value) { this.phone = value; return this; }
}
