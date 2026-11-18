package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.service.QueryFilter;

/** Remote filters documented for this endpoint; values are not shared with other requests. */
public final class PaymentReceiptsFilter extends QueryFilter {
    public PaymentReceiptsFilter() {  }
    public String getCreatedStart() { String value = values.get("created_start"); return value == null ? null : value; }
    public PaymentReceiptsFilter setCreatedStart(String value) { put("created_start", value); return this; }
    public PaymentReceiptsFilter setCreatedStart(java.time.LocalDate value) { return setCreatedStart(value == null ? (String) null : value.toString()); }
    public String getCreatedEnd() { String value = values.get("created_end"); return value == null ? null : value; }
    public PaymentReceiptsFilter setCreatedEnd(String value) { put("created_end", value); return this; }
    public PaymentReceiptsFilter setCreatedEnd(java.time.LocalDate value) { return setCreatedEnd(value == null ? (String) null : value.toString()); }
    public String getUpdatedStart() { String value = values.get("updated_start"); return value == null ? null : value; }
    public PaymentReceiptsFilter setUpdatedStart(String value) { put("updated_start", value); return this; }
    public PaymentReceiptsFilter setUpdatedStart(java.time.LocalDate value) { return setUpdatedStart(value == null ? (String) null : value.toString()); }
    public String getUpdatedEnd() { String value = values.get("updated_end"); return value == null ? null : value; }
    public PaymentReceiptsFilter setUpdatedEnd(String value) { put("updated_end", value); return this; }
    public PaymentReceiptsFilter setUpdatedEnd(java.time.LocalDate value) { return setUpdatedEnd(value == null ? (String) null : value.toString()); }
}
