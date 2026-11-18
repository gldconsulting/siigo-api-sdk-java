package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class CustomerAddress extends ApiModel {
    @JsonProperty("address") private String address;
    @JsonProperty("city") private CustomerAddressCity city;
    @JsonProperty("postal_code") private String postalCode;

    public String getAddress() { return address; }
    public CustomerAddress setAddress(String value) { this.address = value; return this; }
    public CustomerAddressCity getCity() { return city; }
    public CustomerAddress setCity(CustomerAddressCity value) { this.city = value; return this; }
    public String getPostalCode() { return postalCode; }
    public CustomerAddress setPostalCode(String value) { this.postalCode = value; return this; }
}
