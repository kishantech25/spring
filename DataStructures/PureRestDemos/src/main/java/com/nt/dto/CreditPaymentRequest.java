package com.nt.dto;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public record CreditPaymentRequest(
        @JsonProperty("amount") BigDecimal amount,
        @JsonProperty("cardNo") String cardNo
) {
    @JsonCreator
    public CreditPaymentRequest {}
}