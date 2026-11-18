package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

/** Siigo request; optional fields are omitted when unset. */
public class ProductRequest extends ApiModel {
    @JsonProperty("code") private String code;
    @JsonProperty("name") private String name;
    @JsonProperty("account_group") private Long accountGroup;
    @JsonProperty("type") private String type;
    @JsonProperty("stock_control") private Boolean stockControl;
    @JsonProperty("active") private Boolean active;
    @JsonProperty("tax_classification") private String taxClassification;
    @JsonProperty("tax_included") private Boolean taxIncluded;
    @JsonProperty("tax_consumption_value") private BigDecimal taxConsumptionValue;
    @JsonProperty("taxes") private List<ProductRequestTax> taxes;
    @JsonProperty("prices") private List<ProductRequestPrice> prices;
    @JsonProperty("unit") private String unit;
    @JsonProperty("unit_label") private String unitLabel;
    @JsonProperty("reference") private String reference;
    @JsonProperty("description") private String description;
    @JsonProperty("additional_fields") private ProductRequestAdditionalFields additionalFields;
    @JsonProperty("product_id") private String productId;
    @JsonProperty("components") private List<ProductRequestComponent> components;

    public String getCode() { return code; }
    public ProductRequest setCode(String value) { this.code = value; return this; }
    public String getName() { return name; }
    public ProductRequest setName(String value) { this.name = value; return this; }
    public Long getAccountGroup() { return accountGroup; }
    public ProductRequest setAccountGroup(Long value) { this.accountGroup = value; return this; }
    public String getType() { return type; }
    public ProductRequest setType(String value) { this.type = value; return this; }
    public Boolean getStockControl() { return stockControl; }
    public ProductRequest setStockControl(Boolean value) { this.stockControl = value; return this; }
    public Boolean getActive() { return active; }
    public ProductRequest setActive(Boolean value) { this.active = value; return this; }
    public String getTaxClassification() { return taxClassification; }
    public ProductRequest setTaxClassification(String value) { this.taxClassification = value; return this; }
    public Boolean getTaxIncluded() { return taxIncluded; }
    public ProductRequest setTaxIncluded(Boolean value) { this.taxIncluded = value; return this; }
    public BigDecimal getTaxConsumptionValue() { return taxConsumptionValue; }
    public ProductRequest setTaxConsumptionValue(BigDecimal value) { this.taxConsumptionValue = value; return this; }
    public List<ProductRequestTax> getTaxes() { return taxes; }
    public ProductRequest setTaxes(List<ProductRequestTax> value) { this.taxes = value; return this; }
    public List<ProductRequestPrice> getPrices() { return prices; }
    public ProductRequest setPrices(List<ProductRequestPrice> value) { this.prices = value; return this; }
    public String getUnit() { return unit; }
    public ProductRequest setUnit(String value) { this.unit = value; return this; }
    public String getUnitLabel() { return unitLabel; }
    public ProductRequest setUnitLabel(String value) { this.unitLabel = value; return this; }
    public String getReference() { return reference; }
    public ProductRequest setReference(String value) { this.reference = value; return this; }
    public String getDescription() { return description; }
    public ProductRequest setDescription(String value) { this.description = value; return this; }
    public ProductRequestAdditionalFields getAdditionalFields() { return additionalFields; }
    public ProductRequest setAdditionalFields(ProductRequestAdditionalFields value) { this.additionalFields = value; return this; }
    public String getProductId() { return productId; }
    public ProductRequest setProductId(String value) { this.productId = value; return this; }
    public List<ProductRequestComponent> getComponents() { return components; }
    public ProductRequest setComponents(List<ProductRequestComponent> value) { this.components = value; return this; }
}
