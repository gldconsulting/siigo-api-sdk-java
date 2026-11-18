package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/** Siigo request; optional fields are omitted when unset. */
public class CreditNoteRequest extends ApiModel {
    @JsonProperty("document") private CreditNoteRequestDocument document;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("invoice") private String invoice;
    @JsonProperty("items") private List<CreditNoteRequestItem> items;
    @JsonProperty("payments") private List<CreditNoteRequestPayment> payments;
    @JsonProperty("number") private Long number;
    @JsonProperty("name") private String name;
    @JsonProperty("reason") private JsonNode reason;
    @JsonProperty("seller") private Long seller;
    @JsonProperty("cost_center") private Long costCenter;
    @JsonProperty("currency") private CreditNoteRequestCurrency currency;
    @JsonProperty("retentions") private List<CreditNoteRequestRetention> retentions;
    @JsonProperty("advance_payment") private BigDecimal advancePayment;
    @JsonProperty("observations") private String observations;
    @JsonProperty("customer") private CreditNoteRequestCustomer customer;
    @JsonProperty("invoice_data") private CreditNoteRequestInvoiceData invoiceData;
    @JsonProperty("healthcare_company") private CreditNoteRequestHealthcareCompany healthcareCompany;

    public CreditNoteRequestDocument getDocument() { return document; }
    public CreditNoteRequest setDocument(CreditNoteRequestDocument value) { this.document = value; return this; }
    public LocalDate getDate() { return date; }
    public CreditNoteRequest setDate(LocalDate value) { this.date = value; return this; }
    public String getInvoice() { return invoice; }
    public CreditNoteRequest setInvoice(String value) { this.invoice = value; return this; }
    public List<CreditNoteRequestItem> getItems() { return items; }
    public CreditNoteRequest setItems(List<CreditNoteRequestItem> value) { this.items = value; return this; }
    public List<CreditNoteRequestPayment> getPayments() { return payments; }
    public CreditNoteRequest setPayments(List<CreditNoteRequestPayment> value) { this.payments = value; return this; }
    public Long getNumber() { return number; }
    public CreditNoteRequest setNumber(Long value) { this.number = value; return this; }
    public String getName() { return name; }
    public CreditNoteRequest setName(String value) { this.name = value; return this; }
    public JsonNode getReason() { return reason; }
    public CreditNoteRequest setReason(JsonNode value) { this.reason = value; return this; }
    public Long getSeller() { return seller; }
    public CreditNoteRequest setSeller(Long value) { this.seller = value; return this; }
    public Long getCostCenter() { return costCenter; }
    public CreditNoteRequest setCostCenter(Long value) { this.costCenter = value; return this; }
    public CreditNoteRequestCurrency getCurrency() { return currency; }
    public CreditNoteRequest setCurrency(CreditNoteRequestCurrency value) { this.currency = value; return this; }
    public List<CreditNoteRequestRetention> getRetentions() { return retentions; }
    public CreditNoteRequest setRetentions(List<CreditNoteRequestRetention> value) { this.retentions = value; return this; }
    public BigDecimal getAdvancePayment() { return advancePayment; }
    public CreditNoteRequest setAdvancePayment(BigDecimal value) { this.advancePayment = value; return this; }
    public String getObservations() { return observations; }
    public CreditNoteRequest setObservations(String value) { this.observations = value; return this; }
    public CreditNoteRequestCustomer getCustomer() { return customer; }
    public CreditNoteRequest setCustomer(CreditNoteRequestCustomer value) { this.customer = value; return this; }
    public CreditNoteRequestInvoiceData getInvoiceData() { return invoiceData; }
    public CreditNoteRequest setInvoiceData(CreditNoteRequestInvoiceData value) { this.invoiceData = value; return this; }
    public CreditNoteRequestHealthcareCompany getHealthcareCompany() { return healthcareCompany; }
    public CreditNoteRequest setHealthcareCompany(CreditNoteRequestHealthcareCompany value) { this.healthcareCompany = value; return this; }
}
