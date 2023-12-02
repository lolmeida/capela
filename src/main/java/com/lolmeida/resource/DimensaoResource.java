package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.DimensaoRequest;
import com.lolmeida.entity.database.Dimensao;
import com.lolmeida.service.DimensaoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/dimensao")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DimensaoResource {
    @Inject
    DimensaoService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List data = service.findAll("Comprimento").stream().toList();
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

    //--------

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody DimensaoRequest request) {
        service.save(requestToObj(request));
        return Response.ok(request).build();
    }

    private Dimensao requestToObj (DimensaoRequest request){
        return Dimensao.builder()
                .IdDimensoes(Utils.generateRandomString())
                .Altura(request.Altura())
                .Comprimento(request.Comprimento())
                .Largura(request.Largura())
                .Vol(request.Vol())
                .build();
    }

}
