package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class ProductRequestAdditionalFields extends ApiModel {
    @JsonProperty("barcode") private String barcode;
    @JsonProperty("brand") private String brand;
    @JsonProperty("tariff") private String tariff;
    @JsonProperty("model") private String model;

    public String getBarcode() { return barcode; }
    public ProductRequestAdditionalFields setBarcode(String value) { this.barcode = value; return this; }
    public String getBrand() { return brand; }
    public ProductRequestAdditionalFields setBrand(String value) { this.brand = value; return this; }
    public String getTariff() { return tariff; }
    public ProductRequestAdditionalFields setTariff(String value) { this.tariff = value; return this; }
    public String getModel() { return model; }
    public ProductRequestAdditionalFields setModel(String value) { this.model = value; return this; }
}
