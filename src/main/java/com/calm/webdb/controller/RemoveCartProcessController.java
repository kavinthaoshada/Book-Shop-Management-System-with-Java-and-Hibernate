package com.calm.webdb.controller;

import com.calm.webdb.entity.UsersEntity;
import com.calm.webdb.service.CartService;
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

@Path("/removeCartProcess")
public class RemoveCartProcessController {
    public RemoveCartProcessController() {
//        System.out.println("Add to cart");
    }

    private CartService cartService = new CartService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteFromCart(
            @QueryParam("id") String id,
            @Context HttpServletRequest request) {
        HttpSession session = request.getSession();

        try {

            if (id.isEmpty()) {
                return Response.status(400).entity("Stock ID cannot be Empty..").build();
            }

            int cartId = Integer.parseInt(id);
            int status = cartService.deleteFromCart(cartId);
            if(status == 200){
                return Response.status(200).entity("Success").build();
            }else{
                return Response.status(500).entity("Something went wrong").build();
            }
        } catch (Exception e) {
            session.setAttribute("message", e.getMessage());
            return Response.serverError().build();
        }
    }
}
