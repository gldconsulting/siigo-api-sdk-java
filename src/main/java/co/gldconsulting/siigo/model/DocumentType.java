package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class DocumentType extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("code") private String code;
    @JsonProperty("name") private String name;
    @JsonProperty("description") private String description;
    @JsonProperty("type") private String type;
    @JsonProperty("active") private Boolean active;
    @JsonProperty("seller_by_item") private Boolean sellerByItem;
    @JsonProperty("cost_center") private Boolean costCenter;
    @JsonProperty("cost_center_mandatory") private Boolean costCenterMandatory;
    @JsonProperty("cost_center_default") private Long costCenterDefault;
    @JsonProperty("automatic_number") private Boolean automaticNumber;
    @JsonProperty("consecutive") private Long consecutive;
    @JsonProperty("discount_type") private String discountType;
    @JsonProperty("decimals") private Boolean decimals;
    @JsonProperty("advance_payment") private Boolean advancePayment;
    @JsonProperty("reteiva") private Boolean reteiva;
    @JsonProperty("reteica") private Boolean reteica;
    @JsonProperty("self_withholding") private Boolean selfWithholding;
    @JsonProperty("self_withholding_limit") private Long selfWithholdingLimit;
    @JsonProperty("electronic_type") private String electronicType;
    @JsonProperty("official_book") private String officialBook;
    @JsonProperty("document_support") private Boolean documentSupport;
    @JsonProperty("prefix") private String prefix;
    @JsonProperty("global_discounts") private List<DocumentTypeGlobalDiscount> globalDiscounts;
    @JsonProperty("global_charges") private List<DocumentTypeGlobalCharge> globalCharges;

    public Long getId() { return id; }
    public DocumentType setId(Long value) { this.id = value; return this; }
    public String getCode() { return code; }
    public DocumentType setCode(String value) { this.code = value; return this; }
    public String getName() { return name; }
    public DocumentType setName(String value) { this.name = value; return this; }
    public String getDescription() { return description; }
    public DocumentType setDescription(String value) { this.description = value; return this; }
    public String getType() { return type; }
    public DocumentType setType(String value) { this.type = value; return this; }
    public Boolean getActive() { return active; }
    public DocumentType setActive(Boolean value) { this.active = value; return this; }
    public Boolean getSellerByItem() { return sellerByItem; }
    public DocumentType setSellerByItem(Boolean value) { this.sellerByItem = value; return this; }
    public Boolean getCostCenter() { return costCenter; }
    public DocumentType setCostCenter(Boolean value) { this.costCenter = value; return this; }
    public Boolean getCostCenterMandatory() { return costCenterMandatory; }
    public DocumentType setCostCenterMandatory(Boolean value) { this.costCenterMandatory = value; return this; }
    public Long getCostCenterDefault() { return costCenterDefault; }
    public DocumentType setCostCenterDefault(Long value) { this.costCenterDefault = value; return this; }
    public Boolean getAutomaticNumber() { return automaticNumber; }
    public DocumentType setAutomaticNumber(Boolean value) { this.automaticNumber = value; return this; }
    public Long getConsecutive() { return consecutive; }
    public DocumentType setConsecutive(Long value) { this.consecutive = value; return this; }
    public String getDiscountType() { return discountType; }
    public DocumentType setDiscountType(String value) { this.discountType = value; return this; }
    public Boolean getDecimals() { return decimals; }
    public DocumentType setDecimals(Boolean value) { this.decimals = value; return this; }
    public Boolean getAdvancePayment() { return advancePayment; }
    public DocumentType setAdvancePayment(Boolean value) { this.advancePayment = value; return this; }
    public Boolean getReteiva() { return reteiva; }
    public DocumentType setReteiva(Boolean value) { this.reteiva = value; return this; }
    public Boolean getReteica() { return reteica; }
    public DocumentType setReteica(Boolean value) { this.reteica = value; return this; }
    public Boolean getSelfWithholding() { return selfWithholding; }
    public DocumentType setSelfWithholding(Boolean value) { this.selfWithholding = value; return this; }
    public Long getSelfWithholdingLimit() { return selfWithholdingLimit; }
    public DocumentType setSelfWithholdingLimit(Long value) { this.selfWithholdingLimit = value; return this; }
    public String getElectronicType() { return electronicType; }
    public DocumentType setElectronicType(String value) { this.electronicType = value; return this; }
    public String getOfficialBook() { return officialBook; }
    public DocumentType setOfficialBook(String value) { this.officialBook = value; return this; }
    public Boolean getDocumentSupport() { return documentSupport; }
    public DocumentType setDocumentSupport(Boolean value) { this.documentSupport = value; return this; }
    public String getPrefix() { return prefix; }
    public DocumentType setPrefix(String value) { this.prefix = value; return this; }
    public List<DocumentTypeGlobalDiscount> getGlobalDiscounts() { return globalDiscounts; }
    public DocumentType setGlobalDiscounts(List<DocumentTypeGlobalDiscount> value) { this.globalDiscounts = value; return this; }
    public List<DocumentTypeGlobalCharge> getGlobalCharges() { return globalCharges; }
    public DocumentType setGlobalCharges(List<DocumentTypeGlobalCharge> value) { this.globalCharges = value; return this; }
}
