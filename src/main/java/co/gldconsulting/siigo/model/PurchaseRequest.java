package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.List;

/** Siigo request; optional fields are omitted when unset. */
public class PurchaseRequest extends ApiModel {
    @JsonProperty("document") private PurchaseRequestDocument document;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("supplier") private PurchaseRequestSupplier supplier;
    @JsonProperty("provider_invoice") private PurchaseRequestProviderInvoice providerInvoice;
    @JsonProperty("items") private List<PurchaseRequestItem> items;
    @JsonProperty("payments") private List<PurchaseRequestPayment> payments;

    public PurchaseRequestDocument getDocument() { return document; }
    public PurchaseRequest setDocument(PurchaseRequestDocument value) { this.document = value; return this; }
    public LocalDate getDate() { return date; }
    public PurchaseRequest setDate(LocalDate value) { this.date = value; return this; }
    public PurchaseRequestSupplier getSupplier() { return supplier; }
    public PurchaseRequest setSupplier(PurchaseRequestSupplier value) { this.supplier = value; return this; }
    public PurchaseRequestProviderInvoice getProviderInvoice() { return providerInvoice; }
    public PurchaseRequest setProviderInvoice(PurchaseRequestProviderInvoice value) { this.providerInvoice = value; return this; }
    public List<PurchaseRequestItem> getItems() { return items; }
    public PurchaseRequest setItems(List<PurchaseRequestItem> value) { this.items = value; return this; }
    public List<PurchaseRequestPayment> getPayments() { return payments; }
    public PurchaseRequest setPayments(List<PurchaseRequestPayment> value) { this.payments = value; return this; }
}
