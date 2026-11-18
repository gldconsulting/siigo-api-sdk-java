package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Siigo model; optional fields are omitted when unset. */
public class Customer extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("type") private String type;
    @JsonProperty("person_type") private String personType;
    @JsonProperty("id_type") private CustomerIdType idType;
    @JsonProperty("identification") private String identification;
    @JsonProperty("branch_office") private Long branchOffice;
    @JsonProperty("check_digit") private String checkDigit;
    @JsonProperty("name") private List<String> name;
    @JsonProperty("commercial_name") private String commercialName;
    @JsonProperty("active") private Boolean active;
    @JsonProperty("vat_responsible") private Boolean vatResponsible;
    @JsonProperty("fiscal_responsibilities") private List<CustomerFiscalResponsibility> fiscalResponsibilities;
    @JsonProperty("address") private CustomerAddress address;
    @JsonProperty("phones") private List<CustomerPhone> phones;
    @JsonProperty("contacts") private List<CustomerContact> contacts;
    @JsonProperty("comments") private String comments;
    @JsonProperty("related_users") private CustomerRelatedUsers relatedUsers;
    @JsonProperty("custom_fields") private List<CustomerCustomField> customFields;
    @JsonProperty("metadata") private CustomerMetadata metadata;

    public String getId() { return id; }
    public Customer setId(String value) { this.id = value; return this; }
    public String getType() { return type; }
    public Customer setType(String value) { this.type = value; return this; }
    public String getPersonType() { return personType; }
    public Customer setPersonType(String value) { this.personType = value; return this; }
    public CustomerIdType getIdType() { return idType; }
    public Customer setIdType(CustomerIdType value) { this.idType = value; return this; }
    public String getIdentification() { return identification; }
    public Customer setIdentification(String value) { this.identification = value; return this; }
    public Long getBranchOffice() { return branchOffice; }
    public Customer setBranchOffice(Long value) { this.branchOffice = value; return this; }
    public String getCheckDigit() { return checkDigit; }
    public Customer setCheckDigit(String value) { this.checkDigit = value; return this; }
    public List<String> getName() { return name; }
    public Customer setName(List<String> value) { this.name = value; return this; }
    public String getCommercialName() { return commercialName; }
    public Customer setCommercialName(String value) { this.commercialName = value; return this; }
    public Boolean getActive() { return active; }
    public Customer setActive(Boolean value) { this.active = value; return this; }
    public Boolean getVatResponsible() { return vatResponsible; }
    public Customer setVatResponsible(Boolean value) { this.vatResponsible = value; return this; }
    public List<CustomerFiscalResponsibility> getFiscalResponsibilities() { return fiscalResponsibilities; }
    public Customer setFiscalResponsibilities(List<CustomerFiscalResponsibility> value) { this.fiscalResponsibilities = value; return this; }
    public CustomerAddress getAddress() { return address; }
    public Customer setAddress(CustomerAddress value) { this.address = value; return this; }
    public List<CustomerPhone> getPhones() { return phones; }
    public Customer setPhones(List<CustomerPhone> value) { this.phones = value; return this; }
    public List<CustomerContact> getContacts() { return contacts; }
    public Customer setContacts(List<CustomerContact> value) { this.contacts = value; return this; }
    public String getComments() { return comments; }
    public Customer setComments(String value) { this.comments = value; return this; }
    public CustomerRelatedUsers getRelatedUsers() { return relatedUsers; }
    public Customer setRelatedUsers(CustomerRelatedUsers value) { this.relatedUsers = value; return this; }
    public List<CustomerCustomField> getCustomFields() { return customFields; }
    public Customer setCustomFields(List<CustomerCustomField> value) { this.customFields = value; return this; }
    public CustomerMetadata getMetadata() { return metadata; }
    public Customer setMetadata(CustomerMetadata value) { this.metadata = value; return this; }
}
