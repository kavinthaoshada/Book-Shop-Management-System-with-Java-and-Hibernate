package com.calm.webdb.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/purchasehistory")
public class PurchaseHistoryPageController {
    @GET
    public Viewable index(){
        return new Viewable("/purchaseHistory");
    }
}
