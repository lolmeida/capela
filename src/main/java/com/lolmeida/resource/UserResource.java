package com.lolmeida.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.api.ApiEndpoints;
import com.lolmeida.dto.request.UserRequest;
import com.lolmeida.dto.response.UserResponse;
import com.lolmeida.mapper.UserMapper;
import com.lolmeida.service.UserService;

@Path("/user")
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
            @PathParam("field")
            final String field,
            @PathParam("value")
            final String value) {
        List<UserResponse> data = service.search(field, value)
                                         .stream()
                                         .map(e -> mapper.objToResponse(e))
                                         .toList();
        return Response.ok(data).build();
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
