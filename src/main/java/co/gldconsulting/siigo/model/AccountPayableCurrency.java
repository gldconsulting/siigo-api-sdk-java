package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class AccountPayableCurrency extends ApiModel {
    @JsonProperty("money_code") private String moneyCode;
    @JsonProperty("balance") private BigDecimal balance;

    public String getMoneyCode() { return moneyCode; }
    public AccountPayableCurrency setMoneyCode(String value) { this.moneyCode = value; return this; }
    public BigDecimal getBalance() { return balance; }
    public AccountPayableCurrency setBalance(BigDecimal value) { this.balance = value; return this; }
}
