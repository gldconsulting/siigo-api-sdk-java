package co.gldconsulting.siigo.service;

import java.util.LinkedHashMap;
import java.util.Map;
/** Snapshot-based remote query parameters, owned by one request filter. */
public abstract class QueryFilter {
    protected final Map<String, String> values = new LinkedHashMap<>();
    protected void put(String key, Object value) {
        if (value == null) { values.remove(key); return; }
        if (key.equals("page") && ((Number) value).intValue() < 1) throw new IllegalArgumentException("page must be positive");
        if (key.equals("page_size") && (((Number) value).intValue() < 1 || ((Number) value).intValue() > 100)) throw new IllegalArgumentException("pageSize must be between 1 and 100");
        if (key.endsWith("branch_office") && (((Number) value).intValue() < 0 || ((Number) value).intValue() > 999)) throw new IllegalArgumentException("branchOffice must be between 0 and 999");
        values.put(key, value.toString());
    }
    public Map<String, String> toQueryMap() { return new LinkedHashMap<>(values); }
}
