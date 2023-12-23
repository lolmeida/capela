package com.lolmeida.api.resource;

import java.util.List;
import java.util.Optional;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import com.lolmeida.ApplicationPaths;
import com.lolmeida.ApplicationValues;
import com.lolmeida.api.ApiEndpoints;
import com.lolmeida.api.dto.request.ReceiptRequest;
import com.lolmeida.api.dto.response.ReceiptResponse;
import com.lolmeida.api.mapper.ReceiptMapper;
import com.lolmeida.api.service.ReceiptService;

@Path(ApplicationPaths.API_RECEIPT)
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
