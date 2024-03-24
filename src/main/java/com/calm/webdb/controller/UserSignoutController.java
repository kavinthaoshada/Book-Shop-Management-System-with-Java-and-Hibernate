package com.calm.webdb.controller;

import com.calm.webdb.service.UsersService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.io.PrintWriter;


@Path("/userSignout")
public class UserSignoutController {
    public UserSignoutController() {
        System.out.println("in signout1");
    }
    @GET
//    @Produces(MediaType.APPLICATION_JSON)
    public Response signoutUser(@Context HttpServletRequest request, @Context HttpServletResponse response) throws IOException {
        System.out.println("in signout2");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("in signout3");
        HttpSession session = request.getSession();
        if (session.getAttribute("u") != null) {
            System.out.println("in signout4");
            session.removeAttribute("u");
            session.invalidate();
            System.out.println("in signout5");
            out.println("success");
        } else {
            out.println("No active session found");
        }
        return Response.status(201).build();
    }
}
