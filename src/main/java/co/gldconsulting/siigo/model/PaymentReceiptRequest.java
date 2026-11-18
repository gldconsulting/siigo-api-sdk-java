package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.List;

/** Siigo request; optional fields are omitted when unset. */
public class PaymentReceiptRequest extends ApiModel {
    @JsonProperty("document") private PaymentReceiptRequestDocument document;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("type") private String type;
    @JsonProperty("supplier") private PaymentReceiptRequestSupplier supplier;
    @JsonProperty("cost_center") private Long costCenter;
    @JsonProperty("items") private List<PaymentReceiptRequestItem> items;
    @JsonProperty("observations") private String observations;
    @JsonProperty("payment") private PaymentReceiptRequestPayment payment;

    public PaymentReceiptRequestDocument getDocument() { return document; }
    public PaymentReceiptRequest setDocument(PaymentReceiptRequestDocument value) { this.document = value; return this; }
    public LocalDate getDate() { return date; }
    public PaymentReceiptRequest setDate(LocalDate value) { this.date = value; return this; }
    public String getType() { return type; }
    public PaymentReceiptRequest setType(String value) { this.type = value; return this; }
    public PaymentReceiptRequestSupplier getSupplier() { return supplier; }
    public PaymentReceiptRequest setSupplier(PaymentReceiptRequestSupplier value) { this.supplier = value; return this; }
    public Long getCostCenter() { return costCenter; }
    public PaymentReceiptRequest setCostCenter(Long value) { this.costCenter = value; return this; }
    public List<PaymentReceiptRequestItem> getItems() { return items; }
    public PaymentReceiptRequest setItems(List<PaymentReceiptRequestItem> value) { this.items = value; return this; }
    public String getObservations() { return observations; }
    public PaymentReceiptRequest setObservations(String value) { this.observations = value; return this; }
    public PaymentReceiptRequestPayment getPayment() { return payment; }
    public PaymentReceiptRequest setPayment(PaymentReceiptRequestPayment value) { this.payment = value; return this; }
}
