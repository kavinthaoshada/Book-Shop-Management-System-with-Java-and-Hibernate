package com.calm.webdb.controller;

import com.calm.webdb.service.PaymentGatewayService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/changeInvoiceIDProcess")
public class ChangeInvoiceIDProcessController {
    private PaymentGatewayService paymentGatewayService = new PaymentGatewayService();
    @GET
    public Response changeInvoiceId(@QueryParam("id")String id){
        if(id.isEmpty()){
            return Response.status(400).entity("Id cannot be empty").build();
        }
        int invoiceId = Integer.parseInt(id);
        paymentGatewayService.invoiceStatusUpdate(invoiceId);
        return Response.status(200).entity("success").build();
    }
}
