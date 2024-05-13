package com.lolmeida.api.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.api.ResourceApi;
import com.lolmeida.api.dto.request.SizeRequest;
import com.lolmeida.api.dto.response.SizeResponse;
import com.lolmeida.api.entity.database.Size;
import com.lolmeida.api.openapi.Values;
import com.lolmeida.api.service.DimensionService;

@Path(Values.Paths.SIZE)
public class SizeResource implements ResourceApi<SizeRequest> {

    @Inject
    DimensionService service;

    public Response getAll() {
        List<SizeResponse> data = service.findAll("cargo")
                                         .stream()
                                         .map(this::objToResponse)
                                         .toList();
        return Response.ok(data).build();
    }

    public Response search(
            @PathParam("field")
            final String field,
            @PathParam("value")
            final String value) {
        List<SizeResponse> data = service.search(field, value)
                                         .stream()
                                         .map(this::objToResponse)
                                         .toList();
        return Response.ok(data).build();
    }

    public Response findByCustomer(
            @PathParam("id")
            final String id) {
        List<SizeResponse> data = service.search("id", id)
                                         .stream()
                                         .map(this::objToResponse)
                                         .toList();
        return Response.ok(data).build();
    }

    public Response save(
            @RequestBody SizeRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Size requestToObj(SizeRequest request) {
        return Size.builder()
                   //.id(Utils.generateRandomString())
                   .height(request.height())
                   .length(request.length())
                   .width(request.width())
                   .volume(request.volume())
                   .cargo(request.cargo())
                   .build();
    }

    private SizeResponse objToResponse(Size entity) {
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
