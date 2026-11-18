package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Siigo model; optional fields are omitted when unset. */
public class PaymentReceiptRequestItemAccount extends ApiModel {
    @JsonProperty("code") private String code;
    @JsonProperty("movement") private String movement;

    public String getCode() { return code; }
    public PaymentReceiptRequestItemAccount setCode(String value) { this.code = value; return this; }
    public String getMovement() { return movement; }
    public PaymentReceiptRequestItemAccount setMovement(String value) { this.movement = value; return this; }
}
