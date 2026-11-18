package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Siigo request; optional fields are omitted when unset. */
public class CustomerRequest extends ApiModel {
    @JsonProperty("person_type") private String personType;
    @JsonProperty("id_type") private String idType;
    @JsonProperty("identification") private String identification;
    @JsonProperty("name") private List<String> name;
    @JsonProperty("address") private CustomerRequestAddress address;
    @JsonProperty("phones") private List<CustomerRequestPhone> phones;
    @JsonProperty("contacts") private List<CustomerRequestContact> contacts;
    @JsonProperty("type") private String type;
    @JsonProperty("commercial_name") private String commercialName;
    @JsonProperty("branch_office") private Long branchOffice;
    @JsonProperty("active") private Boolean active;
    @JsonProperty("vat_responsible") private Boolean vatResponsible;
    @JsonProperty("comments") private String comments;
    @JsonProperty("related_users") private CustomerRequestRelatedUsers relatedUsers;
    @JsonProperty("check_digit") private String checkDigit;
    @JsonProperty("fiscal_responsibilities") private List<CustomerRequestFiscalResponsibility> fiscalResponsibilities;
    @JsonProperty("custom_fields") private List<CustomerRequestCustomField> customFields;

    public String getPersonType() { return personType; }
    public CustomerRequest setPersonType(String value) { this.personType = value; return this; }
    public String getIdType() { return idType; }
    public CustomerRequest setIdType(String value) { this.idType = value; return this; }
    public String getIdentification() { return identification; }
    public CustomerRequest setIdentification(String value) { this.identification = value; return this; }
    public List<String> getName() { return name; }
    public CustomerRequest setName(List<String> value) { this.name = value; return this; }
    public CustomerRequestAddress getAddress() { return address; }
    public CustomerRequest setAddress(CustomerRequestAddress value) { this.address = value; return this; }
    public List<CustomerRequestPhone> getPhones() { return phones; }
    public CustomerRequest setPhones(List<CustomerRequestPhone> value) { this.phones = value; return this; }
    public List<CustomerRequestContact> getContacts() { return contacts; }
    public CustomerRequest setContacts(List<CustomerRequestContact> value) { this.contacts = value; return this; }
    public String getType() { return type; }
    public CustomerRequest setType(String value) { this.type = value; return this; }
    public String getCommercialName() { return commercialName; }
    public CustomerRequest setCommercialName(String value) { this.commercialName = value; return this; }
    public Long getBranchOffice() { return branchOffice; }
    public CustomerRequest setBranchOffice(Long value) { this.branchOffice = value; return this; }
    public Boolean getActive() { return active; }
    public CustomerRequest setActive(Boolean value) { this.active = value; return this; }
    public Boolean getVatResponsible() { return vatResponsible; }
    public CustomerRequest setVatResponsible(Boolean value) { this.vatResponsible = value; return this; }
    public String getComments() { return comments; }
    public CustomerRequest setComments(String value) { this.comments = value; return this; }
    public CustomerRequestRelatedUsers getRelatedUsers() { return relatedUsers; }
    public CustomerRequest setRelatedUsers(CustomerRequestRelatedUsers value) { this.relatedUsers = value; return this; }
    public String getCheckDigit() { return checkDigit; }
    public CustomerRequest setCheckDigit(String value) { this.checkDigit = value; return this; }
    public List<CustomerRequestFiscalResponsibility> getFiscalResponsibilities() { return fiscalResponsibilities; }
    public CustomerRequest setFiscalResponsibilities(List<CustomerRequestFiscalResponsibility> value) { this.fiscalResponsibilities = value; return this; }
    public List<CustomerRequestCustomField> getCustomFields() { return customFields; }
    public CustomerRequest setCustomFields(List<CustomerRequestCustomField> value) { this.customFields = value; return this; }
}
