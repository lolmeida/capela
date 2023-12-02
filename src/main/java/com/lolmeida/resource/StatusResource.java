package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.StatusRequest;
import com.lolmeida.dto.response.ConfiguracaoResponse;
import com.lolmeida.dto.response.StatusResponse;
import com.lolmeida.entity.database.Configuracao;
import com.lolmeida.entity.database.Status;
import com.lolmeida.service.StatusService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/status")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StatusResource {
    @Inject
    StatusService service;

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
    public Response save(@RequestBody StatusRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("IdCliente", service.save(requestToObj(request))))
                .build();
    }

    private Status requestToObj (StatusRequest request){
        return Status.builder()
                .id(Utils.generateRandomString())
                .Status(request.Status())
                .Qtd(request.Qtd())
                .Formula(request.Formula())
                .Tipo(request.Tipo())
                .build();
    }

    private StatusResponse objToResponse (Status entity) {
        return StatusResponse.builder()
                .Status(entity.getStatus())
                .Qtd(entity.getQtd())
                .Formula(entity.getFormula())
                .Tipo(entity.getTipo())

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
