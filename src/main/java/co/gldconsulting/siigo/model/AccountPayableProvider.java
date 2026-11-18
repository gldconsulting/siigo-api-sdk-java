package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class AccountPayableProvider extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("identification") private String identification;
    @JsonProperty("branch_office") private Long branchOffice;
    @JsonProperty("name") private String name;

    public String getId() { return id; }
    public AccountPayableProvider setId(String value) { this.id = value; return this; }
    public String getIdentification() { return identification; }
    public AccountPayableProvider setIdentification(String value) { this.identification = value; return this; }
    public Long getBranchOffice() { return branchOffice; }
    public AccountPayableProvider setBranchOffice(Long value) { this.branchOffice = value; return this; }
    public String getName() { return name; }
    public AccountPayableProvider setName(String value) { this.name = value; return this; }
}
