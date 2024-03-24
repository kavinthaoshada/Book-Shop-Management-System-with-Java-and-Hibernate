package com.calm.webdb.controller;

import com.calm.webdb.service.AdminService;
import com.calm.webdb.service.VendorService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/vendorBlockProcess")
public class VendorBlockProcessController {
    private VendorService vendorService = new VendorService();
    @GET
    public Response vendorBlock(@QueryParam("id")String id){
        if(id==null) {
            return Response.status(400).entity("Id cannot be null").build();
        }
        int vendorId = Integer.parseInt(id);
        vendorService.vendorBlockProcess(vendorId);
        return Response.status(200).entity("success").build();
    }
}
