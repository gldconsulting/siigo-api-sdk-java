package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class Voucher extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("document") private VoucherDocument document;
    @JsonProperty("number") private Long number;
    @JsonProperty("name") private String name;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("type") private String type;
    @JsonProperty("cost_center") private Long costCenter;
    @JsonProperty("customer") private VoucherCustomer customer;
    @JsonProperty("currency") private VoucherCurrency currency;
    @JsonProperty("items") private List<VoucherItem> items;
    @JsonProperty("payment") private VoucherPayment payment;
    @JsonProperty("observations") private String observations;
    @JsonProperty("metadata") private VoucherMetadata metadata;

    public String getId() { return id; }
    public Voucher setId(String value) { this.id = value; return this; }
    public VoucherDocument getDocument() { return document; }
    public Voucher setDocument(VoucherDocument value) { this.document = value; return this; }
    public Long getNumber() { return number; }
    public Voucher setNumber(Long value) { this.number = value; return this; }
    public String getName() { return name; }
    public Voucher setName(String value) { this.name = value; return this; }
    public LocalDate getDate() { return date; }
    public Voucher setDate(LocalDate value) { this.date = value; return this; }
    public String getType() { return type; }
    public Voucher setType(String value) { this.type = value; return this; }
    public Long getCostCenter() { return costCenter; }
    public Voucher setCostCenter(Long value) { this.costCenter = value; return this; }
    public VoucherCustomer getCustomer() { return customer; }
    public Voucher setCustomer(VoucherCustomer value) { this.customer = value; return this; }
    public VoucherCurrency getCurrency() { return currency; }
    public Voucher setCurrency(VoucherCurrency value) { this.currency = value; return this; }
    public List<VoucherItem> getItems() { return items; }
    public Voucher setItems(List<VoucherItem> value) { this.items = value; return this; }
    public VoucherPayment getPayment() { return payment; }
    public Voucher setPayment(VoucherPayment value) { this.payment = value; return this; }
    public String getObservations() { return observations; }
    public Voucher setObservations(String value) { this.observations = value; return this; }
    public VoucherMetadata getMetadata() { return metadata; }
    public Voucher setMetadata(VoucherMetadata value) { this.metadata = value; return this; }
}
