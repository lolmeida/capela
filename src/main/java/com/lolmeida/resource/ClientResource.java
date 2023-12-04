package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.ClienteRequest;
import com.lolmeida.dto.response.ClienteResponse;
import com.lolmeida.entity.database.Client;
import com.lolmeida.service.ClienteService;
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
    ClienteService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List data = service.findAll()
                .stream()
                .map(e ->objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/search/{field}/{value}")
    public Response search(
            @PathParam("field") final String field,
            @PathParam("value") final String value) {
        List data = service.search( field, value)
                .stream()
                .map(e -> objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")
    public Response findByCustomer(@PathParam("id") final String id){
        List data = service.findBy(id)
                .stream()
                .map(e -> objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    //--------

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody ClienteRequest request) {
        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Client requestToObj (ClienteRequest request){
        return Client.builder()
                .id(Utils.generateRandomString())
                .name(request.name())
                .phoneNumber(request.phoneNumber())
                .address(request.address())
                .type(request.type())
                .email(request.email())
                .build();
    }

    private ClienteResponse objToResponse (Client entity){
        return ClienteResponse.builder()
                .name(entity.getName())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .type(entity.getType())
                .email(entity.getEmail())

                .active(entity.isActive())
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
                .date(entity.getDate())

                .build();
    }
}
