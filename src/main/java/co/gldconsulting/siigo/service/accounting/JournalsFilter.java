package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.service.QueryFilter;

/** Remote filters documented for this endpoint; values are not shared with other requests. */
public final class JournalsFilter extends QueryFilter {
    public JournalsFilter() { put("page", 1); put("page_size", 25); }
    public Long getDocumentId() { String value = values.get("document_id"); return value == null ? null : Long.valueOf(value); }
    public JournalsFilter setDocumentId(Long value) { put("document_id", value); return this; }
    public String getName() { String value = values.get("name"); return value == null ? null : value; }
    public JournalsFilter setName(String value) { put("name", value); return this; }
    public String getCreatedStart() { String value = values.get("created_start"); return value == null ? null : value; }
    public JournalsFilter setCreatedStart(String value) { put("created_start", value); return this; }
    public JournalsFilter setCreatedStart(java.time.LocalDate value) { return setCreatedStart(value == null ? (String) null : value.toString()); }
    public String getCreatedEnd() { String value = values.get("created_end"); return value == null ? null : value; }
    public JournalsFilter setCreatedEnd(String value) { put("created_end", value); return this; }
    public JournalsFilter setCreatedEnd(java.time.LocalDate value) { return setCreatedEnd(value == null ? (String) null : value.toString()); }
    public String getDateStart() { String value = values.get("date_start"); return value == null ? null : value; }
    public JournalsFilter setDateStart(String value) { put("date_start", value); return this; }
    /** UTC document-day start in the RFC3339 format documented by Siigo. */
    public JournalsFilter setDateStart(java.time.LocalDate value) { return setDateStart(value == null ? (String) null : value + "T00:00:00Z"); }
    public String getDateEnd() { String value = values.get("date_end"); return value == null ? null : value; }
    public JournalsFilter setDateEnd(String value) { put("date_end", value); return this; }
    /** UTC document-day end in the RFC3339 format documented by Siigo. */
    public JournalsFilter setDateEnd(java.time.LocalDate value) { return setDateEnd(value == null ? (String) null : value + "T23:59:59Z"); }
    public String getUpdatedStart() { String value = values.get("updated_start"); return value == null ? null : value; }
    public JournalsFilter setUpdatedStart(String value) { put("updated_start", value); return this; }
    public JournalsFilter setUpdatedStart(java.time.LocalDate value) { return setUpdatedStart(value == null ? (String) null : value.toString()); }
    public String getUpdatedEnd() { String value = values.get("updated_end"); return value == null ? null : value; }
    public JournalsFilter setUpdatedEnd(String value) { put("updated_end", value); return this; }
    public JournalsFilter setUpdatedEnd(java.time.LocalDate value) { return setUpdatedEnd(value == null ? (String) null : value.toString()); }
    public Integer getPage() { String value = values.get("page"); return value == null ? null : Integer.valueOf(value); }
    public JournalsFilter setPage(Integer value) { put("page", value); return this; }
    public Integer getPageSize() { String value = values.get("page_size"); return value == null ? null : Integer.valueOf(value); }
    public JournalsFilter setPageSize(Integer value) { put("page_size", value); return this; }
}
