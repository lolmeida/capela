package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.CodigoPostalRequest;
import com.lolmeida.dto.response.ArmazemResponse;
import com.lolmeida.dto.response.CodigoPostalResponse;
import com.lolmeida.entity.database.Armazem;
import com.lolmeida.entity.database.CodigoPostal;
import com.lolmeida.service.CodigoPostalService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/codigo-postal")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CodigoPostalResource {
    @Inject
    CodigoPostalService service;

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
    public Response save(@RequestBody CodigoPostalRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("IdCliente", service.save(requestToObj(request))))
                .build();
    }

    private CodigoPostal requestToObj(CodigoPostalRequest request) {
        return CodigoPostal.builder()
                .id(Utils.generateRandomString())
                .codigo(request.codigo())
                .Localidade(request.Localidade())
                .build();
    }

    private CodigoPostalResponse objToResponse (CodigoPostal entity) {
        return CodigoPostalResponse.builder()
                .Localidade(entity.getLocalidade())
                .Codigo(entity.getCodigo())

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
