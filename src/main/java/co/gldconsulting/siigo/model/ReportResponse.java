package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class ReportResponse extends ApiModel {
    @JsonProperty("file_id") private String fileId;
    @JsonProperty("file_url") private String fileUrl;

    public String getFileId() { return fileId; }
    public ReportResponse setFileId(String value) { this.fileId = value; return this; }
    public String getFileUrl() { return fileUrl; }
    public ReportResponse setFileUrl(String value) { this.fileUrl = value; return this; }
}
