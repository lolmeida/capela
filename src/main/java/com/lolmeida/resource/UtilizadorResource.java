package com.lolmeida.resource;

import com.lolmeida.dto.request.UtilizadorRequest;
import com.lolmeida.entity.database.Utilizador;
import com.lolmeida.service.UtilizadorService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/utilizador")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UtilizadorResource {
    @Inject
    UtilizadorService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List data = service.findAll().stream().toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/search/{field}/{value}")
    public Response search(
            @PathParam("field") final String field,
            @PathParam("value") final String value) {
        List data = service.search( field, value);
        return Response.ok(data).build();
    }

    @GET
    @Path("/customer/{customerId}")
    public Response findByCustomer(@PathParam("customerId") final String id){
        List data = service.findBy(id);
        return Response.ok(data).build();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody UtilizadorRequest request) {
        service.save(requestToObj(request));
        return Response.ok(request).build();
    }

    private Utilizador requestToObj (UtilizadorRequest request){
        return Utilizador.builder()
                .Mail(request.Mail())
                .Nome(request.Nome())
                .Telefone(request.Telefone())
                .Morada(request.Morada())
                .Assinatura(request.Assinatura())
                .Previlegio(request.Previlegio())
                .Perfil(request.Perfil())
                .Clientes(request.Clientes())
                .Recebimentos(request.Recebimentos())
                .Cargas(request.Cargas())
                .DiasEdicaoDocumento(request.DiasEdicaoDocumento())
                .PrazoAnularEstadoDias(request.PrazoAnularEstadoDias())
                .DiasEliminarDocumento(request.DiasEliminarDocumento())
                .QtdMaxFactDivida(request.QtdMaxFactDivida())
                .DiasMaxFactDivida(request.DiasMaxFactDivida())
                .HojeMenosData(request.HojeMenosData())
                .build();
    }
}
