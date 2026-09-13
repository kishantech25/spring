package com.nt.service;

import com.nt.dto.CreditPaymentRequest;
import com.nt.dto.CreditPaymentResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/payment/credit")
public class CreditPaymentService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response processPayment(CreditPaymentRequest paymentRequest) {
        System.out.println("Processing credit payment amount: " + paymentRequest.amount());

        return Response.ok(new CreditPaymentResponse("Credit",true,"Payment done successfully")).build();
    }
}
