package com.lolmeida.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.api.ApiEndpoints;
import com.lolmeida.dto.request.SizeRequest;
import com.lolmeida.dto.response.SizeResponse;
import com.lolmeida.mapper.SizeMapper;
import com.lolmeida.service.SizeService;

@Path("/size")
public class SizeResource implements ApiEndpoints {

    @Inject
    SizeService service;
    @Inject
    SizeMapper mapper;

    @Override
    public Response hello() {
        return null;
    }

    @Override
    public Response getAll() {
        List<SizeResponse> data = service.findAll("date, id")
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
        List<SizeResponse> data = service.search(field, value)
                                         .stream()
                                         .map(e -> mapper.objToResponse(e))
                                         .toList();
        return Response.ok(data).build();
    }

    @Override
    public Response findBy(
            @PathParam("id")
            final String id) {
        List<SizeResponse> data = service.findBy(id)
                                         .stream()
                                         .map(e -> mapper.objToResponse(e))
                                         .toList();
        return Response.ok(data).build();
    }

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(final Object request) {
        service.save(mapper.requestToObj((SizeRequest) request));
        return Response
                .ok(service.search("id", service.save(mapper.requestToObj((SizeRequest) request))))
                .build();
    }

}
