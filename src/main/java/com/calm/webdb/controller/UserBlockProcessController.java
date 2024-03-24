package com.calm.webdb.controller;

import com.calm.webdb.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

@Path("/userBlockProcess")
public class UserBlockProcessController {
    private UsersService usersService = new UsersService();
    @GET
    public Response userBlock(@QueryParam("email")String email){
        if(email == null){
            return Response.status(400).entity("Email cannot be null").build();
        }
        usersService.userBlockProcess(email);
        return Response.status(200).entity("success").build();
    }
}
