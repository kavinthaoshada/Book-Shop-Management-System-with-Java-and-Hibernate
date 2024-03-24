package com.calm.webdb.controller;

import com.calm.webdb.service.AdminService;
import com.calm.webdb.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

@Path("/deleteCategoryProcess")
public class DeleteCategoryProcessController {
    private CategoryService categoryService = new CategoryService();
    private AdminService adminService = new AdminService();
    @GET
    public Response deleteCategory(@QueryParam("email") String email,
                                   @QueryParam("vt") String verificationText,
                                   @QueryParam("id") String id,
                                   @Context HttpServletRequest request){
        HttpSession session = request.getSession();
        if(verificationText.isEmpty()){
            return Response.status(400).entity("Verification code cannot be empty").build();
        }

        int categoryId = Integer.parseInt(id);

        if(adminService.checkVerificationCode(verificationText, request)){
            categoryService.deleteCategory(categoryId);
            return Response.status(200).entity("success").build();
        }else {
            return Response.status(400).entity("Invalid verification code").build();
        }

    }
}
