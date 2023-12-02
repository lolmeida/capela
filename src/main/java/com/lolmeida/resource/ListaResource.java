package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.ListaRequest;
import com.lolmeida.dto.response.ConfiguracaoResponse;
import com.lolmeida.dto.response.DimensaoResponse;
import com.lolmeida.dto.response.ListaResponse;
import com.lolmeida.entity.database.Configuracao;
import com.lolmeida.entity.database.Lista;
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
    public Response save(@RequestBody ListaRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("IdLista", service.save(requestToObj(request))))
                .build();
    }

    private Lista requestToObj (ListaRequest request){
        return Lista.builder()
                .IdLista(Utils.generateRandomString())
                .Qtd(request.Qtd())
                .NumfaturaArnaud(request.NumfaturaArnaud())
                .DtFacturaArnaud(request.DtFacturaArnaud())
                .ValorFaturaArnaud(request.ValorFaturaArnaud())
                .Agente(request.Agente())
                .DataChegada(request.DataChegada())
                .Para(request.Para())
                .build();
    }

    private ListaResponse objToResponse (Lista entity) {
        return ListaResponse.builder()
                .Qtd(entity.getQtd())
                .NumfaturaArnaud(entity.getNumfaturaArnaud())
                .DtFacturaArnaud(entity.getDtFacturaArnaud())
                .ValorFaturaArnaud(entity.getValorFaturaArnaud())
                .Agente(entity.getAgente())
                .DataChegada(entity.getDataChegada())
                .Para(entity.getPara())

                // BaseEntity
                .Id(entity.getIdLista())
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
