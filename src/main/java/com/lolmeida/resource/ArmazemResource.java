package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.ArmazemRequest;
import com.lolmeida.dto.response.AppResponse;
import com.lolmeida.dto.response.ArmazemResponse;
import com.lolmeida.entity.database.App;
import com.lolmeida.entity.database.Armazem;
import com.lolmeida.service.ArmazemService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/armazem")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArmazemResource {
    @Inject
    ArmazemService service;

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
    @Path("/customer/{customerId}")
    public Response findByCustomer(@PathParam("customerId") final String customerId){
        List data = service.findBy(customerId)
                .stream()
                .map(e ->objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody ArmazemRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("Id", service.save(requestToObj(request))))
                .build();
    }

    private Armazem requestToObj(ArmazemRequest request) {
        return Armazem.builder()
                .id(Utils.generateRandomString())
                .Armazem(request.Armazem())
                .Morada(request.Morada())
                .Teletofe(request.Teletofe())
                .YN(request.YN())
                .build();
    }

    private ArmazemResponse objToResponse (Armazem entity) {
        return ArmazemResponse.builder()
                .Armazem(entity.getArmazem())
                .Morada(entity.getMorada())
                .Teletofe(entity.getTeletofe())
                .YN(entity.isYN())

                // BaseEntity
                .Id(entity.getId())
                .Activo(entity.isActivo())
                .Nota(entity.getNota())
                .Anexo(entity.getAnexo())
                .Utilizador(entity.getUtilizador())
                .Foto(entity.getFoto())
                .Descricao(entity.getDescricao())
                .createdTime(entity.getCreatedTime())
                .updatedTime(entity.getUpdatedTime())
                .Data(entity.getData())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())

                .build();
    }
}
