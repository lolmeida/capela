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
import com.lolmeida.api.dto.request.UserRequest;
import com.lolmeida.api.dto.response.UserResponse;
import com.lolmeida.api.mapper.UserMapper;
import com.lolmeida.api.service.UserService;

@Path(ApplicationPaths.API_USER)
public class UserResource implements ApiEndpoints {

    @Inject
    UserService service;
    @Inject
    UserMapper mapper;

    @Override
    public Response hello() {
        return null;
    }

    @Override
    public Response getAll() {
        List<UserResponse> data = service.findAll("date, id")
                                         .stream()
                                         .map(e -> mapper.objToResponse(e))
                                         .toList();
        return Response.ok(data).build();
    }

    @Override
    public Response search(
            final String field,
            final String value) {
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
        List<UserResponse> data = service.findBy(id)
                                         .stream()
                                         .map(e -> mapper.objToResponse(e))
                                         .toList();
        return Response.ok(data).build();
    }

    //--------

    @Override
    public Response save(final Object request) {
        service.save(mapper.requestToObj((UserRequest) request));
        return Response
                .ok(service.search("id", service.save(mapper.requestToObj((UserRequest) request))))
                .build();
    }

}
