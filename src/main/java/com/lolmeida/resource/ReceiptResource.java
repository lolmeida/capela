package com.lolmeida.resource;

import com.lolmeida.dto.request.ReceiptRequest;
import com.lolmeida.dto.response.ReceiptResponse;
import com.lolmeida.mapper.ReceiptMapper;
import com.lolmeida.service.ReceiptService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/receipt")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReceiptResource {
    @Inject
    ReceiptService service;
    @Inject
    ReceiptMapper mapper;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<ReceiptResponse> data = service.findAll("date, id")
                .stream()
                .map(e ->mapper.objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/search/{field}/{value}")
    public Response search(
            @PathParam("field") final String field,
            @PathParam("value") final String value) {
        List<ReceiptResponse> data = service.search(field, value)
                .stream()
                .map(e ->mapper.objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")
    public Response findByCustomer(@PathParam("id") final String id) {
        List<ReceiptResponse> data = service.findBy(id)
                .stream()
                .map(e ->mapper.objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    //--------

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody ReceiptRequest request) {


        service.save(mapper.requestToObj(request));

        return Response
                .ok(service.search("id", service.save(mapper.requestToObj(request))))
                .build();
    }

}
