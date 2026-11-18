package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class Invoice extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("document") private InvoiceDocument document;
    @JsonProperty("prefix") private String prefix;
    @JsonProperty("number") private Long number;
    @JsonProperty("name") private String name;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("customer") private InvoiceCustomer customer;
    @JsonProperty("cost_center") private Long costCenter;
    @JsonProperty("currency") private InvoiceCurrency currency;
    @JsonProperty("seller") private Long seller;
    @JsonProperty("retentions") private List<InvoiceRetention> retentions;
    @JsonProperty("advance_payment") private BigDecimal advancePayment;
    @JsonProperty("total") private BigDecimal total;
    @JsonProperty("balance") private BigDecimal balance;
    @JsonProperty("observations") private String observations;
    @JsonProperty("items") private List<InvoiceItem> items;
    @JsonProperty("global_charges") private List<InvoiceGlobalCharge> globalCharges;
    @JsonProperty("global_discounts") private List<InvoiceGlobalDiscount> globalDiscounts;
    @JsonProperty("payments") private List<InvoicePayment> payments;
    @JsonProperty("additional_fields") private InvoiceAdditionalFields additionalFields;
    @JsonProperty("stamp") private InvoiceStamp stamp;
    @JsonProperty("mail") private InvoiceMail mail;
    @JsonProperty("metadata") private InvoiceMetadata metadata;
    @JsonProperty("annulled") private Boolean annulled;

    public String getId() { return id; }
    public Invoice setId(String value) { this.id = value; return this; }
    public InvoiceDocument getDocument() { return document; }
    public Invoice setDocument(InvoiceDocument value) { this.document = value; return this; }
    public String getPrefix() { return prefix; }
    public Invoice setPrefix(String value) { this.prefix = value; return this; }
    public Long getNumber() { return number; }
    public Invoice setNumber(Long value) { this.number = value; return this; }
    public String getName() { return name; }
    public Invoice setName(String value) { this.name = value; return this; }
    public LocalDate getDate() { return date; }
    public Invoice setDate(LocalDate value) { this.date = value; return this; }
    public InvoiceCustomer getCustomer() { return customer; }
    public Invoice setCustomer(InvoiceCustomer value) { this.customer = value; return this; }
    public Long getCostCenter() { return costCenter; }
    public Invoice setCostCenter(Long value) { this.costCenter = value; return this; }
    public InvoiceCurrency getCurrency() { return currency; }
    public Invoice setCurrency(InvoiceCurrency value) { this.currency = value; return this; }
    public Long getSeller() { return seller; }
    public Invoice setSeller(Long value) { this.seller = value; return this; }
    public List<InvoiceRetention> getRetentions() { return retentions; }
    public Invoice setRetentions(List<InvoiceRetention> value) { this.retentions = value; return this; }
    public BigDecimal getAdvancePayment() { return advancePayment; }
    public Invoice setAdvancePayment(BigDecimal value) { this.advancePayment = value; return this; }
    public BigDecimal getTotal() { return total; }
    public Invoice setTotal(BigDecimal value) { this.total = value; return this; }
    public BigDecimal getBalance() { return balance; }
    public Invoice setBalance(BigDecimal value) { this.balance = value; return this; }
    public String getObservations() { return observations; }
    public Invoice setObservations(String value) { this.observations = value; return this; }
    public List<InvoiceItem> getItems() { return items; }
    public Invoice setItems(List<InvoiceItem> value) { this.items = value; return this; }
    public List<InvoiceGlobalCharge> getGlobalCharges() { return globalCharges; }
    public Invoice setGlobalCharges(List<InvoiceGlobalCharge> value) { this.globalCharges = value; return this; }
    public List<InvoiceGlobalDiscount> getGlobalDiscounts() { return globalDiscounts; }
    public Invoice setGlobalDiscounts(List<InvoiceGlobalDiscount> value) { this.globalDiscounts = value; return this; }
    public List<InvoicePayment> getPayments() { return payments; }
    public Invoice setPayments(List<InvoicePayment> value) { this.payments = value; return this; }
    public InvoiceAdditionalFields getAdditionalFields() { return additionalFields; }
    public Invoice setAdditionalFields(InvoiceAdditionalFields value) { this.additionalFields = value; return this; }
    public InvoiceStamp getStamp() { return stamp; }
    public Invoice setStamp(InvoiceStamp value) { this.stamp = value; return this; }
    public InvoiceMail getMail() { return mail; }
    public Invoice setMail(InvoiceMail value) { this.mail = value; return this; }
    public InvoiceMetadata getMetadata() { return metadata; }
    public Invoice setMetadata(InvoiceMetadata value) { this.metadata = value; return this; }
    public Boolean getAnnulled() { return annulled; }
    public Invoice setAnnulled(Boolean value) { this.annulled = value; return this; }
}
