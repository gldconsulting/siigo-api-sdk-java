package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class AccountPayable extends ApiModel {
    @JsonProperty("due") private AccountPayableDue due;
    @JsonProperty("provider") private AccountPayableProvider provider;
    @JsonProperty("cost_center") private AccountPayableCostCenter costCenter;
    @JsonProperty("currency") private AccountPayableCurrency currency;

    public AccountPayableDue getDue() { return due; }
    public AccountPayable setDue(AccountPayableDue value) { this.due = value; return this; }
    public AccountPayableProvider getProvider() { return provider; }
    public AccountPayable setProvider(AccountPayableProvider value) { this.provider = value; return this; }
    public AccountPayableCostCenter getCostCenter() { return costCenter; }
    public AccountPayable setCostCenter(AccountPayableCostCenter value) { this.costCenter = value; return this; }
    public AccountPayableCurrency getCurrency() { return currency; }
    public AccountPayable setCurrency(AccountPayableCurrency value) { this.currency = value; return this; }
}
