package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.ListRequest;
import com.lolmeida.dto.response.ListaResponse;
import com.lolmeida.entity.database.CargoSenderList;
import com.lolmeida.service.ListaService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/lista")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ListaResource {
    @Inject
    ListaService service;

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
                .map(e ->objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")
    public Response findByCustomer(@PathParam("id") final String id){
        List data = service.findBy(id)
                .stream()
                .map(e ->objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody ListRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("IdLista", service.save(requestToObj(request))))
                .build();
    }

    private CargoSenderList requestToObj (ListRequest request){
        return CargoSenderList.builder()
                .id(Utils.generateRandomString())
                .quantity(request.quantity())
                .numInvoiceArnaud(request.numInvoiceArnaud())
                .dateInvoiceArnaud(request.dateInvoiceArnaud())
                .valueInvoiceArnaud(request.valueInvoiceArnaud())
                .agent(request.agent())
                .arrivedDate(request.arrivedDate())
                .to(request.to())
                .build();
    }

    private ListaResponse objToResponse (CargoSenderList entity) {
        return ListaResponse.builder()
                .quantity(entity.getQuantity())
                .numInvoiceArnaud(entity.getNumInvoiceArnaud())
                .dateInvoiceArnaud(entity.getDateInvoiceArnaud())
                .valueInvoiceArnaud(entity.getValueInvoiceArnaud())
                .agent(entity.getAgent())
                .arrivedDate(entity.getArrivedDate())
                .to(entity.getTo())

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
