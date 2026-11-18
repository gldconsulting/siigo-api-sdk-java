package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class CreditNoteRequestHealthcareCompany extends ApiModel {
    @JsonProperty("operation_type") private String operationType;
    @JsonProperty("period_start") private String periodStart;
    @JsonProperty("period_end") private String periodEnd;
    @JsonProperty("payment_method") private String paymentMethod;
    @JsonProperty("service_plan") private String servicePlan;
    @JsonProperty("contract_number") private String contractNumber;
    @JsonProperty("copayment") private BigDecimal copayment;
    @JsonProperty("coinsurance") private BigDecimal coinsurance;
    @JsonProperty("cost_sharing") private BigDecimal costSharing;
    @JsonProperty("recovery_charge") private BigDecimal recoveryCharge;
    @JsonProperty("policy_number") private String policyNumber;
    @JsonProperty("non_contract_invoice_reason") private String nonContractInvoiceReason;

    public String getOperationType() { return operationType; }
    public CreditNoteRequestHealthcareCompany setOperationType(String value) { this.operationType = value; return this; }
    public String getPeriodStart() { return periodStart; }
    public CreditNoteRequestHealthcareCompany setPeriodStart(String value) { this.periodStart = value; return this; }
    public String getPeriodEnd() { return periodEnd; }
    public CreditNoteRequestHealthcareCompany setPeriodEnd(String value) { this.periodEnd = value; return this; }
    public String getPaymentMethod() { return paymentMethod; }
    public CreditNoteRequestHealthcareCompany setPaymentMethod(String value) { this.paymentMethod = value; return this; }
    public String getServicePlan() { return servicePlan; }
    public CreditNoteRequestHealthcareCompany setServicePlan(String value) { this.servicePlan = value; return this; }
    public String getContractNumber() { return contractNumber; }
    public CreditNoteRequestHealthcareCompany setContractNumber(String value) { this.contractNumber = value; return this; }
    public BigDecimal getCopayment() { return copayment; }
    public CreditNoteRequestHealthcareCompany setCopayment(BigDecimal value) { this.copayment = value; return this; }
    public BigDecimal getCoinsurance() { return coinsurance; }
    public CreditNoteRequestHealthcareCompany setCoinsurance(BigDecimal value) { this.coinsurance = value; return this; }
    public BigDecimal getCostSharing() { return costSharing; }
    public CreditNoteRequestHealthcareCompany setCostSharing(BigDecimal value) { this.costSharing = value; return this; }
    public BigDecimal getRecoveryCharge() { return recoveryCharge; }
    public CreditNoteRequestHealthcareCompany setRecoveryCharge(BigDecimal value) { this.recoveryCharge = value; return this; }
    public String getPolicyNumber() { return policyNumber; }
    public CreditNoteRequestHealthcareCompany setPolicyNumber(String value) { this.policyNumber = value; return this; }
    public String getNonContractInvoiceReason() { return nonContractInvoiceReason; }
    public CreditNoteRequestHealthcareCompany setNonContractInvoiceReason(String value) { this.nonContractInvoiceReason = value; return this; }
}
