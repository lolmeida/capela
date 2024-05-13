package com.lolmeida.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;


@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ResourceApi<T> {

    @GET
    @Path(ApplicationPaths.ROOT)
    @Produces(MediaType.APPLICATION_JSON)
    Response getAll();

    @GET
    @Path(ApplicationPaths.SEARCH)
    Response search(
            @PathParam("field")
            final String field,

            @PathParam("value")
            final String value
    );

    @GET
    @Path(ApplicationPaths.FIND_BY)
    Response findByCustomer(
            @PathParam("id")
            final String id
    );

    @POST
    @Path(ApplicationPaths.ROOT)
    @Produces(MediaType.APPLICATION_JSON)
    Response save(
            @RequestBody
            T request
    );
}
