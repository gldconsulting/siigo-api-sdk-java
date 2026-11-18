package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class JournalRequestItemProduct extends ApiModel {
    @JsonProperty("code") private String code;
    @JsonProperty("quantity") private BigDecimal quantity;
    @JsonProperty("warehouse") private Long warehouse;

    public String getCode() { return code; }
    public JournalRequestItemProduct setCode(String value) { this.code = value; return this; }
    public BigDecimal getQuantity() { return quantity; }
    public JournalRequestItemProduct setQuantity(BigDecimal value) { this.quantity = value; return this; }
    public Long getWarehouse() { return warehouse; }
    public JournalRequestItemProduct setWarehouse(Long value) { this.warehouse = value; return this; }
}
