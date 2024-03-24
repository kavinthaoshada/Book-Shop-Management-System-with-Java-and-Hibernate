package com.calm.webdb.controller;

import com.calm.webdb.entity.UsersEntity;
import com.calm.webdb.service.UsersService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Path("/updateUserProfile")
public class UserProfileUpdateController{
    public UserProfileUpdateController(){
    }
    private UsersService usersService = new UsersService();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserProfile(String userJson, @Context HttpServletRequest request) {

        ObjectMapper objectMapper = new ObjectMapper();
        HttpSession session = request.getSession();

        if (userJson == null) {
            session.setAttribute("message", "Employee ID cannot be null");
            return null;
        }
        try {
            JsonNode jsonNode = objectMapper.readTree(userJson);
            String fname = jsonNode.get("fname").asText();
            String lname = jsonNode.get("lname").asText();
            String mobile = jsonNode.get("mobile").asText();
            String line1 = jsonNode.get("line1").asText();
            String line2 = jsonNode.get("line2").asText();
            int city = jsonNode.get("city").asInt();
            String postal_code = jsonNode.get("postal_code").asText();
            String base64Image = jsonNode.get("image").asText();

            String user_email = "no";
            if (base64Image != null) {
                try {
                    // Convert base64 string to bytes
                    String[] parts = base64Image.split(",");
                    String imageData = parts[1];
                    String[] imageType = parts[0].split(":");
                    String[] imageExtension = imageType[1].split("/");
                    String fileExtension = imageExtension[1];
                    String[] fileExtensionParts = fileExtension.split(";");
                    String realImgExtension = fileExtensionParts[0];

                    // Decode base64 to image bytes
                    byte[] imageBytes = Base64.getDecoder().decode(imageData);

                    // Check image type and extension
                    String[] allowedImageExtensions = {"jpg", "jpeg", "png", "svg+xml"};
                    boolean isAllowedExtension = false;

                    for (String allowedExtension : allowedImageExtensions) {
                        if (realImgExtension.equalsIgnoreCase(allowedExtension)) {
                            isAllowedExtension = true;
                            break;
                        }
                    }
                    System.out.println(realImgExtension);
                    if (!isAllowedExtension) {
                        return Response.status(400).entity("Please select a valid image").build();
                    }

                    // Generate a unique filename
                    String constpath = "src/main/Webapp/";
                    String getPath = "assets/resources/profile_images/" + System.currentTimeMillis() + "." + realImgExtension;
                    String fileName = constpath+getPath;

                    System.out.println("Generated FileName: " + fileName);
                        // Create a file output stream for the image file

                        FileOutputStream fos = new FileOutputStream(fileName);
                        // Write the image bytes to the file
                        fos.write(imageBytes);
                        fos.close();

                        System.out.println("Image saved to disk: " + fileName);

                    List<UsersEntity> users = (List<UsersEntity>) session.getAttribute("u");
                    if (users != null) {
                        for (UsersEntity user : users) {
                            user_email = user.getEmail();
                        }
                    }
                    System.out.println("im in up controller 10");
                    usersService.updateProfileImageOfUser(user_email, getPath);
                    System.out.println("im in up controller 11");
//                    return Response.status(200).entity("Image uploaded successfully").build();

                } catch (IOException e) {
                    e.printStackTrace();
                    return Response.status(500).entity("Error uploading image: " + e.getMessage()).build();
                }
            }
            System.out.println("im in up controller 12");
            usersService.updateUser(user_email, fname, lname, mobile);
            System.out.println("im in up controller 13");
            if(city!=0){
                usersService.updateUsersAddress(user_email, line1, line2, city, postal_code);
            }
            System.out.println("im in up controller 14");
            return Response.status(200).build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}