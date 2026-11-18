package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
/** Accounts payable uses the published nested value envelope. */
public class AccountsPayableResponse extends ApiModel {
    private AccountsPayablePage value;
    @JsonProperty("_links") private Map<String, Link> links;
    public AccountsPayablePage getValue() { return value; }
    public AccountsPayableResponse setValue(AccountsPayablePage value) { this.value = value; return this; }
    public Map<String, Link> getLinks() { return links; }
    public AccountsPayableResponse setLinks(Map<String, Link> value) { links = value; return this; }
}
