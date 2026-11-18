package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo request; optional fields are omitted when unset. */
public class TestBalanceRequest extends ApiModel {
    @JsonProperty("account_start") private String accountStart;
    @JsonProperty("account_end") private String accountEnd;
    @JsonProperty("year") private Long year;
    @JsonProperty("month_start") private Long monthStart;
    @JsonProperty("month_end") private Long monthEnd;
    @JsonProperty("includes_tax_difference") private Boolean includesTaxDifference;

    public String getAccountStart() { return accountStart; }
    public TestBalanceRequest setAccountStart(String value) { this.accountStart = value; return this; }
    public String getAccountEnd() { return accountEnd; }
    public TestBalanceRequest setAccountEnd(String value) { this.accountEnd = value; return this; }
    public Long getYear() { return year; }
    public TestBalanceRequest setYear(Long value) { this.year = value; return this; }
    public Long getMonthStart() { return monthStart; }
    public TestBalanceRequest setMonthStart(Long value) { this.monthStart = value; return this; }
    public Long getMonthEnd() { return monthEnd; }
    public TestBalanceRequest setMonthEnd(Long value) { this.monthEnd = value; return this; }
    public Boolean getIncludesTaxDifference() { return includesTaxDifference; }
    public TestBalanceRequest setIncludesTaxDifference(Boolean value) { this.includesTaxDifference = value; return this; }
}
