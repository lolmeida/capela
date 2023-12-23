package com.lolmeida.api.resource;

import java.util.List;
import java.util.Optional;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.ApplicationPaths;
import com.lolmeida.ApplicationValues;
import com.lolmeida.api.ApiEndpoints;
import com.lolmeida.api.dto.request.RecipientRequest;
import com.lolmeida.api.dto.response.RecipientResponse;
import com.lolmeida.api.mapper.RecipientMapper;
import com.lolmeida.api.service.RecipientService;

@Path(ApplicationPaths.API_RECIPIENT)
public class RecipientResource implements ApiEndpoints {

    @Inject
    RecipientService service;
    @Inject
    RecipientMapper mapper;

    @Override
    public Response hello() {
        return null;
    }

    @Override
    public Response getAll() {
        List<RecipientResponse> data = service.findAll("date, id")
                                              .stream()
                                              .map(e -> mapper.objToResponse(e))
                                              .toList();
        return Response.ok(data).build();
    }

    @Override
    public Response search(final String field, final String value) {
        return Response.ok(
                Optional.of(
                        service.search(field, value)
                               .stream()
                               .map(e -> mapper.objToResponse(e))
                               .toList()
                ).orElseThrow(() -> new RuntimeException(ApplicationValues.Resources.NOT_FOUND_ERROR))
        ).build();
    }

    @Override
    public Response findBy(
            @PathParam("id")
            final String id) {
        List<RecipientResponse> data = service.findBy(id)
                                              .stream()
                                              .map(e -> mapper.objToResponse(e))
                                              .toList();
        return Response.ok(data).build();
    }

    @Override
    public Response save(final Object request) {
        service.save(mapper.requestToObj((RecipientRequest) request));
        return Response
                .ok(service.search("id", service.save(mapper.requestToObj((RecipientRequest) request))))
                .build();
    }

}
