package com.nt.service;

import com.nt.dto.CreditPaymentRequest;
import com.nt.dto.CreditPaymentResponse;
import com.nt.dto.InternetPaymentRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/payment/internet")
public class InternetPaymentService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response processPayment(InternetPaymentRequest paymentRequest) {
        System.out.println("Processing internet payment amount: " + paymentRequest.amount());

        return Response.ok(new CreditPaymentResponse("Net",true,"Payment done successfully")).build();
    }
}
