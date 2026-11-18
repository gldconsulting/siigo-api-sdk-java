package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceBatchRequestInvoiceAdditionalFields extends ApiModel {
    @JsonProperty("purchase_order") private InvoiceBatchRequestInvoiceAdditionalFieldsPurchaseOrder purchaseOrder;
    @JsonProperty("delivery_order") private InvoiceBatchRequestInvoiceAdditionalFieldsDeliveryOrder deliveryOrder;

    public InvoiceBatchRequestInvoiceAdditionalFieldsPurchaseOrder getPurchaseOrder() { return purchaseOrder; }
    public InvoiceBatchRequestInvoiceAdditionalFields setPurchaseOrder(InvoiceBatchRequestInvoiceAdditionalFieldsPurchaseOrder value) { this.purchaseOrder = value; return this; }
    public InvoiceBatchRequestInvoiceAdditionalFieldsDeliveryOrder getDeliveryOrder() { return deliveryOrder; }
    public InvoiceBatchRequestInvoiceAdditionalFields setDeliveryOrder(InvoiceBatchRequestInvoiceAdditionalFieldsDeliveryOrder value) { this.deliveryOrder = value; return this; }
}
