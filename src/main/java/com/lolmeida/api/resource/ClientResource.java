package com.lolmeida.api.resource;

import java.util.List;
import java.util.Optional;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import com.lolmeida.ApplicationPaths;
import com.lolmeida.ApplicationValues;
import com.lolmeida.api.ApiEndpoints;
import com.lolmeida.api.dto.request.ClientRequest;
import com.lolmeida.api.dto.response.ClientResponse;
import com.lolmeida.api.mapper.ClientMapper;
import com.lolmeida.api.service.ClientService;

@Path(ApplicationPaths.API_CLIENT)

public class ClientResource implements ApiEndpoints {

    @Inject
    ClientService service;
    @Inject
    ClientMapper mapper;

    @Override
    public Response hello() {
        return null;
    }

    @Override
    public Response getAll() {
        List<ClientResponse> data = service.findAll("date, name")
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
    public Response findBy(final String id) {
        List<ClientResponse> data = service.findBy(id)
                                           .stream()
                                           .map(e -> mapper.objToResponse(e))
                                           .toList();
        return Response.ok(data).build();
    }

    @Override
    public Response save(final Object request) {
        service.save(mapper.requestToObj((ClientRequest) request));
        return Response
                .ok(service.search("name", service.save(mapper.requestToObj((ClientRequest) request))))
                .build();
    }


}
