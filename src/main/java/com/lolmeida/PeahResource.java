package com.lolmeida;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

public interface PeahResource <T> {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    Response getAll();

    @GET
    @Path("/search/{field}/{value}")
    Response search(
            @PathParam("field") final String field,
            @PathParam("value") final String value);

    @GET
    @Path("/{id}")
    Response findByCustomer(
            @PathParam("id") final String id);

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    Response save(@RequestBody T request);

}
