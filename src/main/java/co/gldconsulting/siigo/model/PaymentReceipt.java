package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class PaymentReceipt extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("document") private PaymentReceiptDocument document;
    @JsonProperty("number") private Long number;
    @JsonProperty("name") private String name;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("type") private String type;
    @JsonProperty("supplier") private PaymentReceiptSupplier supplier;
    @JsonProperty("currency") private PaymentReceiptCurrency currency;
    @JsonProperty("items") private List<PaymentReceiptItem> items;
    @JsonProperty("payment") private PaymentReceiptPayment payment;
    @JsonProperty("balance") private BigDecimal balance;
    @JsonProperty("observations") private String observations;
    @JsonProperty("metadata") private PaymentReceiptMetadata metadata;

    public String getId() { return id; }
    public PaymentReceipt setId(String value) { this.id = value; return this; }
    public PaymentReceiptDocument getDocument() { return document; }
    public PaymentReceipt setDocument(PaymentReceiptDocument value) { this.document = value; return this; }
    public Long getNumber() { return number; }
    public PaymentReceipt setNumber(Long value) { this.number = value; return this; }
    public String getName() { return name; }
    public PaymentReceipt setName(String value) { this.name = value; return this; }
    public LocalDate getDate() { return date; }
    public PaymentReceipt setDate(LocalDate value) { this.date = value; return this; }
    public String getType() { return type; }
    public PaymentReceipt setType(String value) { this.type = value; return this; }
    public PaymentReceiptSupplier getSupplier() { return supplier; }
    public PaymentReceipt setSupplier(PaymentReceiptSupplier value) { this.supplier = value; return this; }
    public PaymentReceiptCurrency getCurrency() { return currency; }
    public PaymentReceipt setCurrency(PaymentReceiptCurrency value) { this.currency = value; return this; }
    public List<PaymentReceiptItem> getItems() { return items; }
    public PaymentReceipt setItems(List<PaymentReceiptItem> value) { this.items = value; return this; }
    public PaymentReceiptPayment getPayment() { return payment; }
    public PaymentReceipt setPayment(PaymentReceiptPayment value) { this.payment = value; return this; }
    public BigDecimal getBalance() { return balance; }
    public PaymentReceipt setBalance(BigDecimal value) { this.balance = value; return this; }
    public String getObservations() { return observations; }
    public PaymentReceipt setObservations(String value) { this.observations = value; return this; }
    public PaymentReceiptMetadata getMetadata() { return metadata; }
    public PaymentReceipt setMetadata(PaymentReceiptMetadata value) { this.metadata = value; return this; }
}
