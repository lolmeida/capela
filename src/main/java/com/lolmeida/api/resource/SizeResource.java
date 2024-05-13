package com.lolmeida.resource;

import com.lolmeida.api.dto.request.SizeRequest;
import com.lolmeida.api.dto.response.SizeResponse;
import com.lolmeida.api.entity.database.Size;
import com.lolmeida.api.service.DimensionService;
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
public class SizeResource {
    @Inject
    DimensionService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<SizeResponse> data = service.findAll("cargo")
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
        List<SizeResponse> data = service.search( field, value)
                .stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")
    public Response findByCustomer(@PathParam("id") final String id){
        List<SizeResponse> data = service.findBy(id)
                .stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    //--------

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody SizeRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Size requestToObj (SizeRequest request){
        return Size.builder()
                //.id(Utils.generateRandomString())
                .height(request.height())
                .length(request.length())
                .width(request.width())
                .volume(request.volume())
                .cargo(request.cargo())
                .build();
    }

    private SizeResponse objToResponse (Size entity) {
        return SizeResponse.builder()
                .height(entity.getHeight())
                .length(entity.getLength())
                .width(entity.getWidth())
                .volume(entity.getVolume())
                .cargo(entity.getCargo())

                // BaseEntity
                /*.active(entity.isActive())
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
                .date(entity.getDate())*/

                .build();
    }

}
