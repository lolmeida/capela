package com.lolmeida.api.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.api.ResourceApi;
import com.lolmeida.api.dto.request.PostalCodeRequest;
import com.lolmeida.api.dto.response.PostalCodeResponse;
import com.lolmeida.api.entity.database.PostalCode;
import com.lolmeida.api.openapi.Values;
import com.lolmeida.api.service.PostalCodeService;

@Path(Values.Paths.POSTAL_CODE)
public class PostalCodeResource implements ResourceApi<PostalCodeRequest> {

    @Inject
    PostalCodeService service;

    public Response getAll() {
        List<PostalCodeResponse> data = service.findAll()
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
        List<PostalCodeResponse> data = service.search(field, value)
                                               .stream()
                                               .map(this::objToResponse)
                                               .toList();
        return Response.ok(data).build();
    }

    public Response findByCustomer(
            @PathParam("id")
            final String id) {
        List<PostalCodeResponse> data = service.findBy(id)
                                               .stream()
                                               .map(this::objToResponse)
                                               .toList();
        return Response.ok(data).build();
    }

    public Response save(
            @RequestBody PostalCodeRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private PostalCode requestToObj(PostalCodeRequest request) {
        return PostalCode.builder()
                         //.id(Utils.generateRandomString())
                         .code(request.code())
                         .address(request.address())
                         .build();
    }

    private PostalCodeResponse objToResponse(PostalCode entity) {
        return PostalCodeResponse.builder()
                                 .address(entity.getAddress())
                                 .code(entity.getCode())

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
