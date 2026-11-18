package co.gldconsulting.siigo.service.reporting;

import co.gldconsulting.siigo.service.QueryFilter;

/** Remote filters documented for this endpoint; values are not shared with other requests. */
public final class AccountsPayableFilter extends QueryFilter {
    public AccountsPayableFilter() { put("page", 1); put("page_size", 25); }
    public String getProviderIdentification() { String value = values.get("provider_identification"); return value == null ? null : value; }
    public AccountsPayableFilter setProviderIdentification(String value) { put("provider_identification", value); return this; }
    public Integer getProviderBranchOffice() { String value = values.get("provider_branch_office"); return value == null ? null : Integer.valueOf(value); }
    public AccountsPayableFilter setProviderBranchOffice(Integer value) { put("provider_branch_office", value); return this; }
    public String getDueDateStart() { String value = values.get("due_date_start"); return value == null ? null : value; }
    public AccountsPayableFilter setDueDateStart(String value) { put("due_date_start", value); return this; }
    public AccountsPayableFilter setDueDateStart(java.time.LocalDate value) { return setDueDateStart(value == null ? (String) null : value.toString()); }
    public String getDueDateEnd() { String value = values.get("due_date_end"); return value == null ? null : value; }
    public AccountsPayableFilter setDueDateEnd(String value) { put("due_date_end", value); return this; }
    public AccountsPayableFilter setDueDateEnd(java.time.LocalDate value) { return setDueDateEnd(value == null ? (String) null : value.toString()); }
    public String getDateEnd() { String value = values.get("date_end"); return value == null ? null : value; }
    public AccountsPayableFilter setDateEnd(String value) { put("date_end", value); return this; }
    public AccountsPayableFilter setDateEnd(java.time.LocalDate value) { return setDateEnd(value == null ? (String) null : value.toString()); }
    public Integer getPage() { String value = values.get("page"); return value == null ? null : Integer.valueOf(value); }
    public AccountsPayableFilter setPage(Integer value) { put("page", value); return this; }
    public Integer getPageSize() { String value = values.get("page_size"); return value == null ? null : Integer.valueOf(value); }
    public AccountsPayableFilter setPageSize(Integer value) { put("page_size", value); return this; }

    @Override public java.util.Map<String, String> toQueryMap() {
        if (values.containsKey("due_date_end") && values.containsKey("date_end")) throw new IllegalArgumentException("Choose due_date_end or date_end, pending confirmation of the vendor contract");
        return super.toQueryMap();
    }
}
