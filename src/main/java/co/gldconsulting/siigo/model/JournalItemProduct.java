package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class JournalItemProduct extends ApiModel {
    @JsonProperty("id") private String id;
    @JsonProperty("code") private String code;
    @JsonProperty("name") private String name;
    @JsonProperty("warehouse") private JournalItemProductWarehouse warehouse;
    @JsonProperty("quantity") private BigDecimal quantity;

    public String getId() { return id; }
    public JournalItemProduct setId(String value) { this.id = value; return this; }
    public String getCode() { return code; }
    public JournalItemProduct setCode(String value) { this.code = value; return this; }
    public String getName() { return name; }
    public JournalItemProduct setName(String value) { this.name = value; return this; }
    public JournalItemProductWarehouse getWarehouse() { return warehouse; }
    public JournalItemProduct setWarehouse(JournalItemProductWarehouse value) { this.warehouse = value; return this; }
    public BigDecimal getQuantity() { return quantity; }
    public JournalItemProduct setQuantity(BigDecimal value) { this.quantity = value; return this; }
}
