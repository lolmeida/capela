package com.lolmeida.api.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.api.ResourceApi;
import com.lolmeida.api.dto.request.AgentRequest;
import com.lolmeida.api.dto.response.AgentResponse;
import com.lolmeida.api.entity.database.Agent;
import com.lolmeida.api.openapi.Values;
import com.lolmeida.api.service.AgentService;

@Path(Values.Paths.AGENT)
public class AgentResource implements ResourceApi<AgentRequest> {

    @Inject
    AgentService service;

    public Response getAll() {
        List<AgentResponse> data = service.findAll().stream()
                                          .map(this::objToResponse)
                                          .toList();
        return Response.ok(data).build();
    }

    public Response search(
            @PathParam("field")
            final String field,
            @PathParam("value")
            final String value) {
        List<AgentResponse> data = service.search(field, value).stream()
                                          .map(this::objToResponse)
                                          .toList();
        return Response.ok(data).build();
    }

    public Response findByCustomer(
            @PathParam("id")
            final String id) {
        List<AgentResponse> data = service.search("id", id)
                                          .stream()
                                          .map(this::objToResponse)
                                          .toList();
        return Response.ok(data).build();
    }

    public Response save(
            @RequestBody AgentRequest request) {
        service.save(requestToObj(request));

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Agent requestToObj(AgentRequest request) {
        return Agent.builder()
                    .name(request.name())
                    .email(request.email())
                    .contact(request.contact())
                    .build();
    }

    private AgentResponse objToResponse(Agent entity) {
        return AgentResponse.builder()
                            .id(entity.getId())
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
