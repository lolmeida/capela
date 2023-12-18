package com.lolmeida.resource;

import com.lolmeida.dto.request.CargoRequest;
import com.lolmeida.dto.response.CargoResponse;
import com.lolmeida.entity.database.Cargo;
import com.lolmeida.mapper.CargoMapper;
import com.lolmeida.service.CargoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/cargo")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CargoResource {

    @Inject
    @Channel("sms-notifications")
    Emitter<String> smsEmitter;

    @Inject
    CargoService service;
    @Inject
    CargoMapper mapper;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<CargoResponse> data = service.findAll("date, cargoNumber")
                .stream()
                .map(e ->mapper.objToResponse(e))
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
                .map(e ->mapper.objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")
    public Response findByCustomer(@PathParam("id") final String id) {
        List<CargoResponse> data = service.findBy(id)
                .stream()
                .map(e ->mapper.objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    //--------

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody CargoRequest request) {

        String cargo = service.save(mapper.requestToObj(request));
        smsEmitter.send(cargo);

        return Response
                .ok(service.search("id", service.save(mapper.requestToObj(request))))
                .build();
    }

}
