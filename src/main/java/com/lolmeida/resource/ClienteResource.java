package com.lolmeida.resource;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.ClienteRequest;
import com.lolmeida.dto.response.ClienteResponse;
import com.lolmeida.entity.database.Cliente;
import com.lolmeida.service.ClienteService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.time.LocalDateTime;
import java.util.List;

@Path("/cliente")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {
    @Inject
    ClienteService service;

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
                .map(e -> objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/customer/{customerId}")
    public Response findByCustomer(@PathParam("customerId") final String customerId){
        List data = service.findBy(customerId)
                .stream()
                .map(e -> objToResponse(e))
                .toList();
        return Response.ok(data).build();
    }

    //--------

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody ClienteRequest request) {
        return Response
                .ok(service.search("IdCliente", service.save(requestToObj(request))))
                .build();
    }

    private Cliente requestToObj (ClienteRequest request){
        return Cliente.builder()
                .IdCliente(Utils.generateRandomString())
                .Cliente(request.Cliente())
                .Telefone(request.Telefone())
                .Morada(request.Morada())
                .Tipo(request.Tipo())
                .Email(request.Email())
                .build();
    }

    private ClienteResponse objToResponse (Cliente entity){
        return ClienteResponse.builder()
                .Cliente(entity.getCliente())
                .Telefone(entity.getTelefone())
                .Morada(entity.getMorada())
                .Tipo(entity.getTipo())
                .Email(entity.getEmail())


                .Id(entity.getIdCliente())
                .UserEmail(entity.getUserEmail())
                .ModificadoPor(entity.getModificadoPor())
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
                .cargas(entity.getCargas())
                .recebimentos(entity.getRecebimentos())
                .build();
    }
}
