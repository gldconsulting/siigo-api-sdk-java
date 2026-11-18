package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class VoucherRequestItemTax extends ApiModel {
    @JsonProperty("id") private Long id;
    @JsonProperty("base") private BigDecimal base;

    public Long getId() { return id; }
    public VoucherRequestItemTax setId(Long value) { this.id = value; return this; }
    public BigDecimal getBase() { return base; }
    public VoucherRequestItemTax setBase(BigDecimal value) { this.base = value; return this; }
}
