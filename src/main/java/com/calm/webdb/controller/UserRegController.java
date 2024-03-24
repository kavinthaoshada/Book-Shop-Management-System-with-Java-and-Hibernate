package com.calm.webdb.controller;

import com.calm.webdb.entity.UsersEntity;
import com.calm.webdb.service.UsersService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Path("/userRegister")
public class UserRegController {
    public UserRegController() {

    }
    private static UsersService usersService = new UsersService();
    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
    public Response regUser(String user) {
        ObjectMapper objectMapper = new ObjectMapper();

        if (user == null) {
            return Response.status(400).entity("User cannot be null").build();
        }

        try {
            JsonNode jsonNode = objectMapper.readTree(user);

            UsersEntity usersEntity = new UsersEntity();
            usersEntity.setFname(jsonNode.get("fname").asText());
            usersEntity.setLname(jsonNode.get("lname").asText());
            usersEntity.setEmail(jsonNode.get("email").asText());
            usersEntity.setPassword(jsonNode.get("password").asText());
            usersEntity.setMobile(jsonNode.get("mobile").asText());
            usersEntity.setGenderId(jsonNode.get("gender").asInt());

            String dateString = jsonNode.get("joinDate").asText();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  // Adjust the format based on your JSON date format
            java.util.Date utilDate;
            utilDate = dateFormat.parse(dateString);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            usersEntity.setJoinedDate(sqlDate);
            // Call the service to insert the UsersEntity object into the database
            usersService.addUser(usersEntity);

            return Response.status(201).entity(user).build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}
