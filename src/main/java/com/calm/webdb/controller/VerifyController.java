package com.calm.webdb.controller;

import com.calm.webdb.entity.UsersEntity;
import com.calm.webdb.service.AdminService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Path("/verifyProcess")
public class VerifyController {
    private static AdminService adminService = new AdminService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchEmployees(
            @QueryParam("verificationCode") String verificationCode,
            @Context HttpServletRequest request) {

        ObjectMapper objectMapper = new ObjectMapper();

        if (verificationCode == null) {
            return Response.status(400).entity("Verification Code cannot be null").build();
        }

        if(adminService.adminLogin(verificationCode, request)){
            return Response.status(200).entity("success").build();
        }
        return Response.status(400).entity("something went wrong").build();
    }

}
