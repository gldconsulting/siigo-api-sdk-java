package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceRequestItemTransport extends ApiModel {
    @JsonProperty("file_number") private Long fileNumber;
    @JsonProperty("shipment_number") private String shipmentNumber;
    @JsonProperty("transported_quantity") private Long transportedQuantity;
    @JsonProperty("measurement_unit") private String measurementUnit;
    @JsonProperty("freight_value") private Long freightValue;
    @JsonProperty("purchase_order") private String purchaseOrder;
    @JsonProperty("service_type") private String serviceType;

    public Long getFileNumber() { return fileNumber; }
    public InvoiceRequestItemTransport setFileNumber(Long value) { this.fileNumber = value; return this; }
    public String getShipmentNumber() { return shipmentNumber; }
    public InvoiceRequestItemTransport setShipmentNumber(String value) { this.shipmentNumber = value; return this; }
    public Long getTransportedQuantity() { return transportedQuantity; }
    public InvoiceRequestItemTransport setTransportedQuantity(Long value) { this.transportedQuantity = value; return this; }
    public String getMeasurementUnit() { return measurementUnit; }
    public InvoiceRequestItemTransport setMeasurementUnit(String value) { this.measurementUnit = value; return this; }
    public Long getFreightValue() { return freightValue; }
    public InvoiceRequestItemTransport setFreightValue(Long value) { this.freightValue = value; return this; }
    public String getPurchaseOrder() { return purchaseOrder; }
    public InvoiceRequestItemTransport setPurchaseOrder(String value) { this.purchaseOrder = value; return this; }
    public String getServiceType() { return serviceType; }
    public InvoiceRequestItemTransport setServiceType(String value) { this.serviceType = value; return this; }
}
