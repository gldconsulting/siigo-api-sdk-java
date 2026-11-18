package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class CustomerRequestAddress extends ApiModel {
    @JsonProperty("address") private String address;
    @JsonProperty("city") private CustomerRequestAddressCity city;
    @JsonProperty("postal_code") private String postalCode;

    public String getAddress() { return address; }
    public CustomerRequestAddress setAddress(String value) { this.address = value; return this; }
    public CustomerRequestAddressCity getCity() { return city; }
    public CustomerRequestAddress setCity(CustomerRequestAddressCity value) { this.city = value; return this; }
    public String getPostalCode() { return postalCode; }
    public CustomerRequestAddress setPostalCode(String value) { this.postalCode = value; return this; }
}
