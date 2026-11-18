package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class ProductPrice extends ApiModel {
    @JsonProperty("currency_code") private String currencyCode;
    @JsonProperty("price_list") private List<ProductPricePriceList> priceList;

    public String getCurrencyCode() { return currencyCode; }
    public ProductPrice setCurrencyCode(String value) { this.currencyCode = value; return this; }
    public List<ProductPricePriceList> getPriceList() { return priceList; }
    public ProductPrice setPriceList(List<ProductPricePriceList> value) { this.priceList = value; return this; }
}
