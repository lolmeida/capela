package com.lolmeida.api.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.api.ResourceApi;
import com.lolmeida.api.dto.request.ConfigurationRequest;
import com.lolmeida.api.dto.response.ConfigurationResponse;
import com.lolmeida.api.entity.database.Configuration;
import com.lolmeida.api.openapi.Values;
import com.lolmeida.api.service.ConfigurationService;

@Path(Values.Paths.CONFIG)
public class ConfigurationResource implements ResourceApi<ConfigurationRequest> {

    @Inject
    ConfigurationService service;

    public Response getAll() {
        List<ConfigurationResponse> data = service.findAll()
                                                  .stream()
                                                  .map(this::objToResponse)
                                                  .toList();
        return Response.ok(data).build();
    }

    public Response search(
            @PathParam("field")
            final String field,
            @PathParam("value")
            final String value) {
        List<ConfigurationResponse> data = service.search(field, value)
                                                  .stream()
                                                  .map(this::objToResponse)
                                                  .toList();
        return Response.ok(data).build();
    }

    public Response findByCustomer(
            @PathParam("id")
            final String id) {
        List<ConfigurationResponse> data = service.search("id", id)
                                                  .stream()
                                                  .map(this::objToResponse)
                                                  .toList();
        return Response.ok(data).build();
    }

    public Response save(
            @RequestBody ConfigurationRequest request) {
        service.save(requestToObj(request));

        return Response
                .ok(service.search("id", service.save(requestToObj(request))))
                .build();
    }

    private Configuration requestToObj(ConfigurationRequest request) {
        return Configuration.builder()
                            //.id(Utils.generateRandomString())
                            .key(request.key())
                            .value(request.value())
                            .description(request.description())
                            .build();
    }

    private ConfigurationResponse objToResponse(Configuration entity) {
        return ConfigurationResponse.builder()
                                    .key(entity.getKey())
                                    .value(entity.getValue())
                                    .description(entity.getDescription())

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
