package com.calm.webdb.controller;

import com.calm.webdb.service.AdminService;
import com.calm.webdb.service.EmailService;
import com.calm.webdb.service.UsersService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

@Path("/adminVerificationProcess")
public class AdminVerificationController {
    private static AdminService adminService = new AdminService();
    @POST
//    @Produces(MediaType.APPLICATION_JSON)
    public Response adminVerification(String admin) {
        ObjectMapper objectMapper = new ObjectMapper();
        if (admin == null) {
            return Response.status(400).entity("User cannot be null").build();
        }
        try {
            JsonNode jsonNode = objectMapper.readTree(admin);
            String email = jsonNode.get("email").asText();

            if(adminService.existAdmin(email)){
                String verificationCode = adminService.adminVerificationUpdate(email);
                EmailService emailService = new EmailService();
                EmailController emailController = new EmailController(emailService);
                String htmlContent = "<html><body><h1>Admin Verification Code</h1><p>Your verification code is : "+verificationCode+"</p></body></html>";

//                emailController.sendEmail(email, "Admin Verification Code", htmlContent);
                return Response.status(201).build();
            }else{
                return Response.status(500).build();
            }
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

}
