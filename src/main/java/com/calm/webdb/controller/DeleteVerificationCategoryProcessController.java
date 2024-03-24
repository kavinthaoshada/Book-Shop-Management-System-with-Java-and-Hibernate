package com.calm.webdb.controller;

import com.calm.webdb.service.AdminService;
import com.calm.webdb.service.EmailService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

@Path("/deleteVerificationCategoryProcess")
public class DeleteVerificationCategoryProcessController {
    private AdminService adminService = new AdminService();
    @GET
    public Response deleteVerification(@QueryParam("email") String email, @Context HttpServletRequest request){
        HttpSession session = request.getSession();
        if(email.isEmpty()){
            return Response.status(400).entity("Email cannot be empty").build();
        }
        String verificationCode = adminService.adminVerificationUpdate(email);
        EmailService emailService = new EmailService();
        EmailController emailController = new EmailController(emailService);
        String htmlContent = "<html><body><h1>Admin Verification Code</h1><p>Your verification code for delete new caegory : "+verificationCode+"</p></body></html>";

//                emailController.sendEmail(email, "Admin Verification Code", htmlContent);
        return Response.status(201).entity("success").build();

    }
}
