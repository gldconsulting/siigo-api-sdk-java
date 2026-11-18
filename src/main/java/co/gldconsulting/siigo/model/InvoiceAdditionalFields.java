package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceAdditionalFields extends ApiModel {
    @JsonProperty("purchase_order") private InvoiceAdditionalFieldsPurchaseOrder purchaseOrder;
    @JsonProperty("delivery_order") private InvoiceAdditionalFieldsDeliveryOrder deliveryOrder;

    public InvoiceAdditionalFieldsPurchaseOrder getPurchaseOrder() { return purchaseOrder; }
    public InvoiceAdditionalFields setPurchaseOrder(InvoiceAdditionalFieldsPurchaseOrder value) { this.purchaseOrder = value; return this; }
    public InvoiceAdditionalFieldsDeliveryOrder getDeliveryOrder() { return deliveryOrder; }
    public InvoiceAdditionalFields setDeliveryOrder(InvoiceAdditionalFieldsDeliveryOrder value) { this.deliveryOrder = value; return this; }
}
