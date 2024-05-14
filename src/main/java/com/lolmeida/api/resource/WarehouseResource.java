package com.lolmeida.api.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.api.ResourceApi;
import com.lolmeida.api.dto.request.WarehouseRequest;
import com.lolmeida.api.dto.response.WarehouseResponse;
import com.lolmeida.api.entity.database.Warehouse;
import com.lolmeida.api.openapi.Values;
import com.lolmeida.api.service.WarehouseService;

@Path(Values.Paths.WAREHOUSE)
public class WarehouseResource implements ResourceApi<WarehouseRequest> {

    @Inject
    WarehouseService service;

    public Response getAll() {
        List<WarehouseResponse> data = service
                .findAll()
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
        List<WarehouseResponse> data = service
                .search(field, value)
                .stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    public Response findByCustomer(
            @PathParam("id")
            final String id) {
        List<WarehouseResponse> data = service
                .search("id", id)
                .stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    public Response save(
            @RequestBody WarehouseRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Warehouse requestToObj(WarehouseRequest request) {
        return Warehouse
                .builder()
                //.id(Utils.generateRandomString())
                .name(request.name())
                .address(request.address())
                .phoneNumber(request.phoneNumber())
                .build();
    }

    private WarehouseResponse objToResponse(Warehouse entity) {
        return WarehouseResponse
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .phoneNumber(entity.getPhoneNumber())
                .id(entity.getId())

                // BaseEntity

                .build();
    }
}
