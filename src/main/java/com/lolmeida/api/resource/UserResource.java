package com.lolmeida.api.resource;

import com.lolmeida.api.dto.request.UserRequest;
import com.lolmeida.api.dto.response.UserResponse;
import com.lolmeida.api.entity.database.Utilizador;
import com.lolmeida.api.service.UserService;
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
public class UserResource {
    @Inject
    UserService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<UserResponse> data = service.findAll()
                                         .stream()
                                         .map(this::objToResponse)
                                         .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/search/{field}/{value}")
    public Response search(
            @PathParam("field") final String field,
            @PathParam("value") final String value) {
        List<UserResponse> data = service.search(field, value)
                                         .stream()
                                         .map(this::objToResponse)
                                         .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")
    public Response findByCustomer(@PathParam("id") final String id){
        List<UserResponse> data = service.findBy(id)
                                         .stream()
                                         .map(this::objToResponse)
                                         .toList();
        return Response.ok(data).build();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody UserRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("mail", service.save(requestToObj(request))))
                .build();
    }

    private Utilizador requestToObj (UserRequest request){
        return Utilizador.builder()
                //.id(Utils.generateRandomString())
                .mail(request.Mail())
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

    private UserResponse objToResponse (Utilizador entity) {
        return UserResponse.builder()
                           .Mail(entity.getMail())
                           .Nome(entity.getNome())
                           .Telefone(entity.getTelefone())
                           .Morada(entity.getMorada())
                           .Assinatura(entity.getAssinatura())
                           .Previlegio(entity.getPrevilegio())
                           .Perfil(entity.getPerfil())
                           .Clientes(entity.getClientes())
                           .Recebimentos(entity.getRecebimentos())
                           .Cargas(entity.getCargas())
                           .DiasEdicaoDocumento(entity.getDiasEdicaoDocumento())
                           .PrazoAnularEstadoDias(entity.getPrazoAnularEstadoDias())
                           .DiasEliminarDocumento(entity.getDiasEliminarDocumento())
                           .QtdMaxFactDivida(entity.getQtdMaxFactDivida())
                           .DiasMaxFactDivida(entity.getDiasMaxFactDivida())
                           .HojeMenosData(entity.getHojeMenosData())

                           // BaseEntity
                           /*.id(entity.getId())
                .active(entity.isActive())
                .note(entity.getNote())
                .description(entity.getDescription())
                .attachment(entity.getAttachment())
                .image(entity.getImage())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .createdTime(entity.getCreatedTime())
                .updatedBy(entity.getUpdatedBy())
                .updatedTime(entity.getUpdatedTime())
                .updatedAt(entity.getUpdatedAt())
                .date(entity.getDate())*/

                           .build();
    }
}
