package com.lolmeida.api.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.api.ResourceApi;
import com.lolmeida.api.dto.request.CargoRequest;
import com.lolmeida.api.dto.response.CargoResponse;
import com.lolmeida.api.entity.database.Cargo;
import com.lolmeida.api.entity.database.Client;
import com.lolmeida.api.entity.database.Size;
import com.lolmeida.api.openapi.Values;
import com.lolmeida.api.service.CargoService;
import com.lolmeida.api.service.ClientService;

@Path(Values.Paths.CARGO)
public class CargoResource implements ResourceApi<CargoRequest> {

    @Inject
    CargoService service;
    @Inject
    ClientService clientService;

    public Response getAll() {
        List<CargoResponse> data = service.findAll("date, cargoNumber")
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
                .ok(service.search("cargoNumber", service.save(requestToObj(request))))
                .build();
    }


    private Cargo requestToObj(CargoRequest request) {

        return Cargo.builder()
                    .cargoNumber(request.cargoNumber())
                    .client(clientService.findBy(request.clientId()))
                    .recipient(clientService.findBy(request.recipientId()))
                    .total(request.total())
                    //.sizeList(List.of(new Size()))
                    .status(request.status())
                    .build();
    }

    private CargoResponse objToResponse(Cargo entity) {
        return CargoResponse.builder()
                            .id(entity.getId())
                            .client(entity.getClient())
                            .recipient(entity.getRecipient())
                            .total(entity.getTotal())
                            .sizeList(entity.getSizeList())
                            .status(entity.getStatus())
                            .cargoNumber(entity.getCargoNumber())

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
                            .receipt(entity.getReceipt())
                            .recipient(entity.getRecipient())

                            .build();
    }
}
