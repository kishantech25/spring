package com.nt.service;

import com.nt.dto.UpiPaymentRequest;
import com.nt.dto.UpiPaymentResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/payment/upi")
public class UPIPaymentService{


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response processPayment(UpiPaymentRequest paymentRequest) {

        //Processing the UPI payment:
        System.out.println("Processing UPI payment: "+paymentRequest.amount());
        //really i need to connect with Accounts database and check the balance update it into db after that if balance is avuialbe deduct the amount and return the response to the user

        //return the

        return Response.ok(new UpiPaymentResponse("UPI",true,"Payment done successfully")).build();
    }
}
