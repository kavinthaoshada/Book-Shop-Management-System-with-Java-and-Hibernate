package com.calm.webdb.controller;

import com.calm.webdb.entity.EmployeeEntity;
import com.calm.webdb.entity.UsersEntity;
import com.calm.webdb.service.GRNService;
import com.calm.webdb.service.UsersService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/createGRNProcess")
public class CreateGRNProcessController {
    public CreateGRNProcessController() {

    }
    private static GRNService grnService = new GRNService();
    @POST
//    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(String jsonObject, @Context HttpServletRequest request, @Context HttpServletResponse response) {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpSession session = request.getSession();

        if (jsonObject == null) {
            return Response.status(400).entity("User cannot be null").build();
        }

        try {
            String empEmail = null;
            List<EmployeeEntity> employees = (List<EmployeeEntity>) session.getAttribute("a");
            if (employees != null) {
                for (EmployeeEntity employee : employees) {
                    empEmail = employee.getEmpEmail();
                }
            }

            JsonNode jsonNode = objectMapper.readTree(jsonObject);

            int tlength = jsonNode.get("tlength").asInt();
            int vendor = jsonNode.get("vendor").asInt();
            int ptype = jsonNode.get("ptype").asInt();
            double payment = jsonNode.get("payment").asDouble();
            double balance = jsonNode.get("balance").asDouble();

            JsonNode items = jsonNode.get("items");

            grnService.createGrn(empEmail, tlength, vendor, ptype, payment, balance, items);

            return Response.status(201).entity("Success").build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}
