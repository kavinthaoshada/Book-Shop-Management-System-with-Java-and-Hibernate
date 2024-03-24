package com.calm.webdb.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/addproduct")
public class AddProductPageController {
    @GET
    public Viewable index(){
        return new Viewable("/addProduct");
    }
}
