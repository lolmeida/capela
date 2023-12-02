package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.DimensaoRequest;
import com.lolmeida.dto.response.ConfiguracaoResponse;
import com.lolmeida.dto.response.DimensaoResponse;
import com.lolmeida.entity.database.Configuracao;
import com.lolmeida.entity.database.Dimensao;
import com.lolmeida.service.DimensaoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/dimensao")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DimensaoResource {
    @Inject
    DimensaoService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List data = service.findAll("Comprimento")
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

    //--------

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody DimensaoRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("IdDimensoes", service.save(requestToObj(request))))
                .build();
    }

    private Dimensao requestToObj (DimensaoRequest request){
        return Dimensao.builder()
                .IdDimensoes(Utils.generateRandomString())
                .Altura(request.Altura())
                .Comprimento(request.Comprimento())
                .Largura(request.Largura())
                .Vol(request.Vol())
                .build();
    }

    private DimensaoResponse objToResponse (Dimensao entity) {
        return DimensaoResponse.builder()
                .Altura(entity.getAltura())
                .Comprimento(entity.getComprimento())
                .Largura(entity.getLargura())
                .Vol(entity.getVol())

                // BaseEntity
                .Id(entity.getIdDimensoes())
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
