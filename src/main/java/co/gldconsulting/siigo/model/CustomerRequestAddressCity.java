package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class CustomerRequestAddressCity extends ApiModel {
    @JsonProperty("country_code") private String countryCode;
    @JsonProperty("state_code") private String stateCode;
    @JsonProperty("city_code") private String cityCode;

    public String getCountryCode() { return countryCode; }
    public CustomerRequestAddressCity setCountryCode(String value) { this.countryCode = value; return this; }
    public String getStateCode() { return stateCode; }
    public CustomerRequestAddressCity setStateCode(String value) { this.stateCode = value; return this; }
    public String getCityCode() { return cityCode; }
    public CustomerRequestAddressCity setCityCode(String value) { this.cityCode = value; return this; }
}
