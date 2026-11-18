package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class CustomerAddressCity extends ApiModel {
    @JsonProperty("country_code") private String countryCode;
    @JsonProperty("country_name") private String countryName;
    @JsonProperty("state_code") private String stateCode;
    @JsonProperty("state_name") private String stateName;
    @JsonProperty("city_code") private String cityCode;
    @JsonProperty("city_name") private String cityName;

    public String getCountryCode() { return countryCode; }
    public CustomerAddressCity setCountryCode(String value) { this.countryCode = value; return this; }
    public String getCountryName() { return countryName; }
    public CustomerAddressCity setCountryName(String value) { this.countryName = value; return this; }
    public String getStateCode() { return stateCode; }
    public CustomerAddressCity setStateCode(String value) { this.stateCode = value; return this; }
    public String getStateName() { return stateName; }
    public CustomerAddressCity setStateName(String value) { this.stateName = value; return this; }
    public String getCityCode() { return cityCode; }
    public CustomerAddressCity setCityCode(String value) { this.cityCode = value; return this; }
    public String getCityName() { return cityName; }
    public CustomerAddressCity setCityName(String value) { this.cityName = value; return this; }
}
