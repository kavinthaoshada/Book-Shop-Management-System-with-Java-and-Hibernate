package com.calm.webdb.controller;

import com.calm.webdb.service.AdminService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/empBlockProcess")
public class EmployeeBlockProcessController {
    private AdminService adminService = new AdminService();
    @GET
    public Response empBlock(@QueryParam("email") String email){
        if(email==null) {
            return Response.status(400).entity("Email cannot be null").build();
        }
        adminService.employeeBlockProcess(email);
        return Response.status(200).entity("success").build();
    }
}
