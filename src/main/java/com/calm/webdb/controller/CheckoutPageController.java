package com.calm.webdb.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/checkout")
//@Singleton
public class CheckoutPageController {
    @GET
    public Viewable index(){
        return new Viewable("/checkout");
    }
}
