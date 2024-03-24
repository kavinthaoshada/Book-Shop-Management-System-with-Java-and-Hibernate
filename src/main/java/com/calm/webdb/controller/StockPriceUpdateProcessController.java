package com.calm.webdb.controller;

import com.calm.webdb.service.ProductService;
import com.calm.webdb.service.StockService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@Path("/addProductProcess")
public class StockPriceUpdateProcessController{
    public StockPriceUpdateProcessController(){
    }
    private StockService stockService = new StockService();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserProfile(String userJson, @Context HttpServletRequest request) {

        ObjectMapper objectMapper = new ObjectMapper();
        HttpSession session = request.getSession();

        if (userJson == null) {
            return Response.status(400).entity("UserJason cannot be Empty..").build();
        }
        try {
            JsonNode jsonNode = objectMapper.readTree(userJson);
            int stockId = jsonNode.get("id").asInt();
            double sellingPrice = jsonNode.get("sprice").asDouble();
            double dow = jsonNode.get("dow").asDouble();
            double doc = jsonNode.get("doc").asDouble();

            stockService.updateStock(stockId, sellingPrice, dow, doc);

            return Response.status(200).entity("success").build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}
