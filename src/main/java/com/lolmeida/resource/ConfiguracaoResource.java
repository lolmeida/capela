package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.ConfiguracaoRequest;
import com.lolmeida.dto.response.CodigoPostalResponse;
import com.lolmeida.dto.response.ConfiguracaoResponse;
import com.lolmeida.entity.database.CodigoPostal;
import com.lolmeida.entity.database.Configuracao;
import com.lolmeida.service.ConfiguracaoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/configuracao")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConfiguracaoResource {
    @Inject
    ConfiguracaoService service;

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
    public Response save(@RequestBody ConfiguracaoRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("IdCliente", service.save(requestToObj(request))))
                .build();
    }

    private Configuracao requestToObj(ConfiguracaoRequest request) {
        return Configuracao.builder()
                .id(Utils.generateRandomString())
                .Parametro(request.Parametro())
                .Valor(request.Valor())
                .Texto(request.Texto())
                .build();
    }

    private ConfiguracaoResponse objToResponse (Configuracao entity) {
        return ConfiguracaoResponse.builder()
                .Parametro(entity.getParametro())
                .Valor(entity.getValor())
                .Texto(entity.getTexto())

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
