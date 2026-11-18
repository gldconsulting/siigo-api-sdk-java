package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class Purchase extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("document") private PurchaseDocument document;
    @JsonProperty("number") private Long number;
    @JsonProperty("name") private String name;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("supplier") private PurchaseSupplier supplier;
    @JsonProperty("total") private BigDecimal total;
    @JsonProperty("balance") private BigDecimal balance;
    @JsonProperty("provider_invoice") private PurchaseProviderInvoice providerInvoice;
    @JsonProperty("items") private List<PurchaseItem> items;
    @JsonProperty("payments") private List<PurchasePayment> payments;
    @JsonProperty("metadata") private PurchaseMetadata metadata;

    public String getId() { return id; }
    public Purchase setId(String value) { this.id = value; return this; }
    public PurchaseDocument getDocument() { return document; }
    public Purchase setDocument(PurchaseDocument value) { this.document = value; return this; }
    public Long getNumber() { return number; }
    public Purchase setNumber(Long value) { this.number = value; return this; }
    public String getName() { return name; }
    public Purchase setName(String value) { this.name = value; return this; }
    public LocalDate getDate() { return date; }
    public Purchase setDate(LocalDate value) { this.date = value; return this; }
    public PurchaseSupplier getSupplier() { return supplier; }
    public Purchase setSupplier(PurchaseSupplier value) { this.supplier = value; return this; }
    public BigDecimal getTotal() { return total; }
    public Purchase setTotal(BigDecimal value) { this.total = value; return this; }
    public BigDecimal getBalance() { return balance; }
    public Purchase setBalance(BigDecimal value) { this.balance = value; return this; }
    public PurchaseProviderInvoice getProviderInvoice() { return providerInvoice; }
    public Purchase setProviderInvoice(PurchaseProviderInvoice value) { this.providerInvoice = value; return this; }
    public List<PurchaseItem> getItems() { return items; }
    public Purchase setItems(List<PurchaseItem> value) { this.items = value; return this; }
    public List<PurchasePayment> getPayments() { return payments; }
    public Purchase setPayments(List<PurchasePayment> value) { this.payments = value; return this; }
    public PurchaseMetadata getMetadata() { return metadata; }
    public Purchase setMetadata(PurchaseMetadata value) { this.metadata = value; return this; }
}
