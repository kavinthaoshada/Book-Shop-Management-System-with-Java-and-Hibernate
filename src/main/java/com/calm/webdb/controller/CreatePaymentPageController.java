package com.calm.webdb.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/createPayment")
//@Singleton
public class CreatePaymentPageController {
    @GET
    public Viewable index(){
        return new Viewable("/createPayment");
    }
}
