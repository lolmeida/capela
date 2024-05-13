package com.lolmeida.resource;

import com.lolmeida.dto.request.CargoRequest;
import com.lolmeida.dto.response.CargoResponse;
import com.lolmeida.entity.database.Cargo;
import com.lolmeida.service.CargoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/carga")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CargoResource {
    @Inject
    CargoService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<CargoResponse> data = service.findAll("date, cargoNumber")
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
        List<CargoResponse> data = service.search(field, value)
                .stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")
    public Response findByCustomer(@PathParam("id") final String id) {
        List<CargoResponse> data = service.findBy(id)
                .stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    //--------

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody CargoRequest request) {


        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("cargoNumber", service.save(requestToObj(request))))
                .build();
    }


    private Cargo requestToObj(CargoRequest request) {

        return Cargo.builder()
                //.id(Utils.generateRandomString())
                .cargoNumber(request.cargoNumber())
                .client(request.client())
                .recipient(request.recipient())
                .total(request.total())
                .sizeList(request.sizeList())
                .status(request.status())
                .build();
    }

    private CargoResponse objToResponse (Cargo entity) {
        return CargoResponse.builder()
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
