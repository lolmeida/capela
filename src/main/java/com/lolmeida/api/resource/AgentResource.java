package com.lolmeida.api.resource;

import com.lolmeida.api.ApplicationPaths;
import com.lolmeida.api.dto.request.AgentRequest;
import com.lolmeida.api.dto.response.AgentResponse;
import com.lolmeida.api.entity.database.Agent;
import com.lolmeida.api.service.AgentService;
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
public class AgentResource {
    @Inject
    AgentService service;

    @GET
    @Path(ApplicationPaths.ROOT)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<AgentResponse> data = service.findAll().stream()
                                          .map(this::objToResponse)
                                          .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path(ApplicationPaths.SEARCH)
    public Response search(
            @PathParam("field") final String field,
            @PathParam("value") final String value) {
        List<AgentResponse> data = service.search(field, value).stream()
                                          .map(this::objToResponse)
                                          .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path(ApplicationPaths.FIND_BY)

    public Response findByCustomer(@PathParam("id") final String id){
        List<AgentResponse> data = service.findBy(id).stream()
                                          .map(this::objToResponse)
                                          .toList();
        return Response.ok(data).build();
    }

    @POST
    @Path(ApplicationPaths.ROOT)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody AgentRequest request) {
        service.save(requestToObj(request));

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Agent requestToObj(AgentRequest request) {
        return Agent.builder()
                //id(Utils.generateRandomString())
                    .name(request.name())
                    .email(request.email())
                    .contact(request.contact())
                    .build();
    }

    private AgentResponse objToResponse (Agent entity){
        return AgentResponse.builder()
                            .name(entity.getName())
                            .email(entity.getEmail())
                            .contact(entity.getContact())

                            // BaseEntity
                            /*.active(entity.isActive())
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
