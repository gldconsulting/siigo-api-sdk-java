package co.gldconsulting.siigo.service.accounting;

import co.gldconsulting.siigo.service.QueryFilter;

/** Remote filters documented for this endpoint; values are not shared with other requests. */
public final class WebhooksFilter extends QueryFilter {
    public WebhooksFilter() { put("page", 1); put("page_size", 25); }
    public Integer getPage() { String value = values.get("page"); return value == null ? null : Integer.valueOf(value); }
    public WebhooksFilter setPage(Integer value) { put("page", value); return this; }
    public Integer getPageSize() { String value = values.get("page_size"); return value == null ? null : Integer.valueOf(value); }
    public WebhooksFilter setPageSize(Integer value) { put("page_size", value); return this; }
}
