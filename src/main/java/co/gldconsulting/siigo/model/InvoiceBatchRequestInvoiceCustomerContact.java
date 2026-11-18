package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceBatchRequestInvoiceCustomerContact extends ApiModel {
    @JsonProperty("first_name") private String firstName;
    @JsonProperty("last_name") private String lastName;
    @JsonProperty("email") private String email;
    @JsonProperty("phone") private InvoiceBatchRequestInvoiceCustomerContactPhone phone;

    public String getFirstName() { return firstName; }
    public InvoiceBatchRequestInvoiceCustomerContact setFirstName(String value) { this.firstName = value; return this; }
    public String getLastName() { return lastName; }
    public InvoiceBatchRequestInvoiceCustomerContact setLastName(String value) { this.lastName = value; return this; }
    public String getEmail() { return email; }
    public InvoiceBatchRequestInvoiceCustomerContact setEmail(String value) { this.email = value; return this; }
    public InvoiceBatchRequestInvoiceCustomerContactPhone getPhone() { return phone; }
    public InvoiceBatchRequestInvoiceCustomerContact setPhone(InvoiceBatchRequestInvoiceCustomerContactPhone value) { this.phone = value; return this; }
}
