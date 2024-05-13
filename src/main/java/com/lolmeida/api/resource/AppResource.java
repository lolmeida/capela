package com.lolmeida.api.resource;

import com.lolmeida.api.dto.request.AppRequest;
import com.lolmeida.api.dto.response.AppResponse;
import com.lolmeida.api.entity.database.App;
import com.lolmeida.api.service.AppService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/app")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AppResource {
    @Inject
    AppService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<AppResponse> data = service.findAll()
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
        List<AppResponse> data = service.search( field, value)
                .stream()
                .map(this::objToResponse)
                .toList();
        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")
    public Response findByCustomer(@PathParam("id") final String id){
        List<AppResponse> data = service.findBy(id)
                .stream()
                .map(this::objToResponse)
                .toList();

        return Response.ok(data).build();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody AppRequest request) {
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

    private AppResponse objToResponse (App entity) {
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
