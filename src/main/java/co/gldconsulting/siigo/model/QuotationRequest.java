package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.List;

/** Siigo request; optional fields are omitted when unset. */
public class QuotationRequest extends ApiModel {
    @JsonProperty("document") private QuotationRequestDocument document;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("customer") private QuotationRequestCustomer customer;
    @JsonProperty("cost_center") private Long costCenter;
    @JsonProperty("currency") private QuotationRequestCurrency currency;
    @JsonProperty("seller") private Long seller;
    @JsonProperty("items") private List<QuotationRequestItem> items;

    public QuotationRequestDocument getDocument() { return document; }
    public QuotationRequest setDocument(QuotationRequestDocument value) { this.document = value; return this; }
    public LocalDate getDate() { return date; }
    public QuotationRequest setDate(LocalDate value) { this.date = value; return this; }
    public QuotationRequestCustomer getCustomer() { return customer; }
    public QuotationRequest setCustomer(QuotationRequestCustomer value) { this.customer = value; return this; }
    public Long getCostCenter() { return costCenter; }
    public QuotationRequest setCostCenter(Long value) { this.costCenter = value; return this; }
    public QuotationRequestCurrency getCurrency() { return currency; }
    public QuotationRequest setCurrency(QuotationRequestCurrency value) { this.currency = value; return this; }
    public Long getSeller() { return seller; }
    public QuotationRequest setSeller(Long value) { this.seller = value; return this; }
    public List<QuotationRequestItem> getItems() { return items; }
    public QuotationRequest setItems(List<QuotationRequestItem> value) { this.items = value; return this; }
}
