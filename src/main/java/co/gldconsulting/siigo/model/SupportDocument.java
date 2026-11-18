package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class SupportDocument extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("document") private SupportDocumentDocument document;
    @JsonProperty("number") private Long number;
    @JsonProperty("name") private String name;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("supplier") private SupportDocumentSupplier supplier;
    @JsonProperty("cost_center") private Long costCenter;
    @JsonProperty("discount_type") private String discountType;
    @JsonProperty("currency") private SupportDocumentCurrency currency;
    @JsonProperty("total") private BigDecimal total;
    @JsonProperty("balance") private BigDecimal balance;
    @JsonProperty("observations") private String observations;
    @JsonProperty("items") private List<SupportDocumentItem> items;
    @JsonProperty("payments") private List<SupportDocumentPayment> payments;
    @JsonProperty("metadata") private SupportDocumentMetadata metadata;

    public String getId() { return id; }
    public SupportDocument setId(String value) { this.id = value; return this; }
    public SupportDocumentDocument getDocument() { return document; }
    public SupportDocument setDocument(SupportDocumentDocument value) { this.document = value; return this; }
    public Long getNumber() { return number; }
    public SupportDocument setNumber(Long value) { this.number = value; return this; }
    public String getName() { return name; }
    public SupportDocument setName(String value) { this.name = value; return this; }
    public LocalDate getDate() { return date; }
    public SupportDocument setDate(LocalDate value) { this.date = value; return this; }
    public SupportDocumentSupplier getSupplier() { return supplier; }
    public SupportDocument setSupplier(SupportDocumentSupplier value) { this.supplier = value; return this; }
    public Long getCostCenter() { return costCenter; }
    public SupportDocument setCostCenter(Long value) { this.costCenter = value; return this; }
    public String getDiscountType() { return discountType; }
    public SupportDocument setDiscountType(String value) { this.discountType = value; return this; }
    public SupportDocumentCurrency getCurrency() { return currency; }
    public SupportDocument setCurrency(SupportDocumentCurrency value) { this.currency = value; return this; }
    public BigDecimal getTotal() { return total; }
    public SupportDocument setTotal(BigDecimal value) { this.total = value; return this; }
    public BigDecimal getBalance() { return balance; }
    public SupportDocument setBalance(BigDecimal value) { this.balance = value; return this; }
    public String getObservations() { return observations; }
    public SupportDocument setObservations(String value) { this.observations = value; return this; }
    public List<SupportDocumentItem> getItems() { return items; }
    public SupportDocument setItems(List<SupportDocumentItem> value) { this.items = value; return this; }
    public List<SupportDocumentPayment> getPayments() { return payments; }
    public SupportDocument setPayments(List<SupportDocumentPayment> value) { this.payments = value; return this; }
    public SupportDocumentMetadata getMetadata() { return metadata; }
    public SupportDocument setMetadata(SupportDocumentMetadata value) { this.metadata = value; return this; }
}
