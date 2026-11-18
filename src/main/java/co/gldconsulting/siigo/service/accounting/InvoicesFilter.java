package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.service.QueryFilter;

/** Remote filters documented for this endpoint; values are not shared with other requests. */
public final class InvoicesFilter extends QueryFilter {
    public InvoicesFilter() { put("page", 1); put("page_size", 25); }
    public Long getDocumentId() { String value = values.get("document_id"); return value == null ? null : Long.valueOf(value); }
    public InvoicesFilter setDocumentId(Long value) { put("document_id", value); return this; }
    public String getCustomerIdentification() { String value = values.get("customer_identification"); return value == null ? null : value; }
    public InvoicesFilter setCustomerIdentification(String value) { put("customer_identification", value); return this; }
    public Integer getCustomerBranchOffice() { String value = values.get("customer_branch_office"); return value == null ? null : Integer.valueOf(value); }
    public InvoicesFilter setCustomerBranchOffice(Integer value) { put("customer_branch_office", value); return this; }
    public String getName() { String value = values.get("name"); return value == null ? null : value; }
    public InvoicesFilter setName(String value) { put("name", value); return this; }
    public String getCreatedStart() { String value = values.get("created_start"); return value == null ? null : value; }
    public InvoicesFilter setCreatedStart(String value) { put("created_start", value); return this; }
    public InvoicesFilter setCreatedStart(java.time.LocalDate value) { return setCreatedStart(value == null ? (String) null : value.toString()); }
    public String getCreatedEnd() { String value = values.get("created_end"); return value == null ? null : value; }
    public InvoicesFilter setCreatedEnd(String value) { put("created_end", value); return this; }
    public InvoicesFilter setCreatedEnd(java.time.LocalDate value) { return setCreatedEnd(value == null ? (String) null : value.toString()); }
    public String getDateStart() { String value = values.get("date_start"); return value == null ? null : value; }
    public InvoicesFilter setDateStart(String value) { put("date_start", value); return this; }
    public InvoicesFilter setDateStart(java.time.LocalDate value) { return setDateStart(value == null ? (String) null : value.toString()); }
    public String getDateEnd() { String value = values.get("date_end"); return value == null ? null : value; }
    public InvoicesFilter setDateEnd(String value) { put("date_end", value); return this; }
    public InvoicesFilter setDateEnd(java.time.LocalDate value) { return setDateEnd(value == null ? (String) null : value.toString()); }
    public String getUpdatedStart() { String value = values.get("updated_start"); return value == null ? null : value; }
    public InvoicesFilter setUpdatedStart(String value) { put("updated_start", value); return this; }
    public InvoicesFilter setUpdatedStart(java.time.LocalDate value) { return setUpdatedStart(value == null ? (String) null : value.toString()); }
    public String getUpdatedEnd() { String value = values.get("updated_end"); return value == null ? null : value; }
    public InvoicesFilter setUpdatedEnd(String value) { put("updated_end", value); return this; }
    public InvoicesFilter setUpdatedEnd(java.time.LocalDate value) { return setUpdatedEnd(value == null ? (String) null : value.toString()); }
    public Integer getPage() { String value = values.get("page"); return value == null ? null : Integer.valueOf(value); }
    public InvoicesFilter setPage(Integer value) { put("page", value); return this; }
    public Integer getPageSize() { String value = values.get("page_size"); return value == null ? null : Integer.valueOf(value); }
    public InvoicesFilter setPageSize(Integer value) { put("page_size", value); return this; }
}
