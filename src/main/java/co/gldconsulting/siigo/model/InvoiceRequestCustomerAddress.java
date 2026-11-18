package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceRequestCustomerAddress extends ApiModel {
    @JsonProperty("address") private String address;
    @JsonProperty("city") private InvoiceRequestCustomerAddressCity city;
    @JsonProperty("postal_code") private String postalCode;

    public String getAddress() { return address; }
    public InvoiceRequestCustomerAddress setAddress(String value) { this.address = value; return this; }
    public InvoiceRequestCustomerAddressCity getCity() { return city; }
    public InvoiceRequestCustomerAddress setCity(InvoiceRequestCustomerAddressCity value) { this.city = value; return this; }
    public String getPostalCode() { return postalCode; }
    public InvoiceRequestCustomerAddress setPostalCode(String value) { this.postalCode = value; return this; }
}
