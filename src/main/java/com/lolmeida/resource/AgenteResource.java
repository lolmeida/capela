package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.AgenteRequest;
import com.lolmeida.dto.response.AgenteResponse;
import com.lolmeida.entity.database.Agente;
import com.lolmeida.service.AgenteService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/agente")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgenteResource  {
    @Inject
    AgenteService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List data = service.findAll().stream()
                .map(e ->objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/search/{field}/{value}")
    public Response search(
            @PathParam("field") final String field,
            @PathParam("value") final String value) {
        List data = service.search( field, value).stream()
                .map(e ->objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")

    public Response findByCustomer(@PathParam("id") final String id){
        List data = service.findBy(id).stream()
                .map(e ->objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody AgenteRequest request) {
        service.save(requestToObj(request));

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Agente requestToObj(AgenteRequest request) {
        return Agente.builder()
                .Id(Utils.generateRandomString())
                .name(request.name())
                .email(request.email())
                .contact(request.contact())
                .build();
    }

    private AgenteResponse objToResponse (Agente entity){
        return AgenteResponse.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .contact(entity.getContact())

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
