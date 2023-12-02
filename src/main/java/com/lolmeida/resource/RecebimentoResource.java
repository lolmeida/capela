package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.RecebimentoRequest;
import com.lolmeida.dto.response.ConfiguracaoResponse;
import com.lolmeida.dto.response.RecebimentoResponse;
import com.lolmeida.entity.database.Configuracao;
import com.lolmeida.entity.database.Recebimento;
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
public class RecebimentoResource {
    @Inject
    RecebimentoService service;

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
    public Response save(@RequestBody RecebimentoRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("Chave", service.save(requestToObj(request))))
                .build();
    }

    private Recebimento requestToObj (RecebimentoRequest request){
        return Recebimento.builder()
                .Chave(Utils.generateRandomString())
                .Guia(request.Guia())
                .ValorPago(request.ValorPago())
                .Outros(request.Outros())
                .Cliente(request.Cliente())

                .build();
    }

    private RecebimentoResponse objToResponse (Recebimento entity) {
        return RecebimentoResponse.builder()
                .Guia(entity.getGuia())
                .ValorPago(entity.getValorPago())
                .Outros(entity.getOutros())
                .Cliente(entity.getCliente())

                // BaseEntity
                .Id(entity.getChave())
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
