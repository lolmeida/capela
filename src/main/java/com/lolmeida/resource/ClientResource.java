package com.lolmeida.resource;

import com.lolmeida.dto.request.ClientRequest;
import com.lolmeida.dto.response.ClientResponse;
import com.lolmeida.entity.database.Client;
import com.lolmeida.service.ClientService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/cliente")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientResource {
    @Inject
    ClientService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<ClientResponse> data = service.findAll()
                                           .stream()
                                           .map(this::objToResponse)
                                           .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/search/{field}/{value}")
    public Response search(
            @PathParam("field") final String field,
            @PathParam("value") final String value) {
        List<ClientResponse> data = service.search(field, value)
                                           .stream()
                                           .map(this::objToResponse)
                                           .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")
    public Response findByCustomer(@PathParam("id") final String id){
        List<ClientResponse> data = service.findBy(id)
                                           .stream()
                                           .map(this::objToResponse)
                                           .toList();
        return Response.ok(data).build();
    }

    //--------

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody ClientRequest request) {
        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Client requestToObj (ClientRequest request){
        return Client.builder()
                //.id(Utils.generateRandomString())
                .name(request.name())
                .phoneNumber(request.phoneNumber())
                .address(request.address())
                .type(request.type())
                .email(request.email())
                .build();
    }

    private ClientResponse objToResponse (Client entity){
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
