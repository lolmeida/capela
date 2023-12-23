package com.lolmeida.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.api.ApiEndpoints;
import com.lolmeida.dto.request.ReceiptRequest;
import com.lolmeida.dto.response.ReceiptResponse;
import com.lolmeida.mapper.ReceiptMapper;
import com.lolmeida.service.ReceiptService;

@Path("/receipt")
public class ReceiptResource implements ApiEndpoints {

    @Inject
    ReceiptService service;
    @Inject
    ReceiptMapper mapper;

    @Override
    public Response hello() {
        return null;
    }

    @Override
    public Response getAll() {
        List<ReceiptResponse> data = service.findAll("date, id")
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
        List<ReceiptResponse> data = service.search(field, value)
                                            .stream()
                                            .map(e -> mapper.objToResponse(e))
                                            .toList();
        return Response.ok(data).build();
    }

    @Override
    public Response findBy(final String id) {
        List<ReceiptResponse> data = service.findBy(id)
                                            .stream()
                                            .map(e -> mapper.objToResponse(e))
                                            .toList();
        return Response.ok(data).build();
    }

    @Override
    public Response save(final Object request) {
        service.save(mapper.requestToObj((ReceiptRequest) request));
        return Response
                .ok(service.search("id", service.save(mapper.requestToObj((ReceiptRequest) request))))
                .build();
    }

}
