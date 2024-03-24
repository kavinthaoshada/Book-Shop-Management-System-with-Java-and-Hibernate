package com.calm.webdb.controller;


import com.calm.webdb.entity.UsersEntity;
import com.calm.webdb.service.CartService;
import com.calm.webdb.service.WachlistService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/addToWatchlistProcess")
public class AddToWatchlistProcessController {
    public AddToWatchlistProcessController() {
//        System.out.println("Add to watchlist");
    }

    private WachlistService wachlistService = new WachlistService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response addToWachlist(
            @QueryParam("id") String id,
            @Context HttpServletRequest request) {
        HttpSession session = request.getSession();

        try {

            if (id.isEmpty()) {
                return Response.status(400).entity("Stock ID cannot be Empty..").build();
            }

            String userEmail = null;
            List<UsersEntity> users = (List<UsersEntity>) session.getAttribute("u");
            if (users != null) {
                for (UsersEntity user : users) {
                    userEmail = user.getEmail();
                }
            }
            int stockId = Integer.parseInt(id);
            String status = wachlistService.addToWachlist(userEmail, stockId);
                return Response.status(200).entity(status).build();

        } catch (Exception e) {
            session.setAttribute("message", e.getMessage());
            return Response.serverError().build();
        }
    }
}
