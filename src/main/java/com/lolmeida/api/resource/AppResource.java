package com.lolmeida.api.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.lolmeida.api.ResourceApi;
import com.lolmeida.api.dto.request.AppRequest;
import com.lolmeida.api.dto.response.AppResponse;
import com.lolmeida.api.entity.database.App;
import com.lolmeida.api.openapi.Values;
import com.lolmeida.api.service.AppService;

@Path(Values.Paths.APP)
public class AppResource implements ResourceApi<AppRequest> {

    @Inject
    AppService service;

    public Response getAll() {
        List<AppResponse> data = service.findAll()
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
        List<AppResponse> data = service.search(field, value)
                                        .stream()
                                        .map(this::objToResponse)
                                        .toList();
        return Response.ok(data).build();
    }

    public Response findByCustomer(
            @PathParam("id")
            final String id) {
        List<AppResponse> data = service.search("id", id)
                                        .stream()
                                        .map(this::objToResponse)
                                        .toList();

        return Response.ok(data).build();
    }

    public Response save(
            @RequestBody AppRequest request) {
        service.save(requestToObj(request));
        //return Response.ok(request).build();

        return Response
                .ok(service.search("appName", service.save(requestToObj(request))))
                .build();
    }

    private App requestToObj(AppRequest request) {
        return App.builder()
                  //.id(Utils.generateRandomString())
                  .appLogo(request.appLogo())
                  .appName(request.appName())
                  .build();
    }

    private AppResponse objToResponse(App entity) {
        return AppResponse.builder()
                          .appLogo(entity.getAppLogo())
                          .appName(entity.getAppName())

                          // BaseEntity
//                .active(entity.isActive())
//                .note(entity.getNote())
//                .description(entity.getDescription())
//                .attachment(entity.getAttachment())
//                .image(entity.getImage())
//                .createdBy(entity.getCreatedBy())
//                .createdAt(entity.getCreatedAt())
//                .createdTime(entity.getCreatedTime())
//                .updatedBy(entity.getUpdatedBy())
//                .updatedTime(entity.getUpdatedTime())
//                .updatedAt(entity.getUpdatedAt())
//                .date(entity.getDate())

                          .build();
    }
}
