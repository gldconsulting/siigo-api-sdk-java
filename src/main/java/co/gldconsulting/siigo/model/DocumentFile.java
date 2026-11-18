package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class DocumentFile extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("cufe") private String cufe;
    @JsonProperty("base64") private String base64;
    @JsonProperty("cude") private String cude;

    public String getId() { return id; }
    public DocumentFile setId(String value) { this.id = value; return this; }
    public String getCufe() { return cufe; }
    public DocumentFile setCufe(String value) { this.cufe = value; return this; }
    public String getBase64() { return base64; }
    public DocumentFile setBase64(String value) { this.base64 = value; return this; }
    public String getCude() { return cude; }
    public DocumentFile setCude(String value) { this.cude = value; return this; }
    @com.fasterxml.jackson.annotation.JsonIgnore public byte[] getBytes() { return java.util.Base64.getDecoder().decode(base64); }

}
