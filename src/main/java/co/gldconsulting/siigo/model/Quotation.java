package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class Quotation extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("document") private QuotationDocument document;
    @JsonProperty("number") private Long number;
    @JsonProperty("name") private String name;
    @JsonProperty("date") private LocalDate date;
    @JsonProperty("customer") private QuotationCustomer customer;
    @JsonProperty("cost_center") private Long costCenter;
    @JsonProperty("currency") private QuotationCurrency currency;
    @JsonProperty("total") private BigDecimal total;
    @JsonProperty("seller") private Long seller;
    @JsonProperty("items") private List<QuotationItem> items;
    @JsonProperty("public_url") private String publicUrl;
    @JsonProperty("metadata") private QuotationMetadata metadata;

    public String getId() { return id; }
    public Quotation setId(String value) { this.id = value; return this; }
    public QuotationDocument getDocument() { return document; }
    public Quotation setDocument(QuotationDocument value) { this.document = value; return this; }
    public Long getNumber() { return number; }
    public Quotation setNumber(Long value) { this.number = value; return this; }
    public String getName() { return name; }
    public Quotation setName(String value) { this.name = value; return this; }
    public LocalDate getDate() { return date; }
    public Quotation setDate(LocalDate value) { this.date = value; return this; }
    public QuotationCustomer getCustomer() { return customer; }
    public Quotation setCustomer(QuotationCustomer value) { this.customer = value; return this; }
    public Long getCostCenter() { return costCenter; }
    public Quotation setCostCenter(Long value) { this.costCenter = value; return this; }
    public QuotationCurrency getCurrency() { return currency; }
    public Quotation setCurrency(QuotationCurrency value) { this.currency = value; return this; }
    public BigDecimal getTotal() { return total; }
    public Quotation setTotal(BigDecimal value) { this.total = value; return this; }
    public Long getSeller() { return seller; }
    public Quotation setSeller(Long value) { this.seller = value; return this; }
    public List<QuotationItem> getItems() { return items; }
    public Quotation setItems(List<QuotationItem> value) { this.items = value; return this; }
    public String getPublicUrl() { return publicUrl; }
    public Quotation setPublicUrl(String value) { this.publicUrl = value; return this; }
    public QuotationMetadata getMetadata() { return metadata; }
    public Quotation setMetadata(QuotationMetadata value) { this.metadata = value; return this; }
}
