package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/** Siigo model; optional fields are omitted when unset. */
public class PaymentReceiptRequestSupplier extends ApiModel {
    @JsonProperty("identification") private String identification;
    @JsonProperty("branch_office") private JsonNode branchOffice;

    public String getIdentification() { return identification; }
    public PaymentReceiptRequestSupplier setIdentification(String value) { this.identification = value; return this; }
    public JsonNode getBranchOffice() { return branchOffice; }
    public PaymentReceiptRequestSupplier setBranchOffice(JsonNode value) { this.branchOffice = value; return this; }
}
