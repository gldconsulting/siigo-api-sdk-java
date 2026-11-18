package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class PurchaseSupplier extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("identification") private String identification;
    @JsonProperty("branch_office") private Long branchOffice;

    public String getId() { return id; }
    public PurchaseSupplier setId(String value) { this.id = value; return this; }
    public String getIdentification() { return identification; }
    public PurchaseSupplier setIdentification(String value) { this.identification = value; return this; }
    public Long getBranchOffice() { return branchOffice; }
    public PurchaseSupplier setBranchOffice(Long value) { this.branchOffice = value; return this; }
}
