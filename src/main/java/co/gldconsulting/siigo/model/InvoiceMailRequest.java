package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo request; optional fields are omitted when unset. */
public class InvoiceMailRequest extends ApiModel {
    @JsonProperty("guid") private String guid;
    @JsonProperty("mail_to") private String mailTo;
    @JsonProperty("copy_to") private String copyTo;

    public String getGuid() { return guid; }
    public InvoiceMailRequest setGuid(String value) { this.guid = value; return this; }
    public String getMailTo() { return mailTo; }
    public InvoiceMailRequest setMailTo(String value) { this.mailTo = value; return this; }
    public String getCopyTo() { return copyTo; }
    public InvoiceMailRequest setCopyTo(String value) { this.copyTo = value; return this; }
}
