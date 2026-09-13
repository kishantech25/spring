package com.nt.dto;

import com.nt.model.PaymentMode;

import java.math.BigDecimal;

public sealed interface PaymentRequest permits UpiPaymentRequest {
   String getPaymentId();

}
