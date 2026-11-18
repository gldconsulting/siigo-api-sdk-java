package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.service.QueryFilter;

/** Remote filters documented for this endpoint; values are not shared with other requests. */
public final class QuotationsFilter extends QueryFilter {
    public QuotationsFilter() { put("page", 1); put("page_size", 25); }
    public String getCreatedStart() { String value = values.get("created_start"); return value == null ? null : value; }
    public QuotationsFilter setCreatedStart(String value) { put("created_start", value); return this; }
    public QuotationsFilter setCreatedStart(java.time.LocalDate value) { return setCreatedStart(value == null ? (String) null : value.toString()); }
    public String getCreatedEnd() { String value = values.get("created_end"); return value == null ? null : value; }
    public QuotationsFilter setCreatedEnd(String value) { put("created_end", value); return this; }
    public QuotationsFilter setCreatedEnd(java.time.LocalDate value) { return setCreatedEnd(value == null ? (String) null : value.toString()); }
    public String getName() { String value = values.get("name"); return value == null ? null : value; }
    public QuotationsFilter setName(String value) { put("name", value); return this; }
    public String getCustomerIdentification() { String value = values.get("customer_identification"); return value == null ? null : value; }
    public QuotationsFilter setCustomerIdentification(String value) { put("customer_identification", value); return this; }
    public Integer getCustomerBranchOffice() { String value = values.get("customer_branch_office"); return value == null ? null : Integer.valueOf(value); }
    public QuotationsFilter setCustomerBranchOffice(Integer value) { put("customer_branch_office", value); return this; }
    public Integer getPage() { String value = values.get("page"); return value == null ? null : Integer.valueOf(value); }
    public QuotationsFilter setPage(Integer value) { put("page", value); return this; }
    public Integer getPageSize() { String value = values.get("page_size"); return value == null ? null : Integer.valueOf(value); }
    public QuotationsFilter setPageSize(Integer value) { put("page_size", value); return this; }
}
