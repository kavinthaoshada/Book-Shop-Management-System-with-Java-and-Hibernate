package com.calm.webdb.controller;

import com.calm.webdb.entity.EmployeeEntity;
import com.calm.webdb.entity.UsersEntity;
import com.calm.webdb.service.GRNService;
import com.calm.webdb.service.PaymentGatewayService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;

import java.text.ParseException;
import java.util.List;

@Path("/charge")
public class CheckoutChargeController {

    private static PaymentGatewayService paymentGatewayService = new PaymentGatewayService();
    // Set your secret key: remember to change this to your live secret key in production
    private final String secretKey = "sk_test_51LauixIjAOH1QSloPr2sXEriaErKeTGL4r7WYcBG9j6rLuGhTKtBvZLjdJFdF5dXg5hREQEDtiZeLnZeKYPXOWRr00tmlPceDV";
    @POST
    public Response createCharge(String jsonObject, @Context HttpServletRequest request, @Context HttpServletResponse response) {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpSession session = request.getSession();
        if (jsonObject == null) {
            return Response.status(400).entity("jsonObject cannot be null").build();
        }
        try {
            String userEmail = null;
            List<UsersEntity> users = (List<UsersEntity>) session.getAttribute("u");
            if (users != null) {
                for (UsersEntity user : users) {
                    userEmail = user.getEmail();
                }
            }else{
                userEmail = "empty";
            }
            Stripe.apiKey = secretKey;

            JsonNode jsonNode = objectMapper.readTree(jsonObject);
            int amount = jsonNode.get("amount").asInt();
            String token = jsonNode.get("token").asText();
            int inputQty = jsonNode.get("inputQty").asInt();
            int sid = jsonNode.get("sid").asInt();
            String c_name = jsonNode.get("c_name").asText();
            String address = jsonNode.get("address").asText();

            String amountString = jsonNode.get("amount").asText();
            String sanitizedAmountString = amountString.replace(",", "");
            long amountInCents = Long.parseLong(sanitizedAmountString) * 100;

            Charge charge = Charge.create(new ChargeCreateParams.Builder()
                    .setAmount(amountInCents)
                    .setCurrency("lkr")
                    .setSource(token)
                    .build());

            String orderID = paymentGatewayService.createPayment(amount, inputQty, sid, c_name, address, userEmail);

            // Process the charge and insert data to the database using Hibernate
            // Add your Hibernate code to insert data into the database here

//            response.getWriter().write("Payment successful! Charge ID: " + charge.getId());
            return Response.status(200).entity(orderID+" "+userEmail+" "+c_name+" "+address).build();
        } catch (StripeException e) {
//            response.getWriter().write("Payment failed. Error: " + e.getMessage());
            return Response.status(200).entity("Payment failed. Error: " + e.getMessage()).build();
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

