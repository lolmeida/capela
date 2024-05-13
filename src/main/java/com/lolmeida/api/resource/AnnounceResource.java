package com.lolmeida.api.resource;


import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.api.ResourceApi;
import com.lolmeida.api.dto.request.AnnounceRequest;
import com.lolmeida.api.dto.response.AnnounceResponse;
import com.lolmeida.api.entity.database.Announce;
import com.lolmeida.api.openapi.Values;
import com.lolmeida.api.service.AnnounceService;

@Path(Values.Paths.ANNOUNCE)
public class AnnounceResource implements ResourceApi<AnnounceRequest> {

    @Inject
    AnnounceService service;

    public Response getAll() {
        List<AnnounceResponse> data = service.findAll().stream()
                                             .map(this::objToResponse)
                                             .toList();
        return Response.ok(data).build();
    }

    public Response search(
            @PathParam("field")
            final String field,
            @PathParam("value")
            final String value) {
        List<AnnounceResponse> data = service.search(field, value).stream()
                                             .map(this::objToResponse)
                                             .toList();
        return Response.ok(data).build();
    }

    public Response findByCustomer(
            @PathParam("id")
            final String id) {
        List<AnnounceResponse> data = service.search("id", id).stream()
                                             .map(this::objToResponse)
                                             .toList();
        return Response.ok(data).build();
    }

    public Response save(
            @RequestBody AnnounceRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Announce requestToObj(AnnounceRequest request) {
        return Announce.builder()
                       //.id(Utils.generateRandomString())
                       .type(request.type())
                       .tittle(request.tittle())
                       .url(request.url())

                       .build();
    }

    private AnnounceResponse objToResponse(Announce entity) {
        return AnnounceResponse.builder()
                               .type(entity.getType())
                               .tittle(entity.getTittle())
                               .url(entity.getUrl())

                               // BaseEntity
                               /* .active(entity.isActive())
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
