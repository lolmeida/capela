package com.lolmeida.resource;

import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import com.lolmeida.api.ApiEndpoints;
import com.lolmeida.dto.request.CargoRequest;
import com.lolmeida.dto.response.CargoResponse;
import com.lolmeida.mapper.CargoMapper;
import com.lolmeida.service.CargoService;

@Path("/cargo")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CargoResource implements ApiEndpoints {

    @Inject
    CargoService service;
    @Inject
    CargoMapper mapper;


    @Override
    public Response hello() {
        return Response.ok("Hello World | it works").build();
    }

    @Override
    public Response getAll() {

        List<CargoResponse> data = service.findAll("date, cargoNumber")
                                          .stream()
                                          .map(e -> mapper.objToResponse(e))
                                          .toList();
        return Response.ok(
                Optional.of(data).orElseThrow(() -> new RuntimeException("No data found"))
        ).build();
    }

    @Override
    public Response search(final String field, final String value) {
        List<CargoResponse> data = service.search(field, value)
                                          .stream()
                                          .map(e -> mapper.objToResponse(e))
                                          .toList();
        return Response.ok(
                Optional.of(data).orElseThrow(() -> new RuntimeException("No data found"))
        ).build();
    }

    @Override
    public Response findBy(final String id) {
        List<CargoResponse> data = service.findBy(id)
                                          .stream()
                                          .map(e -> mapper.objToResponse(e))
                                          .toList();
        return Response.ok(
                Optional.of(data).orElseThrow(() -> new RuntimeException("No data found"))
        ).build();
    }


    @Override
    public Response save(final CargoRequest request) {
        service.save(mapper.requestToObj(request));

        return Response
                .ok(service.search("id", service.save(mapper.requestToObj(request))))
                .build();
    }


}
