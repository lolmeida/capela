package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.CargaRequest;
import com.lolmeida.dto.response.ArmazemResponse;
import com.lolmeida.dto.response.CargaResponse;
import com.lolmeida.entity.database.Armazem;
import com.lolmeida.entity.database.Carga;
import com.lolmeida.service.CargaService;
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
public class CargaResource {
    @Inject
    CargaService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List data = service.findAll("Data, Guia")
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
        List data = service.search(field, value)
                .stream()
                .map(e ->objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/customer/{customerId}")
    public Response findByCustomer(@PathParam("customerId") final String customerId) {
        List data = service.findBy(customerId)
                .stream()
                .map(e ->objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    //--------

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody CargaRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("Guia", service.save(requestToObj(request))))
                .build();
    }


    private Carga requestToObj(CargaRequest request) {
        return Carga.builder()
                .IdRegisto(Utils.generateRandomString())
                .Cliente(request.Cliente())
                .Destinatario(request.Destinatario())
                .vReceber(request.vReceber())
                .IdDimensoes(request.IdDimensoes())
                .Status(request.Status())
                .Guia(Utils.generateRandomString())
                .build();
    }

    private CargaResponse objToResponse (Carga entity) {
        return CargaResponse.builder()
                .Cliente(entity.getCliente())
                .Destinatario(entity.getDestinatario())
                .vReceber(entity.getVReceber())
                //.Dimensoes(entity.getIdDimensoes())
                .Status(entity.getStatus())
                .Guia(entity.getGuia())

                // BaseEntity
                .Id(entity.getIdRegisto())
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
