package com.calm.webdb.controller;

import com.calm.webdb.service.GRNBasicSearchService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

import java.io.PrintWriter;

@Path("/basicSearchProcess")
public class BasicSearchProcessController {
    public BasicSearchProcessController() {

    }
    private static GRNBasicSearchService grnBasicSearchService = new GRNBasicSearchService();
    @POST
//    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(String bSearch, @Context HttpServletRequest request, @Context HttpServletResponse response) {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("text/html");

        if (bSearch == null) {
            return Response.status(400).entity("User cannot be null").build();
        }

        try {
            JsonNode jsonNode = objectMapper.readTree(bSearch);

            String searchText = jsonNode.get("txt").asText();
            int searchSelect = jsonNode.get("select").asInt();
            int page = jsonNode.get("page").asInt();

            String htmlContent = grnBasicSearchService.basicSearch(searchText, searchSelect, page);

            PrintWriter writer = response.getWriter();
            writer.println(htmlContent);
            writer.close();

            return Response.status(201).entity(bSearch).build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}
