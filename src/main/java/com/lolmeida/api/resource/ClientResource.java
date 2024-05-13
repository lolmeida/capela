package com.lolmeida.api.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.api.ResourceApi;
import com.lolmeida.api.dto.request.ClientRequest;
import com.lolmeida.api.dto.response.ClientResponse;
import com.lolmeida.api.entity.database.Client;
import com.lolmeida.api.openapi.Values.Paths;
import com.lolmeida.api.service.ClientService;

@Path(Paths.CUSTOMER)
public class ClientResource implements ResourceApi<ClientRequest> {

    @Inject
    ClientService service;

    public Response getAll() {
        List<ClientResponse> data = service.findAll()
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
        List<ClientResponse> data = service.search(field, value)
                                           .stream()
                                           .map(this::objToResponse)
                                           .toList();
        return Response.ok(data).build();
    }

    public Response findByCustomer(
            @PathParam("id")
            final String id) {
        List<ClientResponse> data = service.search("id", id)
                                           .stream()
                                           .map(this::objToResponse)
                                           .toList();
        return Response.ok(data).build();
    }

    public Response save(
            @RequestBody ClientRequest request) {
        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Client requestToObj(ClientRequest request) {
        return Client.builder()
                     //.id(Utils.generateRandomString())
                     .name(request.name())
                     .phoneNumber(request.phoneNumber())
                     .address(request.address())
                     .type(request.type())
                     .email(request.email())
                     .build();
    }

    private ClientResponse objToResponse(Client entity) {
        return ClientResponse.builder()
                             .name(entity.getName())
                             .phoneNumber(entity.getPhoneNumber())
                             .address(entity.getAddress())
                             .type(entity.getType())
                             .email(entity.getEmail())
                             .cargoList(entity.getCargoList())
                             .receiptList(entity.getReceiptList())

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
                             .cargoList(entity.getCargoList())
                             .receiptList(entity.getReceiptList())

                             .build();
    }
}
