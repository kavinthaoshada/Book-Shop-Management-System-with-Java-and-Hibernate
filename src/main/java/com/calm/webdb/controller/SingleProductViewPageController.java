package com.calm.webdb.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/singleProductView")
public class SingleProductViewPageController {
    @GET
    public Viewable index(){
        return new Viewable("/singleProductView");
    }
}