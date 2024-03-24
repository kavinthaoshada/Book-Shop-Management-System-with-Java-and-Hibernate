package com.calm.webdb.controller;

import com.calm.webdb.service.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Path("/empRegProcess")
public class EmployeeRegistrationController {
    public EmployeeRegistrationController() {

    }
    private static AdminService adminService = new AdminService();
    @POST
    public Response regUser(String employee) {
        ObjectMapper objectMapper = new ObjectMapper();

        if (employee == null) {
            return Response.status(400).entity("User cannot be null").build();
        }
        try {
            JsonNode jsonNode = objectMapper.readTree(employee);

            String fname = jsonNode.get("fname").asText();
            String lname = jsonNode.get("lname").asText();
            String empEmail = jsonNode.get("email").asText();
            String username = jsonNode.get("uname").asText();
            String password = jsonNode.get("password").asText();
            String mobile = jsonNode.get("mobile").asText();
            int empType = jsonNode.get("empType").asInt();
            int gender = jsonNode.get("gender").asInt();
            String dateString = jsonNode.get("joinedDate").asText();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate;
            utilDate = dateFormat.parse(dateString);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//            usersEntity.setJoinedDate(sqlDate);
            // Call the service to insert the UsersEntity object into the database
            if (adminService.employeeRegistration(empEmail, fname, lname, username, password, mobile, empType, sqlDate, gender)){
                return Response.status(201).entity("Success").build();
            }else {
                return Response.status(400).entity("Something went wrong..").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}
