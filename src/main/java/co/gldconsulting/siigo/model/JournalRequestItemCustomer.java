package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class JournalRequestItemCustomer extends ApiModel {
    @JsonProperty("identification") private String identification;
    @JsonProperty("branch_office") private Long branchOffice;

    public String getIdentification() { return identification; }
    public JournalRequestItemCustomer setIdentification(String value) { this.identification = value; return this; }
    public Long getBranchOffice() { return branchOffice; }
    public JournalRequestItemCustomer setBranchOffice(Long value) { this.branchOffice = value; return this; }
}
