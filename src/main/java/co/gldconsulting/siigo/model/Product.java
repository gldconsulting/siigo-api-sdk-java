package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class Product extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("code") private String code;
    @JsonProperty("name") private String name;
    @JsonProperty("account_group") private ProductAccountGroup accountGroup;
    @JsonProperty("type") private String type;
    @JsonProperty("stock_control") private Boolean stockControl;
    @JsonProperty("active") private Boolean active;
    @JsonProperty("tax_classification") private String taxClassification;
    @JsonProperty("tax_included") private Boolean taxIncluded;
    @JsonProperty("tax_consumption_value") private BigDecimal taxConsumptionValue;
    @JsonProperty("taxes") private List<ProductTax> taxes;
    @JsonProperty("prices") private List<ProductPrice> prices;
    @JsonProperty("unit") private ProductUnit unit;
    @JsonProperty("unit_label") private String unitLabel;
    @JsonProperty("reference") private String reference;
    @JsonProperty("description") private String description;
    @JsonProperty("additional_fields") private ProductAdditionalFields additionalFields;
    @JsonProperty("available_quantity") private BigDecimal availableQuantity;
    @JsonProperty("warehouses") private List<ProductWarehouse> warehouses;
    @JsonProperty("metadata") private ProductMetadata metadata;

    public String getId() { return id; }
    public Product setId(String value) { this.id = value; return this; }
    public String getCode() { return code; }
    public Product setCode(String value) { this.code = value; return this; }
    public String getName() { return name; }
    public Product setName(String value) { this.name = value; return this; }
    public ProductAccountGroup getAccountGroup() { return accountGroup; }
    public Product setAccountGroup(ProductAccountGroup value) { this.accountGroup = value; return this; }
    public String getType() { return type; }
    public Product setType(String value) { this.type = value; return this; }
    public Boolean getStockControl() { return stockControl; }
    public Product setStockControl(Boolean value) { this.stockControl = value; return this; }
    public Boolean getActive() { return active; }
    public Product setActive(Boolean value) { this.active = value; return this; }
    public String getTaxClassification() { return taxClassification; }
    public Product setTaxClassification(String value) { this.taxClassification = value; return this; }
    public Boolean getTaxIncluded() { return taxIncluded; }
    public Product setTaxIncluded(Boolean value) { this.taxIncluded = value; return this; }
    public BigDecimal getTaxConsumptionValue() { return taxConsumptionValue; }
    public Product setTaxConsumptionValue(BigDecimal value) { this.taxConsumptionValue = value; return this; }
    public List<ProductTax> getTaxes() { return taxes; }
    public Product setTaxes(List<ProductTax> value) { this.taxes = value; return this; }
    public List<ProductPrice> getPrices() { return prices; }
    public Product setPrices(List<ProductPrice> value) { this.prices = value; return this; }
    public ProductUnit getUnit() { return unit; }
    public Product setUnit(ProductUnit value) { this.unit = value; return this; }
    public String getUnitLabel() { return unitLabel; }
    public Product setUnitLabel(String value) { this.unitLabel = value; return this; }
    public String getReference() { return reference; }
    public Product setReference(String value) { this.reference = value; return this; }
    public String getDescription() { return description; }
    public Product setDescription(String value) { this.description = value; return this; }
    public ProductAdditionalFields getAdditionalFields() { return additionalFields; }
    public Product setAdditionalFields(ProductAdditionalFields value) { this.additionalFields = value; return this; }
    public BigDecimal getAvailableQuantity() { return availableQuantity; }
    public Product setAvailableQuantity(BigDecimal value) { this.availableQuantity = value; return this; }
    public List<ProductWarehouse> getWarehouses() { return warehouses; }
    public Product setWarehouses(List<ProductWarehouse> value) { this.warehouses = value; return this; }
    public ProductMetadata getMetadata() { return metadata; }
    public Product setMetadata(ProductMetadata value) { this.metadata = value; return this; }
}
