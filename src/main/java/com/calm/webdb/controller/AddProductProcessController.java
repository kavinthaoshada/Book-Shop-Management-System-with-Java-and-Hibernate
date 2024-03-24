package com.calm.webdb.controller;

import com.calm.webdb.service.ProductService;
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

@Path("/addProductProcess")
public class AddProductProcessController{
    public AddProductProcessController(){
    }
    private ProductService productService = new ProductService();
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
            int category = jsonNode.get("category").asInt();
            String author = jsonNode.get("author").asText();
            String publisher = jsonNode.get("publisher").asText();
            String title = jsonNode.get("title").asText();
            int condition = jsonNode.get("condition").asInt();
            int language = jsonNode.get("language").asInt();
            int edition = jsonNode.get("edition").asInt();
            int hformat = jsonNode.get("hformat").asInt();
            int eformat = jsonNode.get("eformat").asInt();
            int pages = jsonNode.get("pages").asInt();
            String description = jsonNode.get("description").asText();
            String base64Image = jsonNode.get("image").asText();

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

                    if(category==0){
                        return Response.status(500).entity("Please select a category").build();
                    }else if(author==null){
                        return Response.status(500).entity("Please select a Author").build();
                    }else if(publisher==null){
                        return Response.status(500).entity("Please select a Publisher").build();
                    }else if(title==null){
                        return Response.status(500).entity("Please enter the title of your product").build();
                    }else if(language==0){
                        return Response.status(500).entity("Please enter the title of your product").build();
                    }else if(hformat==0 && eformat==0){
                        return Response.status(500).entity("You have to checked at least one of edition.").build();
                    }else if(description==null){
                        return Response.status(500).entity("Please enter a description").build();
                    }else {
                        int authorId = productService.insertAuthor(author);
                        int publisherId = productService.insertPublisher(publisher);
                        int bookId = 0;
                        if(authorId==0){
                            return Response.status(500).entity("Author Id is 0").build();
                        }else if(publisherId==0){
                            return Response.status(500).entity("Publisher Id is 0").build();
                        }else{
                            bookId = productService.insertBook(title, description, pages, category, condition, authorId, publisherId, language, edition);
                        }

                        if(bookId==0){
                            return Response.status(500).entity("Book Id is 0").build();
                        }else{
                            productService.insertBookHasBookFormat(hformat, eformat, bookId);
                        }

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
                        String getPath = "assets/resources/product_img/" + System.currentTimeMillis() + "." + realImgExtension;
                        String fileName = constpath + getPath;

                        System.out.println("Generated FileName: " + fileName);
                        // Create a file output stream for the image file

                        FileOutputStream fos = new FileOutputStream(fileName);
                        // Write the image bytes to the file
                        fos.write(imageBytes);
                        fos.close();

                        System.out.println("Image saved to disk: " + fileName);

                        productService.insertProductImage(getPath, bookId);
//                    return Response.status(200).entity("Image uploaded successfully").build();

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    return Response.status(500).entity("Error uploading image: " + e.getMessage()).build();
                }
            }
            return Response.status(200).build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}
