package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class AccountPayableDue extends ApiModel {
    @JsonProperty("prefix") private String prefix;
    @JsonProperty("consecutive") private Long consecutive;
    @JsonProperty("quote") private Long quote;
    @JsonProperty("date") private String date;
    @JsonProperty("balance") private BigDecimal balance;

    public String getPrefix() { return prefix; }
    public AccountPayableDue setPrefix(String value) { this.prefix = value; return this; }
    public Long getConsecutive() { return consecutive; }
    public AccountPayableDue setConsecutive(Long value) { this.consecutive = value; return this; }
    public Long getQuote() { return quote; }
    public AccountPayableDue setQuote(Long value) { this.quote = value; return this; }
    public String getDate() { return date; }
    public AccountPayableDue setDate(String value) { this.date = value; return this; }
    public BigDecimal getBalance() { return balance; }
    public AccountPayableDue setBalance(BigDecimal value) { this.balance = value; return this; }
}
