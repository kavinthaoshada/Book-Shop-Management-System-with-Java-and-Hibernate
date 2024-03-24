package com.calm.webdb.controller;


import com.calm.webdb.entity.EmployeeEntity;
import com.calm.webdb.entity.UsersEntity;
import com.calm.webdb.service.CartService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@Path("/addToCartProcess")
public class AddToCartProcessController {
    public AddToCartProcessController() {
//        System.out.println("Add to cart");
    }

    private CartService cartService = new CartService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response addToCart(
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
            int status = cartService.addToCart(userEmail, stockId);
            if(status == 200){
                return Response.status(200).entity("Success").build();
            }if (status == 400){
                return Response.status(400).entity("Product Qty is invalid").build();
            }else{
                return Response.status(500).entity("Something went wrong").build();
            }
        } catch (Exception e) {
            session.setAttribute("message", e.getMessage());
            return Response.serverError().build();
        }
    }
}
