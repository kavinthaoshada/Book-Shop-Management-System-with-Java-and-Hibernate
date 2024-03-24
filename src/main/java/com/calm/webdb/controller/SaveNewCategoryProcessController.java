package com.calm.webdb.controller;

import com.calm.webdb.service.AdminService;
import com.calm.webdb.service.CategoryService;
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

@Path("/saveNewCategoryProcess")
public class SaveNewCategoryProcessController {
    private AdminService adminService = new AdminService();
    private CategoryService categoryService = new CategoryService();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveNewCategory(String data, @Context HttpServletRequest request){
        ObjectMapper objectMapper = new ObjectMapper();
        HttpSession session = request.getSession();
        if(data=="null"){
            return Response.status(400).entity("Data cannot be null").build();
        }
        try {
            JsonNode jsonNode = objectMapper.readTree(data);
            String verificationCode = jsonNode.get("text").asText();
            String newCategory = jsonNode.get("newCategory").asText();
            String email = jsonNode.get("email").asText();

            if(adminService.checkVerificationCode(verificationCode, request)){
                categoryService.addNewCategory(newCategory);
                return Response.status(200).entity("success").build();
            }else {
                return Response.status(400).entity("Something went wrong").build();
            }

        }catch (Exception e){
            e.printStackTrace();
            return Response.status(500).entity("Error").build();
        }
    }
}
