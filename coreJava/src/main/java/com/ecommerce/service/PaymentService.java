package com.ecommerce.service;

import jakarta.ws.rs.Path;


public interface PaymentService {

    public void pay(double amount);

}
