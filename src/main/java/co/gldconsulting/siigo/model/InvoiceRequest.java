package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/** Siigo request; optional fields are omitted when unset. */
public class InvoiceRequest extends ApiModel {
    @JsonProperty("document") private InvoiceRequestDocument document;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("customer") private InvoiceRequestCustomer customer;
    @JsonProperty("stamp") private InvoiceRequestStamp stamp;
    @JsonProperty("mail") private InvoiceRequestMail mail;
    @JsonProperty("seller") private Long seller;
    @JsonProperty("items") private List<InvoiceRequestItem> items;
    @JsonProperty("payments") private List<InvoiceRequestPayment> payments;
    @JsonProperty("number") private Long number;
    @JsonProperty("name") private String name;
    @JsonProperty("cost_center") private Long costCenter;
    @JsonProperty("currency") private InvoiceRequestCurrency currency;
    @JsonProperty("retentions") private List<InvoiceRequestRetention> retentions;
    @JsonProperty("advance_payment") private BigDecimal advancePayment;
    @JsonProperty("observations") private String observations;
    @JsonProperty("additional_fields") private InvoiceRequestAdditionalFields additionalFields;
    @JsonProperty("global_charges") private List<InvoiceRequestGlobalCharge> globalCharges;
    @JsonProperty("global_discounts") private List<InvoiceRequestGlobalDiscount> globalDiscounts;
    @JsonProperty("healthcare_company") private InvoiceRequestHealthcareCompany healthcareCompany;

    public InvoiceRequestDocument getDocument() { return document; }
    public InvoiceRequest setDocument(InvoiceRequestDocument value) { this.document = value; return this; }
    public LocalDate getDate() { return date; }
    public InvoiceRequest setDate(LocalDate value) { this.date = value; return this; }
    public InvoiceRequestCustomer getCustomer() { return customer; }
    public InvoiceRequest setCustomer(InvoiceRequestCustomer value) { this.customer = value; return this; }
    public InvoiceRequestStamp getStamp() { return stamp; }
    public InvoiceRequest setStamp(InvoiceRequestStamp value) { this.stamp = value; return this; }
    public InvoiceRequestMail getMail() { return mail; }
    public InvoiceRequest setMail(InvoiceRequestMail value) { this.mail = value; return this; }
    public Long getSeller() { return seller; }
    public InvoiceRequest setSeller(Long value) { this.seller = value; return this; }
    public List<InvoiceRequestItem> getItems() { return items; }
    public InvoiceRequest setItems(List<InvoiceRequestItem> value) { this.items = value; return this; }
    public List<InvoiceRequestPayment> getPayments() { return payments; }
    public InvoiceRequest setPayments(List<InvoiceRequestPayment> value) { this.payments = value; return this; }
    public Long getNumber() { return number; }
    public InvoiceRequest setNumber(Long value) { this.number = value; return this; }
    public String getName() { return name; }
    public InvoiceRequest setName(String value) { this.name = value; return this; }
    public Long getCostCenter() { return costCenter; }
    public InvoiceRequest setCostCenter(Long value) { this.costCenter = value; return this; }
    public InvoiceRequestCurrency getCurrency() { return currency; }
    public InvoiceRequest setCurrency(InvoiceRequestCurrency value) { this.currency = value; return this; }
    public List<InvoiceRequestRetention> getRetentions() { return retentions; }
    public InvoiceRequest setRetentions(List<InvoiceRequestRetention> value) { this.retentions = value; return this; }
    public BigDecimal getAdvancePayment() { return advancePayment; }
    public InvoiceRequest setAdvancePayment(BigDecimal value) { this.advancePayment = value; return this; }
    public String getObservations() { return observations; }
    public InvoiceRequest setObservations(String value) { this.observations = value; return this; }
    public InvoiceRequestAdditionalFields getAdditionalFields() { return additionalFields; }
    public InvoiceRequest setAdditionalFields(InvoiceRequestAdditionalFields value) { this.additionalFields = value; return this; }
    public List<InvoiceRequestGlobalCharge> getGlobalCharges() { return globalCharges; }
    public InvoiceRequest setGlobalCharges(List<InvoiceRequestGlobalCharge> value) { this.globalCharges = value; return this; }
    public List<InvoiceRequestGlobalDiscount> getGlobalDiscounts() { return globalDiscounts; }
    public InvoiceRequest setGlobalDiscounts(List<InvoiceRequestGlobalDiscount> value) { this.globalDiscounts = value; return this; }
    public InvoiceRequestHealthcareCompany getHealthcareCompany() { return healthcareCompany; }
    public InvoiceRequest setHealthcareCompany(InvoiceRequestHealthcareCompany value) { this.healthcareCompany = value; return this; }
}
