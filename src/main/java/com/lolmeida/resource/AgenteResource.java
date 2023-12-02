package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.AgenteRequest;
import com.lolmeida.dto.response.AgenteResponse;
import com.lolmeida.dto.response.ClienteResponse;
import com.lolmeida.entity.database.Agente;
import com.lolmeida.entity.database.Cliente;
import com.lolmeida.service.AgenteService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/agente")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgenteResource  {
    @Inject
    AgenteService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List data = service.findAll().stream()
                .map(e ->objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/search/{field}/{value}")
    public Response search(
            @PathParam("field") final String field,
            @PathParam("value") final String value) {
        List data = service.search( field, value).stream()
                .map(e ->objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/customer/{customerId}")

    public Response findByCustomer(@PathParam("customerId") final String customerId){
        List data = service.findBy(customerId).stream()
                .map(e ->objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody AgenteRequest request) {
        service.save(requestToObj(request));

        return Response
                .ok(service.search("Id", service.save(requestToObj(request))))
                .build();
    }

    private Agente requestToObj(AgenteRequest request) {
        return Agente.builder()
                .Id(Utils.generateRandomString())
                .Nome(request.Nome())
                .Email(request.Email())
                .Contacto(request.Contacto())
                .build();
    }

    private AgenteResponse objToResponse (Agente entity){
        return AgenteResponse.builder()
                .Nome(entity.getNome())
                .Email(entity.getEmail())
                .Contacto(entity.getContacto())

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
