package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.ConfigurationRequest;
import com.lolmeida.dto.response.ConfigurationResponse;
import com.lolmeida.entity.database.Configuration;
import com.lolmeida.service.ConfigurationService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/configuracao")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConfigurationResource {
    @Inject
    ConfigurationService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<ConfigurationResponse> data = service.findAll()
                .stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/search/{field}/{value}")
    public Response search(
            @PathParam("field") final String field,
            @PathParam("value") final String value) {
        List<ConfigurationResponse> data = service.search(field, value)
                .stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")
    public Response findByCustomer(@PathParam("id") final String id) {
        List<ConfigurationResponse> data = service.findBy(id)
                .stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody ConfigurationRequest request) {
        service.save(requestToObj(request));

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Configuration requestToObj(ConfigurationRequest request) {
        return Configuration.builder()
                .id(Utils.generateRandomString())
                .key(request.key())
                .value(request.value())
                .description(request.description())
                .build();
    }

    private ConfigurationResponse objToResponse(Configuration entity) {
        return ConfigurationResponse.builder()
                .key(entity.getKey())
                .value(entity.getValue())
                .description(entity.getDescription())

                // BaseEntity
                .active(entity.isActive())
                .note(entity.getNote())
                .description(entity.getDescription())
                .attachment(entity.getAttachment())
                .image(entity.getImage())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .createdTime(entity.getCreatedTime())
                .updatedBy(entity.getUpdatedBy())
                .updatedTime(entity.getUpdatedTime())
                .updatedAt(entity.getUpdatedAt())
                .date(entity.getDate())

                .build();
    }
}
