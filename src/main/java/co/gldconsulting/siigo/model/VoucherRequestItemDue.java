package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class VoucherRequestItemDue extends ApiModel {
    @JsonProperty("prefix") private String prefix;
    @JsonProperty("consecutive") private Long consecutive;
    @JsonProperty("quote") private Long quote;

    public String getPrefix() { return prefix; }
    public VoucherRequestItemDue setPrefix(String value) { this.prefix = value; return this; }
    public Long getConsecutive() { return consecutive; }
    public VoucherRequestItemDue setConsecutive(Long value) { this.consecutive = value; return this; }
    public Long getQuote() { return quote; }
    public VoucherRequestItemDue setQuote(Long value) { this.quote = value; return this; }
}
