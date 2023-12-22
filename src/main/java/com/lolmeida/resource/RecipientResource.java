package com.lolmeida.resource;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.dto.request.RecipientRequest;
import com.lolmeida.dto.response.RecipientResponse;
import com.lolmeida.mapper.RecipientMapper;
import com.lolmeida.service.RecipientService;

@Path("/recipient")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecipientResource {
    @Inject
    RecipientService service;
    @Inject
    RecipientMapper mapper;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<RecipientResponse> data = service.findAll("date, id")
                .stream()
                .map(e -> mapper.objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/search/{field}/{value}")
    public Response search(
            @PathParam("field") final String field,
            @PathParam("value") final String value) {
        List<RecipientResponse> data = service.search(field, value)
                .stream()
                .map(e -> mapper.objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")
    public Response findByCustomer(@PathParam("id") final String id) {
        List<RecipientResponse> data = service.findBy(id)
                .stream()
                .map(e -> mapper.objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    //--------

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody final RecipientRequest request) {


        service.save(mapper.requestToObj(request));

        return Response
                .ok(service.search("id", service.save(mapper.requestToObj(request))))
                .build();
    }
    
}
