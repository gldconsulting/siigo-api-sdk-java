package co.gldconsulting.siigo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/** Siigo model; optional fields are omitted when unset. */
public class PaymentReceiptCurrency extends ApiModel {
    @JsonProperty("code") private String code;
    @JsonProperty("exchange_rate") private BigDecimal exchangeRate;

    public String getCode() { return code; }
    public PaymentReceiptCurrency setCode(String value) { this.code = value; return this; }
    public BigDecimal getExchangeRate() { return exchangeRate; }
    public PaymentReceiptCurrency setExchangeRate(BigDecimal value) { this.exchangeRate = value; return this; }
}
