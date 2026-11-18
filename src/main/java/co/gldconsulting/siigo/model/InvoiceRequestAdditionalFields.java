package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceRequestAdditionalFields extends ApiModel {
    @JsonProperty("purchase_order") private InvoiceRequestAdditionalFieldsPurchaseOrder purchaseOrder;
    @JsonProperty("delivery_order") private InvoiceRequestAdditionalFieldsDeliveryOrder deliveryOrder;

    public InvoiceRequestAdditionalFieldsPurchaseOrder getPurchaseOrder() { return purchaseOrder; }
    public InvoiceRequestAdditionalFields setPurchaseOrder(InvoiceRequestAdditionalFieldsPurchaseOrder value) { this.purchaseOrder = value; return this; }
    public InvoiceRequestAdditionalFieldsDeliveryOrder getDeliveryOrder() { return deliveryOrder; }
    public InvoiceRequestAdditionalFields setDeliveryOrder(InvoiceRequestAdditionalFieldsDeliveryOrder value) { this.deliveryOrder = value; return this; }
}
