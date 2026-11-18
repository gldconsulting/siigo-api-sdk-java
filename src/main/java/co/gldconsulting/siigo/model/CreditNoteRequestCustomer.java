package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class CreditNoteRequestCustomer extends ApiModel {
    @JsonProperty("identification") private String identification;
    @JsonProperty("branch_office") private String branchOffice;

    public String getIdentification() { return identification; }
    public CreditNoteRequestCustomer setIdentification(String value) { this.identification = value; return this; }
    public String getBranchOffice() { return branchOffice; }
    public CreditNoteRequestCustomer setBranchOffice(String value) { this.branchOffice = value; return this; }
}
