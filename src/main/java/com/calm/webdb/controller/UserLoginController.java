package com.calm.webdb.controller;

import com.calm.webdb.service.UsersService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

@Path("/userLogin")
public class UserLoginController {
    public UserLoginController() {

    }
    private static UsersService usersService = new UsersService();
    @POST
//    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(String user, @Context HttpServletRequest request, @Context HttpServletResponse response) {
        ObjectMapper objectMapper = new ObjectMapper();

        if (user == null) {
            return Response.status(400).entity("User cannot be null").build();
        }

        try {
            JsonNode jsonNode = objectMapper.readTree(user);

            String email = jsonNode.get("email").asText();
            String password = jsonNode.get("password").asText();
//            List<UsersEntity> users = usersService.existUser(email, password);

            if(usersService.existUser(email, password,request)){
                if(jsonNode.get("rememberMe").asText()=="true"){
                    addCookie(response, "email", email);
                    addCookie(response, "password", password);
                }else{
                    removeCookie(response, "email");
                    removeCookie(response, "password");
                }
            }

            return Response.status(201).entity(user).build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
    private void addCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(60 * 60 * 24 * 365);  // Set the cookie to last for 1 year
        response.addCookie(cookie);
    }

    private void removeCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, "");
        cookie.setMaxAge(0);  // Set the cookie's maximum age to 0 for removal
        response.addCookie(cookie);
    }
}


