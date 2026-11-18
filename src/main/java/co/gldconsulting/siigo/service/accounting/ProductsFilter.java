package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.service.QueryFilter;

/** Remote filters documented for this endpoint; values are not shared with other requests. */
public final class ProductsFilter extends QueryFilter {
    public ProductsFilter() { put("page", 1); put("page_size", 25); }
    public String getCode() { String value = values.get("code"); return value == null ? null : value; }
    public ProductsFilter setCode(String value) { put("code", value); return this; }
    public Long getAccountGroup() { String value = values.get("account_group"); return value == null ? null : Long.valueOf(value); }
    public ProductsFilter setAccountGroup(Long value) { put("account_group", value); return this; }
    public String getType() { String value = values.get("type"); return value == null ? null : value; }
    public ProductsFilter setType(String value) { put("type", value); return this; }
    public Boolean getStockControl() { String value = values.get("stock_control"); return value == null ? null : Boolean.valueOf(value); }
    public ProductsFilter setStockControl(Boolean value) { put("stock_control", value); return this; }
    public Boolean getActive() { String value = values.get("active"); return value == null ? null : Boolean.valueOf(value); }
    public ProductsFilter setActive(Boolean value) { put("active", value); return this; }
    public String getIds() { String value = values.get("ids"); return value == null ? null : value; }
    public ProductsFilter setIds(String value) { put("ids", value); return this; }
    public String getCreatedStart() { String value = values.get("created_start"); return value == null ? null : value; }
    public ProductsFilter setCreatedStart(String value) { put("created_start", value); return this; }
    public ProductsFilter setCreatedStart(java.time.LocalDate value) { return setCreatedStart(value == null ? (String) null : value.toString()); }
    public String getCreatedEnd() { String value = values.get("created_end"); return value == null ? null : value; }
    public ProductsFilter setCreatedEnd(String value) { put("created_end", value); return this; }
    public ProductsFilter setCreatedEnd(java.time.LocalDate value) { return setCreatedEnd(value == null ? (String) null : value.toString()); }
    public String getDateStart() { String value = values.get("date_start"); return value == null ? null : value; }
    public ProductsFilter setDateStart(String value) { put("date_start", value); return this; }
    public ProductsFilter setDateStart(java.time.LocalDate value) { return setDateStart(value == null ? (String) null : value.toString()); }
    public String getDateEnd() { String value = values.get("date_end"); return value == null ? null : value; }
    public ProductsFilter setDateEnd(String value) { put("date_end", value); return this; }
    public ProductsFilter setDateEnd(java.time.LocalDate value) { return setDateEnd(value == null ? (String) null : value.toString()); }
    public String getUpdatedStart() { String value = values.get("updated_start"); return value == null ? null : value; }
    public ProductsFilter setUpdatedStart(String value) { put("updated_start", value); return this; }
    public ProductsFilter setUpdatedStart(java.time.LocalDate value) { return setUpdatedStart(value == null ? (String) null : value.toString()); }
    public String getUpdatedEnd() { String value = values.get("updated_end"); return value == null ? null : value; }
    public ProductsFilter setUpdatedEnd(String value) { put("updated_end", value); return this; }
    public ProductsFilter setUpdatedEnd(java.time.LocalDate value) { return setUpdatedEnd(value == null ? (String) null : value.toString()); }
    public Integer getPage() { String value = values.get("page"); return value == null ? null : Integer.valueOf(value); }
    public ProductsFilter setPage(Integer value) { put("page", value); return this; }
    public Integer getPageSize() { String value = values.get("page_size"); return value == null ? null : Integer.valueOf(value); }
    public ProductsFilter setPageSize(Integer value) { put("page_size", value); return this; }
}
