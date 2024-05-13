package com.lolmeida.api.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.api.ResourceApi;
import com.lolmeida.api.dto.request.StatusRequest;
import com.lolmeida.api.dto.response.StatusResponse;
import com.lolmeida.api.entity.database.Status;
import com.lolmeida.api.openapi.Values;
import com.lolmeida.api.service.StatusService;

@Path(Values.Paths.STATUS)
public class StatusResource implements ResourceApi<StatusRequest> {

    @Inject
    StatusService service;

    public Response getAll() {
        List<StatusResponse> data = service.findAll()
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
        List<StatusResponse> data = service.search(field, value)
                                           .stream()
                                           .map(this::objToResponse)
                                           .toList();
        return Response.ok(data).build();
    }

    public Response findByCustomer(
            @PathParam("id")
            final String id) {
        List<StatusResponse> data = service.search("id", id)
                                           .stream()
                                           .map(this::objToResponse)
                                           .toList();
        return Response.ok(data).build();
    }

    public Response save(
            @RequestBody StatusRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Status requestToObj(StatusRequest request) {
        return Status.builder()
                     //.id(Utils.generateRandomString())
                     .status(request.status())
                     .quantity(request.quantity())
                     .formula(request.formula())
                     .type(request.type())
                     .build();
    }

    private StatusResponse objToResponse(Status entity) {
        return StatusResponse.builder()
                                .id(entity.getId())
                             .status(entity.getStatus())
                             .quantity(entity.getQuantity())
                             .formula(entity.getFormula())
                             .type(entity.getType())

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
