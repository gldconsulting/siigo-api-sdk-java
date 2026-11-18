package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.service.QueryFilter;

/** Remote filters documented for this endpoint; values are not shared with other requests. */
public final class VouchersFilter extends QueryFilter {
    public VouchersFilter() { put("page", 1); put("page_size", 25); }
    public String getName() { String value = values.get("name"); return value == null ? null : value; }
    public VouchersFilter setName(String value) { put("name", value); return this; }
    public String getCreatedStart() { String value = values.get("created_start"); return value == null ? null : value; }
    public VouchersFilter setCreatedStart(String value) { put("created_start", value); return this; }
    public VouchersFilter setCreatedStart(java.time.LocalDate value) { return setCreatedStart(value == null ? (String) null : value.toString()); }
    public String getCreatedEnd() { String value = values.get("created_end"); return value == null ? null : value; }
    public VouchersFilter setCreatedEnd(String value) { put("created_end", value); return this; }
    public VouchersFilter setCreatedEnd(java.time.LocalDate value) { return setCreatedEnd(value == null ? (String) null : value.toString()); }
    public String getDateStart() { String value = values.get("date_start"); return value == null ? null : value; }
    public VouchersFilter setDateStart(String value) { put("date_start", value); return this; }
    public VouchersFilter setDateStart(java.time.LocalDate value) { return setDateStart(value == null ? (String) null : value.toString()); }
    public String getDateEnd() { String value = values.get("date_end"); return value == null ? null : value; }
    public VouchersFilter setDateEnd(String value) { put("date_end", value); return this; }
    public VouchersFilter setDateEnd(java.time.LocalDate value) { return setDateEnd(value == null ? (String) null : value.toString()); }
    public String getUpdatedStart() { String value = values.get("updated_start"); return value == null ? null : value; }
    public VouchersFilter setUpdatedStart(String value) { put("updated_start", value); return this; }
    public VouchersFilter setUpdatedStart(java.time.LocalDate value) { return setUpdatedStart(value == null ? (String) null : value.toString()); }
    public String getUpdatedEnd() { String value = values.get("updated_end"); return value == null ? null : value; }
    public VouchersFilter setUpdatedEnd(String value) { put("updated_end", value); return this; }
    public VouchersFilter setUpdatedEnd(java.time.LocalDate value) { return setUpdatedEnd(value == null ? (String) null : value.toString()); }
    public Integer getPage() { String value = values.get("page"); return value == null ? null : Integer.valueOf(value); }
    public VouchersFilter setPage(Integer value) { put("page", value); return this; }
    public Integer getPageSize() { String value = values.get("page_size"); return value == null ? null : Integer.valueOf(value); }
    public VouchersFilter setPageSize(Integer value) { put("page_size", value); return this; }
}
