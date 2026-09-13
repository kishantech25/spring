package com.nt.dto;

import com.nt.model.PaymentMode;

import java.math.BigDecimal;

public record UpiPaymentRequest(BigDecimal amount,String upiId) implements PaymentRequest {

    @Override
    public PaymentMode mode() {
        return PaymentMode.UPI;
    }
}
