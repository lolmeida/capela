package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.AnuncioRequest;
import com.lolmeida.dto.response.AnuncioResponse;
import com.lolmeida.entity.database.Anuncio;
import com.lolmeida.service.AnuncioService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/anuncio")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AnuncioResource {
    @Inject
    AnuncioService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<AnuncioResponse> data = service.findAll().stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/search/{field}/{value}")
    public Response search(
            @PathParam("field") final String field,
            @PathParam("value") final String value) {
        List<AnuncioResponse> data = service.search( field, value).stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")
    public Response findByCustomer(@PathParam("id") final String id){
        List<AnuncioResponse> data = service.findBy(id).stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody AnuncioRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Anuncio requestToObj(AnuncioRequest request) {
        return Anuncio.builder()
                .id(Utils.generateRandomString())
                .type(request.type())
                .tittle(request.tittle())
                .url(request.url())

                .build();
    }

    private AnuncioResponse objToResponse (Anuncio entity) {
        return AnuncioResponse.builder()
                .type(entity.getType())
                .tittle(entity.getTittle())
                .url(entity.getUrl())

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
