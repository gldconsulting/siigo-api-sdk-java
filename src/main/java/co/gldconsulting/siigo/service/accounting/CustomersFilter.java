package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.service.QueryFilter;

/** Remote filters documented for this endpoint; values are not shared with other requests. */
public final class CustomersFilter extends QueryFilter {
    public CustomersFilter() { put("page", 1); put("page_size", 25); }
    public String getIdentification() { String value = values.get("identification"); return value == null ? null : value; }
    public CustomersFilter setIdentification(String value) { put("identification", value); return this; }
    public Integer getBranchOffice() { String value = values.get("branch_office"); return value == null ? null : Integer.valueOf(value); }
    public CustomersFilter setBranchOffice(Integer value) { put("branch_office", value); return this; }
    public Boolean getActive() { String value = values.get("active"); return value == null ? null : Boolean.valueOf(value); }
    public CustomersFilter setActive(Boolean value) { put("active", value); return this; }
    public String getType() { String value = values.get("type"); return value == null ? null : value; }
    public CustomersFilter setType(String value) { put("type", value); return this; }
    public String getPersonType() { String value = values.get("person_type"); return value == null ? null : value; }
    public CustomersFilter setPersonType(String value) { put("person_type", value); return this; }
    public String getCreatedStart() { String value = values.get("created_start"); return value == null ? null : value; }
    public CustomersFilter setCreatedStart(String value) { put("created_start", value); return this; }
    public CustomersFilter setCreatedStart(java.time.LocalDate value) { return setCreatedStart(value == null ? (String) null : value.toString()); }
    public String getCreatedEnd() { String value = values.get("created_end"); return value == null ? null : value; }
    public CustomersFilter setCreatedEnd(String value) { put("created_end", value); return this; }
    public CustomersFilter setCreatedEnd(java.time.LocalDate value) { return setCreatedEnd(value == null ? (String) null : value.toString()); }
    public String getDateStart() { String value = values.get("date_start"); return value == null ? null : value; }
    public CustomersFilter setDateStart(String value) { put("date_start", value); return this; }
    public CustomersFilter setDateStart(java.time.LocalDate value) { return setDateStart(value == null ? (String) null : value.toString()); }
    public String getDateEnd() { String value = values.get("date_end"); return value == null ? null : value; }
    public CustomersFilter setDateEnd(String value) { put("date_end", value); return this; }
    public CustomersFilter setDateEnd(java.time.LocalDate value) { return setDateEnd(value == null ? (String) null : value.toString()); }
    public String getUpdatedStart() { String value = values.get("updated_start"); return value == null ? null : value; }
    public CustomersFilter setUpdatedStart(String value) { put("updated_start", value); return this; }
    public CustomersFilter setUpdatedStart(java.time.LocalDate value) { return setUpdatedStart(value == null ? (String) null : value.toString()); }
    public String getUpdatedEnd() { String value = values.get("updated_end"); return value == null ? null : value; }
    public CustomersFilter setUpdatedEnd(String value) { put("updated_end", value); return this; }
    public CustomersFilter setUpdatedEnd(java.time.LocalDate value) { return setUpdatedEnd(value == null ? (String) null : value.toString()); }
    public Integer getPage() { String value = values.get("page"); return value == null ? null : Integer.valueOf(value); }
    public CustomersFilter setPage(Integer value) { put("page", value); return this; }
    public Integer getPageSize() { String value = values.get("page_size"); return value == null ? null : Integer.valueOf(value); }
    public CustomersFilter setPageSize(Integer value) { put("page_size", value); return this; }
}
