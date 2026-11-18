package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceBatchRequestInvoice extends ApiModel {
    @JsonProperty("document") private InvoiceBatchRequestInvoiceDocument document;
    @JsonProperty("number") private Long number;
    @JsonProperty("name") private String name;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("customer") private InvoiceBatchRequestInvoiceCustomer customer;
    @JsonProperty("cost_center") private Long costCenter;
    @JsonProperty("currency") private InvoiceBatchRequestInvoiceCurrency currency;
    @JsonProperty("seller") private Long seller;
    @JsonProperty("retentions") private List<InvoiceBatchRequestInvoiceRetention> retentions;
    @JsonProperty("advance_payment") private BigDecimal advancePayment;
    @JsonProperty("observations") private String observations;
    @JsonProperty("items") private List<InvoiceBatchRequestInvoiceItem> items;
    @JsonProperty("payments") private List<InvoiceBatchRequestInvoicePayment> payments;
    @JsonProperty("additional_fields") private InvoiceBatchRequestInvoiceAdditionalFields additionalFields;
    @JsonProperty("stamp") private InvoiceBatchRequestInvoiceStamp stamp;
    @JsonProperty("mail") private InvoiceBatchRequestInvoiceMail mail;
    @JsonProperty("global_charges") private List<InvoiceBatchRequestInvoiceGlobalCharge> globalCharges;
    @JsonProperty("global_discounts") private List<InvoiceBatchRequestInvoiceGlobalDiscount> globalDiscounts;
    @JsonProperty("idempotency_key") private String idempotencyKey;

    public InvoiceBatchRequestInvoiceDocument getDocument() { return document; }
    public InvoiceBatchRequestInvoice setDocument(InvoiceBatchRequestInvoiceDocument value) { this.document = value; return this; }
    public Long getNumber() { return number; }
    public InvoiceBatchRequestInvoice setNumber(Long value) { this.number = value; return this; }
    public String getName() { return name; }
    public InvoiceBatchRequestInvoice setName(String value) { this.name = value; return this; }
    public LocalDate getDate() { return date; }
    public InvoiceBatchRequestInvoice setDate(LocalDate value) { this.date = value; return this; }
    public InvoiceBatchRequestInvoiceCustomer getCustomer() { return customer; }
    public InvoiceBatchRequestInvoice setCustomer(InvoiceBatchRequestInvoiceCustomer value) { this.customer = value; return this; }
    public Long getCostCenter() { return costCenter; }
    public InvoiceBatchRequestInvoice setCostCenter(Long value) { this.costCenter = value; return this; }
    public InvoiceBatchRequestInvoiceCurrency getCurrency() { return currency; }
    public InvoiceBatchRequestInvoice setCurrency(InvoiceBatchRequestInvoiceCurrency value) { this.currency = value; return this; }
    public Long getSeller() { return seller; }
    public InvoiceBatchRequestInvoice setSeller(Long value) { this.seller = value; return this; }
    public List<InvoiceBatchRequestInvoiceRetention> getRetentions() { return retentions; }
    public InvoiceBatchRequestInvoice setRetentions(List<InvoiceBatchRequestInvoiceRetention> value) { this.retentions = value; return this; }
    public BigDecimal getAdvancePayment() { return advancePayment; }
    public InvoiceBatchRequestInvoice setAdvancePayment(BigDecimal value) { this.advancePayment = value; return this; }
    public String getObservations() { return observations; }
    public InvoiceBatchRequestInvoice setObservations(String value) { this.observations = value; return this; }
    public List<InvoiceBatchRequestInvoiceItem> getItems() { return items; }
    public InvoiceBatchRequestInvoice setItems(List<InvoiceBatchRequestInvoiceItem> value) { this.items = value; return this; }
    public List<InvoiceBatchRequestInvoicePayment> getPayments() { return payments; }
    public InvoiceBatchRequestInvoice setPayments(List<InvoiceBatchRequestInvoicePayment> value) { this.payments = value; return this; }
    public InvoiceBatchRequestInvoiceAdditionalFields getAdditionalFields() { return additionalFields; }
    public InvoiceBatchRequestInvoice setAdditionalFields(InvoiceBatchRequestInvoiceAdditionalFields value) { this.additionalFields = value; return this; }
    public InvoiceBatchRequestInvoiceStamp getStamp() { return stamp; }
    public InvoiceBatchRequestInvoice setStamp(InvoiceBatchRequestInvoiceStamp value) { this.stamp = value; return this; }
    public InvoiceBatchRequestInvoiceMail getMail() { return mail; }
    public InvoiceBatchRequestInvoice setMail(InvoiceBatchRequestInvoiceMail value) { this.mail = value; return this; }
    public List<InvoiceBatchRequestInvoiceGlobalCharge> getGlobalCharges() { return globalCharges; }
    public InvoiceBatchRequestInvoice setGlobalCharges(List<InvoiceBatchRequestInvoiceGlobalCharge> value) { this.globalCharges = value; return this; }
    public List<InvoiceBatchRequestInvoiceGlobalDiscount> getGlobalDiscounts() { return globalDiscounts; }
    public InvoiceBatchRequestInvoice setGlobalDiscounts(List<InvoiceBatchRequestInvoiceGlobalDiscount> value) { this.globalDiscounts = value; return this; }
    public String getIdempotencyKey() { return idempotencyKey; }
    public InvoiceBatchRequestInvoice setIdempotencyKey(String value) { this.idempotencyKey = value; return this; }
}
