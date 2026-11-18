package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class ProductAdditionalFields extends ApiModel {
    @JsonProperty("barcode") private String barcode;
    @JsonProperty("brand") private String brand;
    @JsonProperty("tariff") private String tariff;
    @JsonProperty("model") private String model;

    public String getBarcode() { return barcode; }
    public ProductAdditionalFields setBarcode(String value) { this.barcode = value; return this; }
    public String getBrand() { return brand; }
    public ProductAdditionalFields setBrand(String value) { this.brand = value; return this; }
    public String getTariff() { return tariff; }
    public ProductAdditionalFields setTariff(String value) { this.tariff = value; return this; }
    public String getModel() { return model; }
    public ProductAdditionalFields setModel(String value) { this.model = value; return this; }
}
