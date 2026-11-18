package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.List;

/** Siigo request; optional fields are omitted when unset. */
public class SupportDocumentRequest extends ApiModel {
    @JsonProperty("document") private SupportDocumentRequestDocument document;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("supplier") private SupportDocumentRequestSupplier supplier;
    @JsonProperty("cost_center") private Long costCenter;
    @JsonProperty("supplier_receipt_number") private SupportDocumentRequestSupplierReceiptNumber supplierReceiptNumber;
    @JsonProperty("currency") private SupportDocumentRequestCurrency currency;
    @JsonProperty("observations") private String observations;
    @JsonProperty("discount_type") private String discountType;
    @JsonProperty("stamp") private SupportDocumentRequestStamp stamp;
    @JsonProperty("items") private List<SupportDocumentRequestItem> items;
    @JsonProperty("payments") private List<SupportDocumentRequestPayment> payments;

    public SupportDocumentRequestDocument getDocument() { return document; }
    public SupportDocumentRequest setDocument(SupportDocumentRequestDocument value) { this.document = value; return this; }
    public LocalDate getDate() { return date; }
    public SupportDocumentRequest setDate(LocalDate value) { this.date = value; return this; }
    public SupportDocumentRequestSupplier getSupplier() { return supplier; }
    public SupportDocumentRequest setSupplier(SupportDocumentRequestSupplier value) { this.supplier = value; return this; }
    public Long getCostCenter() { return costCenter; }
    public SupportDocumentRequest setCostCenter(Long value) { this.costCenter = value; return this; }
    public SupportDocumentRequestSupplierReceiptNumber getSupplierReceiptNumber() { return supplierReceiptNumber; }
    public SupportDocumentRequest setSupplierReceiptNumber(SupportDocumentRequestSupplierReceiptNumber value) { this.supplierReceiptNumber = value; return this; }
    public SupportDocumentRequestCurrency getCurrency() { return currency; }
    public SupportDocumentRequest setCurrency(SupportDocumentRequestCurrency value) { this.currency = value; return this; }
    public String getObservations() { return observations; }
    public SupportDocumentRequest setObservations(String value) { this.observations = value; return this; }
    public String getDiscountType() { return discountType; }
    public SupportDocumentRequest setDiscountType(String value) { this.discountType = value; return this; }
    public SupportDocumentRequestStamp getStamp() { return stamp; }
    public SupportDocumentRequest setStamp(SupportDocumentRequestStamp value) { this.stamp = value; return this; }
    public List<SupportDocumentRequestItem> getItems() { return items; }
    public SupportDocumentRequest setItems(List<SupportDocumentRequestItem> value) { this.items = value; return this; }
    public List<SupportDocumentRequestPayment> getPayments() { return payments; }
    public SupportDocumentRequest setPayments(List<SupportDocumentRequestPayment> value) { this.payments = value; return this; }
}
