package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class VoucherMetadata extends ApiModel {
    @JsonProperty("created") private String created;
    @JsonProperty("last_updated") private String lastUpdated;
    @JsonProperty("stock_updated") private String stockUpdated;

    public String getCreated() { return created; }
    public VoucherMetadata setCreated(String value) { this.created = value; return this; }
    public String getLastUpdated() { return lastUpdated; }
    public VoucherMetadata setLastUpdated(String value) { this.lastUpdated = value; return this; }
    public String getStockUpdated() { return stockUpdated; }
    public VoucherMetadata setStockUpdated(String value) { this.stockUpdated = value; return this; }
}
