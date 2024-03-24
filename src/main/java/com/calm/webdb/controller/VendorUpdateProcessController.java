package com.calm.webdb.controller;

import com.calm.webdb.service.VendorService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/vendorUpdateProcess")
public class VendorUpdateProcessController {
    private VendorService vendorService = new VendorService();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response vendorUpdate(String data, @Context HttpServletRequest request){
        ObjectMapper objectMapper = new ObjectMapper();
        if(data == null){
            return Response.status(400).entity("Object is null").build();
        }
        try {
            JsonNode jsonNode = objectMapper.readTree(data);
            int vendorId = jsonNode.get("id").asInt();
            String name = jsonNode.get("name").asText();
            String mobile = jsonNode.get("mobile").asText();
            String publication = jsonNode.get("publication").asText();
            if(mobile.isEmpty()){
                return Response.status(400).entity("mobile is empty").build();
            }else if(publication.isEmpty()){
                return Response.status(400).entity("publication is empty").build();
            }else{
                vendorService.vendorUpdate(vendorId, mobile, publication);
                return Response.status(200).entity("success").build();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(500).entity("Something went wrong").build();
        }

    }
}
