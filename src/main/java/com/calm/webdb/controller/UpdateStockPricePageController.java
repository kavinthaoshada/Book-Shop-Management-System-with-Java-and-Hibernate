package com.calm.webdb.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/updateStockPrice")
public class UpdateStockPricePageController {
    @GET
    public Viewable index(){ return new Viewable("updateStockPrice");}
}
