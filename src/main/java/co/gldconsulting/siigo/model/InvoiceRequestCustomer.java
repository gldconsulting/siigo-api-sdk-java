package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class InvoiceRequestCustomer extends ApiModel {
    @JsonProperty("person_type") private String personType;
    @JsonProperty("id_type") private String idType;
    @JsonProperty("identification") private String identification;
    @JsonProperty("branch_office") private JsonNode branchOffice;
    @JsonProperty("name") private List<String> name;
    @JsonProperty("address") private InvoiceRequestCustomerAddress address;
    @JsonProperty("phones") private List<InvoiceRequestCustomerPhone> phones;
    @JsonProperty("contacts") private List<InvoiceRequestCustomerContact> contacts;
    @JsonProperty("check_digit") private String checkDigit;
    @JsonProperty("commercial_name") private String commercialName;
    @JsonProperty("active") private Boolean active;
    @JsonProperty("vat_responsible") private Boolean vatResponsible;
    @JsonProperty("fiscal_responsibilities") private List<InvoiceRequestCustomerFiscalResponsibility> fiscalResponsibilities;
    @JsonProperty("comments") private String comments;
    @JsonProperty("related_users") private InvoiceRequestCustomerRelatedUsers relatedUsers;
    @JsonProperty("custom_fields") private List<InvoiceRequestCustomerCustomField> customFields;
    @JsonProperty("type") private String type;

    public String getPersonType() { return personType; }
    public InvoiceRequestCustomer setPersonType(String value) { this.personType = value; return this; }
    public String getIdType() { return idType; }
    public InvoiceRequestCustomer setIdType(String value) { this.idType = value; return this; }
    public String getIdentification() { return identification; }
    public InvoiceRequestCustomer setIdentification(String value) { this.identification = value; return this; }
    public JsonNode getBranchOffice() { return branchOffice; }
    public InvoiceRequestCustomer setBranchOffice(JsonNode value) { this.branchOffice = value; return this; }
    public List<String> getName() { return name; }
    public InvoiceRequestCustomer setName(List<String> value) { this.name = value; return this; }
    public InvoiceRequestCustomerAddress getAddress() { return address; }
    public InvoiceRequestCustomer setAddress(InvoiceRequestCustomerAddress value) { this.address = value; return this; }
    public List<InvoiceRequestCustomerPhone> getPhones() { return phones; }
    public InvoiceRequestCustomer setPhones(List<InvoiceRequestCustomerPhone> value) { this.phones = value; return this; }
    public List<InvoiceRequestCustomerContact> getContacts() { return contacts; }
    public InvoiceRequestCustomer setContacts(List<InvoiceRequestCustomerContact> value) { this.contacts = value; return this; }
    public String getCheckDigit() { return checkDigit; }
    public InvoiceRequestCustomer setCheckDigit(String value) { this.checkDigit = value; return this; }
    public String getCommercialName() { return commercialName; }
    public InvoiceRequestCustomer setCommercialName(String value) { this.commercialName = value; return this; }
    public Boolean getActive() { return active; }
    public InvoiceRequestCustomer setActive(Boolean value) { this.active = value; return this; }
    public Boolean getVatResponsible() { return vatResponsible; }
    public InvoiceRequestCustomer setVatResponsible(Boolean value) { this.vatResponsible = value; return this; }
    public List<InvoiceRequestCustomerFiscalResponsibility> getFiscalResponsibilities() { return fiscalResponsibilities; }
    public InvoiceRequestCustomer setFiscalResponsibilities(List<InvoiceRequestCustomerFiscalResponsibility> value) { this.fiscalResponsibilities = value; return this; }
    public String getComments() { return comments; }
    public InvoiceRequestCustomer setComments(String value) { this.comments = value; return this; }
    public InvoiceRequestCustomerRelatedUsers getRelatedUsers() { return relatedUsers; }
    public InvoiceRequestCustomer setRelatedUsers(InvoiceRequestCustomerRelatedUsers value) { this.relatedUsers = value; return this; }
    public List<InvoiceRequestCustomerCustomField> getCustomFields() { return customFields; }
    public InvoiceRequestCustomer setCustomFields(List<InvoiceRequestCustomerCustomField> value) { this.customFields = value; return this; }
    public String getType() { return type; }
    public InvoiceRequestCustomer setType(String value) { this.type = value; return this; }
}
