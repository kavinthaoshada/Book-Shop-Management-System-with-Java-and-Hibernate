package com.calm.webdb.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

@Path("/grn")
public class GRNPageController {
    @GET
    public Viewable index(){
        return new Viewable("/grn");
    }
}
