package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.RecebimentoRequest;
import com.lolmeida.dto.response.ReceiptResponse;
import com.lolmeida.entity.database.Receipt;
import com.lolmeida.service.RecebimentoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/recebimento")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReceiptResource {
    @Inject
    RecebimentoService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<ReceiptResponse> data = service.findAll("date, cargo")
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
        List<ReceiptResponse> data = service.search( field, value)
                .stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")
    public Response findByCustomer(@PathParam("id") final String id){
        List<ReceiptResponse> data = service.findBy(id)
                .stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody RecebimentoRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Receipt requestToObj (RecebimentoRequest request){
        return Receipt.builder()
                .id(Utils.generateRandomString())
                .cargo(request.cargo())
                .amount(request.amount())
                .otherAmount(request.otherAmount())
                .client(request.client())

                .build();
    }

    private ReceiptResponse objToResponse (Receipt entity) {
        return ReceiptResponse.builder()
                .cargo(entity.getCargo())
                .amount(entity.getAmount())
                .otherAmount(entity.getOtherAmount())
                .client(entity.getClient())

                // BaseEntity
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
