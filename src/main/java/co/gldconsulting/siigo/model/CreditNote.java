package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class CreditNote extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("document") private CreditNoteDocument document;
    @JsonProperty("number") private Long number;
    @JsonProperty("name") private String name;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("invoice") private CreditNoteInvoice invoice;
    @JsonProperty("customer") private CreditNoteCustomer customer;
    @JsonProperty("cost_center") private Long costCenter;
    @JsonProperty("currency") private CreditNoteCurrency currency;
    @JsonProperty("seller") private Long seller;
    @JsonProperty("retentions") private List<CreditNoteRetention> retentions;
    @JsonProperty("advance_payment") private BigDecimal advancePayment;
    @JsonProperty("total") private BigDecimal total;
    @JsonProperty("observations") private String observations;
    @JsonProperty("items") private List<CreditNoteItem> items;
    @JsonProperty("payments") private List<CreditNotePayment> payments;
    @JsonProperty("stamp") private CreditNoteStamp stamp;
    @JsonProperty("metadata") private CreditNoteMetadata metadata;

    public String getId() { return id; }
    public CreditNote setId(String value) { this.id = value; return this; }
    public CreditNoteDocument getDocument() { return document; }
    public CreditNote setDocument(CreditNoteDocument value) { this.document = value; return this; }
    public Long getNumber() { return number; }
    public CreditNote setNumber(Long value) { this.number = value; return this; }
    public String getName() { return name; }
    public CreditNote setName(String value) { this.name = value; return this; }
    public LocalDate getDate() { return date; }
    public CreditNote setDate(LocalDate value) { this.date = value; return this; }
    public CreditNoteInvoice getInvoice() { return invoice; }
    public CreditNote setInvoice(CreditNoteInvoice value) { this.invoice = value; return this; }
    public CreditNoteCustomer getCustomer() { return customer; }
    public CreditNote setCustomer(CreditNoteCustomer value) { this.customer = value; return this; }
    public Long getCostCenter() { return costCenter; }
    public CreditNote setCostCenter(Long value) { this.costCenter = value; return this; }
    public CreditNoteCurrency getCurrency() { return currency; }
    public CreditNote setCurrency(CreditNoteCurrency value) { this.currency = value; return this; }
    public Long getSeller() { return seller; }
    public CreditNote setSeller(Long value) { this.seller = value; return this; }
    public List<CreditNoteRetention> getRetentions() { return retentions; }
    public CreditNote setRetentions(List<CreditNoteRetention> value) { this.retentions = value; return this; }
    public BigDecimal getAdvancePayment() { return advancePayment; }
    public CreditNote setAdvancePayment(BigDecimal value) { this.advancePayment = value; return this; }
    public BigDecimal getTotal() { return total; }
    public CreditNote setTotal(BigDecimal value) { this.total = value; return this; }
    public String getObservations() { return observations; }
    public CreditNote setObservations(String value) { this.observations = value; return this; }
    public List<CreditNoteItem> getItems() { return items; }
    public CreditNote setItems(List<CreditNoteItem> value) { this.items = value; return this; }
    public List<CreditNotePayment> getPayments() { return payments; }
    public CreditNote setPayments(List<CreditNotePayment> value) { this.payments = value; return this; }
    public CreditNoteStamp getStamp() { return stamp; }
    public CreditNote setStamp(CreditNoteStamp value) { this.stamp = value; return this; }
    public CreditNoteMetadata getMetadata() { return metadata; }
    public CreditNote setMetadata(CreditNoteMetadata value) { this.metadata = value; return this; }
}
