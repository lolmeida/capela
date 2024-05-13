package com.lolmeida.api.resource;

import com.lolmeida.api.ApplicationPaths;
import com.lolmeida.api.dto.request.WarehouseRequest;
import com.lolmeida.api.dto.response.WarehouseResponse;
import com.lolmeida.api.entity.database.Warehouse;
import com.lolmeida.api.openapi.Values;
import com.lolmeida.api.service.WarehouseService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path(Values.Paths.WAREHOUSE)
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WarehouseResource {
    @Inject
    WarehouseService service;

    @GET
    @Path(ApplicationPaths.ROOT)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<WarehouseResponse> data = service.findAll()
                .stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path(ApplicationPaths.SEARCH)
    public Response search(
            @PathParam("field") final String field,
            @PathParam("value") final String value) {
        List<WarehouseResponse> data = service.search( field, value)
                .stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path(ApplicationPaths.FIND_BY)
    public Response findByCustomer(@PathParam("id") final String id){
        List<WarehouseResponse> data = service.findBy(id)
                .stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    @POST
    @Path(ApplicationPaths.ROOT)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody WarehouseRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Warehouse requestToObj(WarehouseRequest request) {
        return Warehouse.builder()
                //.id(Utils.generateRandomString())
                .name(request.name())
                .address(request.address())
                .phoneNumber(request.phoneNumber())
                .build();
    }

    private WarehouseResponse objToResponse (Warehouse entity) {
        return WarehouseResponse.builder()
                .name(entity.getName())
                .address(entity.getAddress())
                .phoneNumber(entity.getPhoneNumber())
                .id(entity.getId())

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
