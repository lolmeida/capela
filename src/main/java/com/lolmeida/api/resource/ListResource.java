package com.lolmeida.api.resource;

import com.lolmeida.api.ApplicationPaths;
import com.lolmeida.api.dto.request.ListRequest;
import com.lolmeida.api.dto.response.ListResponse;
import com.lolmeida.api.entity.database.CargoSenderList;
import com.lolmeida.api.openapi.Values;
import com.lolmeida.api.service.ListService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path(Values.Paths.LIST)
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ListResource {
    @Inject
    ListService service;

    @GET
    @Path(ApplicationPaths.ROOT)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<ListResponse> data = service.findAll()
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
        List<ListResponse> data = service.search(field, value)
                                         .stream()
                                         .map(this::objToResponse)
                                         .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path(ApplicationPaths.FIND_BY)
    public Response findByCustomer(@PathParam("id") final String id){
        List<ListResponse> data = service.findBy(id)
                                         .stream()
                                         .map(this::objToResponse)
                                         .toList();
        return Response.ok(data).build();
    }

    @POST
    @Path(ApplicationPaths.ROOT)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody ListRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private CargoSenderList requestToObj (ListRequest request){
        return CargoSenderList.builder()
                //.id(Utils.generateRandomString())
                .quantity(request.quantity())
                .numInvoiceArnaud(request.numInvoiceArnaud())
                .dateInvoiceArnaud(request.dateInvoiceArnaud())
                .valueInvoiceArnaud(request.valueInvoiceArnaud())
                .agent(request.agent())
                .arrivedDate(request.arrivedDate())
                .to(request.to())
                .build();
    }

    private ListResponse objToResponse (CargoSenderList entity) {
        return ListResponse.builder()
                           .quantity(entity.getQuantity())
                           .numInvoiceArnaud(entity.getNumInvoiceArnaud())
                           .dateInvoiceArnaud(entity.getDateInvoiceArnaud())
                           .valueInvoiceArnaud(entity.getValueInvoiceArnaud())
                           .agent(entity.getAgent())
                           .arrivedDate(entity.getArrivedDate())
                           .to(entity.getTo())

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
