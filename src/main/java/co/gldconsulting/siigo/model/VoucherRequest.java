package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.List;

/** Siigo request; optional fields are omitted when unset. */
public class VoucherRequest extends ApiModel {
    @JsonProperty("document") private VoucherRequestDocument document;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("type") private String type;
    @JsonProperty("customer") private VoucherRequestCustomer customer;
    @JsonProperty("items") private List<VoucherRequestItem> items;
    @JsonProperty("payment") private VoucherRequestPayment payment;
    @JsonProperty("observations") private String observations;
    @JsonProperty("income") private VoucherRequestIncome income;
    @JsonProperty("currency") private VoucherRequestCurrency currency;

    public VoucherRequestDocument getDocument() { return document; }
    public VoucherRequest setDocument(VoucherRequestDocument value) { this.document = value; return this; }
    public LocalDate getDate() { return date; }
    public VoucherRequest setDate(LocalDate value) { this.date = value; return this; }
    public String getType() { return type; }
    public VoucherRequest setType(String value) { this.type = value; return this; }
    public VoucherRequestCustomer getCustomer() { return customer; }
    public VoucherRequest setCustomer(VoucherRequestCustomer value) { this.customer = value; return this; }
    public List<VoucherRequestItem> getItems() { return items; }
    public VoucherRequest setItems(List<VoucherRequestItem> value) { this.items = value; return this; }
    public VoucherRequestPayment getPayment() { return payment; }
    public VoucherRequest setPayment(VoucherRequestPayment value) { this.payment = value; return this; }
    public String getObservations() { return observations; }
    public VoucherRequest setObservations(String value) { this.observations = value; return this; }
    public VoucherRequestIncome getIncome() { return income; }
    public VoucherRequest setIncome(VoucherRequestIncome value) { this.income = value; return this; }
    public VoucherRequestCurrency getCurrency() { return currency; }
    public VoucherRequest setCurrency(VoucherRequestCurrency value) { this.currency = value; return this; }
}
