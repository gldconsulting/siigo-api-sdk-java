package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo request; optional fields are omitted when unset. */
public class ThirdPartyTestBalanceRequest extends ApiModel {
    @JsonProperty("account_start") private String accountStart;
    @JsonProperty("account_end") private String accountEnd;
    @JsonProperty("year") private Long year;
    @JsonProperty("month_start") private Long monthStart;
    @JsonProperty("month_end") private Long monthEnd;
    @JsonProperty("includes_tax_difference") private Boolean includesTaxDifference;
    @JsonProperty("customer") private ThirdPartyTestBalanceRequestCustomer customer;

    public String getAccountStart() { return accountStart; }
    public ThirdPartyTestBalanceRequest setAccountStart(String value) { this.accountStart = value; return this; }
    public String getAccountEnd() { return accountEnd; }
    public ThirdPartyTestBalanceRequest setAccountEnd(String value) { this.accountEnd = value; return this; }
    public Long getYear() { return year; }
    public ThirdPartyTestBalanceRequest setYear(Long value) { this.year = value; return this; }
    public Long getMonthStart() { return monthStart; }
    public ThirdPartyTestBalanceRequest setMonthStart(Long value) { this.monthStart = value; return this; }
    public Long getMonthEnd() { return monthEnd; }
    public ThirdPartyTestBalanceRequest setMonthEnd(Long value) { this.monthEnd = value; return this; }
    public Boolean getIncludesTaxDifference() { return includesTaxDifference; }
    public ThirdPartyTestBalanceRequest setIncludesTaxDifference(Boolean value) { this.includesTaxDifference = value; return this; }
    public ThirdPartyTestBalanceRequestCustomer getCustomer() { return customer; }
    public ThirdPartyTestBalanceRequest setCustomer(ThirdPartyTestBalanceRequestCustomer value) { this.customer = value; return this; }
}
