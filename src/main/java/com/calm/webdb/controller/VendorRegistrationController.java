package com.calm.webdb.controller;

import com.calm.webdb.service.AdminService;
import com.calm.webdb.service.VendorService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Path("/vendorRegProcess")
public class VendorRegistrationController {
    public VendorRegistrationController() {

    }
    private static VendorService vendorService = new VendorService();
    @POST
    public Response regUser(String vendor) {
        ObjectMapper objectMapper = new ObjectMapper();

        if (vendor == null) {
            return Response.status(400).entity("Vendor cannot be null").build();
        }

        try {
            JsonNode jsonNode = objectMapper.readTree(vendor);

            String name = jsonNode.get("name").asText();
            String mobile = jsonNode.get("mobile").asText();
            String publication = jsonNode.get("publication").asText();

            // Call the service to insert the UsersEntity object into the database
            if (vendorService.vendorRegistration(name, mobile, publication)){
                return Response.status(201).entity("Success").build();
            }else {
                return Response.status(400).entity("Something went wrong..").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}
