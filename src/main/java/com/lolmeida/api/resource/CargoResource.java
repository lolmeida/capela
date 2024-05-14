package com.lolmeida.api.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.api.AppConfig.Schema.Table;
import com.lolmeida.api.ResourceApi;
import com.lolmeida.api.Utils;
import com.lolmeida.api.dto.request.CargoRequest;
import com.lolmeida.api.dto.response.CargoResponse;
import com.lolmeida.api.entity.database.Cargo;
import com.lolmeida.api.openapi.Values;
import com.lolmeida.api.service.CargoService;
import com.lolmeida.api.service.ClientService;
import com.lolmeida.api.service.SizeService;

@Path(Values.Paths.CARGO)
public class CargoResource implements ResourceApi<CargoRequest> {

    @Inject
    CargoService service;
    @Inject
    ClientService clientService;
    @Inject
    SizeService sizeService;

    public Response getAll() {
        List<CargoResponse> data = service.findAll(Table.Cargo.OrderByColumns)
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
        List<CargoResponse> data = service.search(field, value)
                                          .stream()
                                          .map(this::objToResponse)
                                          .toList();
        return Response.ok(data).build();
    }

    public Response findByCustomer(
            @PathParam("id")
            final String id) {
        List<CargoResponse> data = service.search("id", id)
                                          .stream()
                                          .map(this::objToResponse)
                                          .toList();
        return Response.ok(data).build();
    }

    public Response save(
            @RequestBody
            CargoRequest request

    ) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search(Table.Cargo.SearchId, service.save(requestToObj(request))))
                .build();
    }


    private Cargo requestToObj(CargoRequest request) {

        return Cargo.builder()
                    .cargoNumber(request.cargoNumber())
                    .client(clientService.findBy(request.clientId()))
                    .recipient(clientService.findBy(request.recipientId()))
                    .total(request.total())
                    .status(request.status())
                    .build();
    }

    private CargoResponse objToResponse(Cargo entity) {
        return Utils.entityToResponse(entity)
                .toBuilder()
                .id(entity.getId())
                .client(entity.getClient())
                .recipient(entity.getRecipient())
                .total(entity.getTotal())
                .sizeList(sizeService.search("cargoId", entity.getId()))
                .status(entity.getStatus())
                .cargoNumber(entity.getCargoNumber())
                .build();
    }
}
