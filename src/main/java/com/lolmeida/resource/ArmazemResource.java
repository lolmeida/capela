package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.ArmazemRequest;
import com.lolmeida.entity.database.Armazem;
import com.lolmeida.service.ArmazemService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/armazem")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArmazemResource {
    @Inject
    ArmazemService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List data = service.findAll().stream().toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/search/{field}/{value}")
    public Response search(
            @PathParam("field") final String field,
            @PathParam("value") final String value) {
        List data = service.search( field, value);
        return Response.ok(data).build();
    }

    @GET
    @Path("/customer/{customerId}")
    public Response findByCustomer(@PathParam("customerId") final String customerId){
        List data = service.findBy(customerId);
        return Response.ok(data).build();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody ArmazemRequest request) {
        service.save(requestToObj(request));
        return Response.ok(request).build();
    }

    private Armazem requestToObj(ArmazemRequest request) {
        return Armazem.builder()
                .id(Utils.generateRandomString())
                .Armazem(request.Armazem())
                .Morada(request.Morada())
                .Teletofe(request.Teletofe())
                .YN(request.YN())
                .build();
    }
}
