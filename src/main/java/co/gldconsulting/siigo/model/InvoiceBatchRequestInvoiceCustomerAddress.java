package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceBatchRequestInvoiceCustomerAddress extends ApiModel {
    @JsonProperty("address") private String address;
    @JsonProperty("city") private InvoiceBatchRequestInvoiceCustomerAddressCity city;
    @JsonProperty("postal_code") private String postalCode;

    public String getAddress() { return address; }
    public InvoiceBatchRequestInvoiceCustomerAddress setAddress(String value) { this.address = value; return this; }
    public InvoiceBatchRequestInvoiceCustomerAddressCity getCity() { return city; }
    public InvoiceBatchRequestInvoiceCustomerAddress setCity(InvoiceBatchRequestInvoiceCustomerAddressCity value) { this.city = value; return this; }
    public String getPostalCode() { return postalCode; }
    public InvoiceBatchRequestInvoiceCustomerAddress setPostalCode(String value) { this.postalCode = value; return this; }
}
