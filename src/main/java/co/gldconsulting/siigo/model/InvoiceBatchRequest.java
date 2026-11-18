package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Siigo request; optional fields are omitted when unset. */
public class InvoiceBatchRequest extends ApiModel {
    @JsonProperty("notification_url") private String notificationUrl;
    @JsonProperty("invoices") private List<InvoiceBatchRequestInvoice> invoices;

    public String getNotificationUrl() { return notificationUrl; }
    public InvoiceBatchRequest setNotificationUrl(String value) { this.notificationUrl = value; return this; }
    public List<InvoiceBatchRequestInvoice> getInvoices() { return invoices; }
    public InvoiceBatchRequest setInvoices(List<InvoiceBatchRequestInvoice> value) { this.invoices = value; return this; }
}
