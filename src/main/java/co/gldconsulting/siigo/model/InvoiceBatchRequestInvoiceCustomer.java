package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceBatchRequestInvoiceCustomer extends ApiModel {
    @JsonProperty("person_type") private String personType;
    @JsonProperty("id_type") private String idType;
    @JsonProperty("identification") private String identification;
    @JsonProperty("check_digit") private String checkDigit;
    @JsonProperty("name") private List<String> name;
    @JsonProperty("commercial_name") private String commercialName;
    @JsonProperty("branch_office") private Long branchOffice;
    @JsonProperty("active") private Boolean active;
    @JsonProperty("vat_responsible") private Boolean vatResponsible;
    @JsonProperty("fiscal_responsibilities") private List<InvoiceBatchRequestInvoiceCustomerFiscalResponsibility> fiscalResponsibilities;
    @JsonProperty("address") private InvoiceBatchRequestInvoiceCustomerAddress address;
    @JsonProperty("phones") private List<InvoiceBatchRequestInvoiceCustomerPhone> phones;
    @JsonProperty("contacts") private List<InvoiceBatchRequestInvoiceCustomerContact> contacts;
    @JsonProperty("comments") private String comments;
    @JsonProperty("related_users") private InvoiceBatchRequestInvoiceCustomerRelatedUsers relatedUsers;
    @JsonProperty("custom_fields") private List<InvoiceBatchRequestInvoiceCustomerCustomField> customFields;
    @JsonProperty("type") private String type;

    public String getPersonType() { return personType; }
    public InvoiceBatchRequestInvoiceCustomer setPersonType(String value) { this.personType = value; return this; }
    public String getIdType() { return idType; }
    public InvoiceBatchRequestInvoiceCustomer setIdType(String value) { this.idType = value; return this; }
    public String getIdentification() { return identification; }
    public InvoiceBatchRequestInvoiceCustomer setIdentification(String value) { this.identification = value; return this; }
    public String getCheckDigit() { return checkDigit; }
    public InvoiceBatchRequestInvoiceCustomer setCheckDigit(String value) { this.checkDigit = value; return this; }
    public List<String> getName() { return name; }
    public InvoiceBatchRequestInvoiceCustomer setName(List<String> value) { this.name = value; return this; }
    public String getCommercialName() { return commercialName; }
    public InvoiceBatchRequestInvoiceCustomer setCommercialName(String value) { this.commercialName = value; return this; }
    public Long getBranchOffice() { return branchOffice; }
    public InvoiceBatchRequestInvoiceCustomer setBranchOffice(Long value) { this.branchOffice = value; return this; }
    public Boolean getActive() { return active; }
    public InvoiceBatchRequestInvoiceCustomer setActive(Boolean value) { this.active = value; return this; }
    public Boolean getVatResponsible() { return vatResponsible; }
    public InvoiceBatchRequestInvoiceCustomer setVatResponsible(Boolean value) { this.vatResponsible = value; return this; }
    public List<InvoiceBatchRequestInvoiceCustomerFiscalResponsibility> getFiscalResponsibilities() { return fiscalResponsibilities; }
    public InvoiceBatchRequestInvoiceCustomer setFiscalResponsibilities(List<InvoiceBatchRequestInvoiceCustomerFiscalResponsibility> value) { this.fiscalResponsibilities = value; return this; }
    public InvoiceBatchRequestInvoiceCustomerAddress getAddress() { return address; }
    public InvoiceBatchRequestInvoiceCustomer setAddress(InvoiceBatchRequestInvoiceCustomerAddress value) { this.address = value; return this; }
    public List<InvoiceBatchRequestInvoiceCustomerPhone> getPhones() { return phones; }
    public InvoiceBatchRequestInvoiceCustomer setPhones(List<InvoiceBatchRequestInvoiceCustomerPhone> value) { this.phones = value; return this; }
    public List<InvoiceBatchRequestInvoiceCustomerContact> getContacts() { return contacts; }
    public InvoiceBatchRequestInvoiceCustomer setContacts(List<InvoiceBatchRequestInvoiceCustomerContact> value) { this.contacts = value; return this; }
    public String getComments() { return comments; }
    public InvoiceBatchRequestInvoiceCustomer setComments(String value) { this.comments = value; return this; }
    public InvoiceBatchRequestInvoiceCustomerRelatedUsers getRelatedUsers() { return relatedUsers; }
    public InvoiceBatchRequestInvoiceCustomer setRelatedUsers(InvoiceBatchRequestInvoiceCustomerRelatedUsers value) { this.relatedUsers = value; return this; }
    public List<InvoiceBatchRequestInvoiceCustomerCustomField> getCustomFields() { return customFields; }
    public InvoiceBatchRequestInvoiceCustomer setCustomFields(List<InvoiceBatchRequestInvoiceCustomerCustomField> value) { this.customFields = value; return this; }
    public String getType() { return type; }
    public InvoiceBatchRequestInvoiceCustomer setType(String value) { this.type = value; return this; }
}
