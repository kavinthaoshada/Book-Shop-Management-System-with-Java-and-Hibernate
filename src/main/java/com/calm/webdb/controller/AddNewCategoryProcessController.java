package com.calm.webdb.controller;

import com.calm.webdb.service.AdminService;
import com.calm.webdb.service.CategoryService;
import com.calm.webdb.service.EmailService;
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


@Path("/addNewCategoryProcess")
public class AddNewCategoryProcessController {
    private CategoryService categoryService = new CategoryService();
    private AdminService adminService = new AdminService();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewCategory(String data, @Context HttpServletRequest request){
        ObjectMapper objectMapper = new ObjectMapper();
        HttpSession session = request.getSession();
        if(data.isEmpty()){
            return Response.status(400).entity("Data cannot be empty").build();
        }
        try {
            JsonNode jsonNode = objectMapper.readTree(data);
            String newCategory = jsonNode.get("newCategory").asText();
            String email = jsonNode.get("email").asText();

            if(categoryService.isExistCategory(newCategory)){
                return Response.status(400).entity("categery is already exist.").build();
            }

            String updatedUniqueId = adminService.adminVerificationUpdate(email);

            String verificationCode = adminService.adminVerificationUpdate(email);
            EmailService emailService = new EmailService();
            EmailController emailController = new EmailController(emailService);
            String htmlContent = "<html><body><h1>Admin Verification Code</h1><p>Your verification code for add new caegory : "+verificationCode+"</p></body></html>";

//                emailController.sendEmail(email, "Admin Verification Code", htmlContent);
            return Response.status(201).entity("success").build();

        }catch(Exception e){
            e.printStackTrace();
            return Response.status(500).entity("Error").build();
        }
    }
}
