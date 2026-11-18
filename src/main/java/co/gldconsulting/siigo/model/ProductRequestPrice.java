package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class ProductRequestPrice extends ApiModel {
    @JsonProperty("currency_code") private String currencyCode;
    @JsonProperty("price_list") private List<ProductRequestPricePriceList> priceList;

    public String getCurrencyCode() { return currencyCode; }
    public ProductRequestPrice setCurrencyCode(String value) { this.currencyCode = value; return this; }
    public List<ProductRequestPricePriceList> getPriceList() { return priceList; }
    public ProductRequestPrice setPriceList(List<ProductRequestPricePriceList> value) { this.priceList = value; return this; }
}
