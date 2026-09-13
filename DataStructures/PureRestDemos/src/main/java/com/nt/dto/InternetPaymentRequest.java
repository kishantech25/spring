package com.nt.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record InternetPaymentRequest(@JsonProperty("amount") BigDecimal amount,@JsonProperty("cardNo") String cardNo) {
        @JsonCreator
        public InternetPaymentRequest {}
}

