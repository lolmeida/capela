package com.lolmeida.api;


import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.lolmeida.ApplicationPaths;
import com.lolmeida.ApplicationPaths.Parameters;
import com.lolmeida.ApplicationValues;
import com.lolmeida.dto.request.CargoRequest;
import com.lolmeida.openapi.Values;

@Path(ApplicationPaths.API_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Api",
     description = ApplicationValues.API_DESCRIPTION)
public interface ApiEndpoints {

    @GET
    @Path(ApplicationPaths.API_HELLO_PATH)
    @Consumes({
            ApplicationPaths.MediaTypeExtension.TAR,
            ApplicationPaths.MediaTypeExtension.PNG,
            ApplicationPaths.MediaTypeExtension.JPEG,
            ApplicationPaths.MediaTypeExtension.GIF,
            ApplicationPaths.MediaTypeExtension.MP4,
            ApplicationPaths.MediaTypeExtension.MP3,
            ApplicationPaths.MediaTypeExtension.ZIP,
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML
    })
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Hello World")
    @APIResponse(responseCode = "200",
                 description = "It works")
    @APIResponse(ref = Values.Responses.Error.UNAUTHORIZED)
    @APIResponse(ref = Values.Responses.Error.FORBIDDEN)
    @APIResponse(ref = Values.Responses.Error.NOT_FOUND)
    @APIResponse(ref = Values.Responses.Error.INTERNAL_SERVER_ERROR)
    @APIResponse(ref = Values.Responses.Error.BAD_GATEWAY)
    public Response hello();


    @GET
    @Path("/")
    @Consumes({
            ApplicationPaths.MediaTypeExtension.TAR,
            ApplicationPaths.MediaTypeExtension.PNG,
            ApplicationPaths.MediaTypeExtension.JPEG,
            ApplicationPaths.MediaTypeExtension.GIF,
            ApplicationPaths.MediaTypeExtension.MP4,
            ApplicationPaths.MediaTypeExtension.MP3,
            ApplicationPaths.MediaTypeExtension.ZIP,
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML
    })
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Get All Records")
    @APIResponse(responseCode = Values.Codes.OK,
                 description = "Get All Records sorted descending by date and ...")
    @APIResponse(ref = Values.Responses.Error.UNAUTHORIZED)
    @APIResponse(ref = Values.Responses.Error.FORBIDDEN)
    @APIResponse(ref = Values.Responses.Error.NOT_FOUND)
    @APIResponse(ref = Values.Responses.Error.INTERNAL_SERVER_ERROR)
    @APIResponse(ref = Values.Responses.Error.BAD_GATEWAY)
    public Response getAll();

    @GET
    @Path("/search/{field}/{value}")
    @Consumes({
            ApplicationPaths.MediaTypeExtension.TAR,
            ApplicationPaths.MediaTypeExtension.PNG,
            ApplicationPaths.MediaTypeExtension.JPEG,
            ApplicationPaths.MediaTypeExtension.GIF,
            ApplicationPaths.MediaTypeExtension.MP4,
            ApplicationPaths.MediaTypeExtension.MP3,
            ApplicationPaths.MediaTypeExtension.ZIP,
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML
    })
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Search records")
    @APIResponse(responseCode = "200",
                 description = "Search records by field and value")
    @APIResponse(ref = Values.Responses.Error.UNAUTHORIZED)
    @APIResponse(ref = Values.Responses.Error.FORBIDDEN)
    @APIResponse(ref = Values.Responses.Error.NOT_FOUND)
    @APIResponse(ref = Values.Responses.Error.INTERNAL_SERVER_ERROR)
    @APIResponse(ref = Values.Responses.Error.BAD_GATEWAY)
    public Response search(
            @HeaderParam(ApplicationPaths.Headers.FIELD)
            @Parameter(ref = Parameters.FIELD,
                       description = "Field to search")
            final String field,

            @HeaderParam(ApplicationPaths.Headers.VALUE)
            @Parameter(ref = ApplicationPaths.Parameters.VALUE,
                       description = "Value to search")
            final String value);


    @GET
    @Path("/{id}")
    @Consumes({
            ApplicationPaths.MediaTypeExtension.TAR,
            ApplicationPaths.MediaTypeExtension.PNG,
            ApplicationPaths.MediaTypeExtension.JPEG,
            ApplicationPaths.MediaTypeExtension.GIF,
            ApplicationPaths.MediaTypeExtension.MP4,
            ApplicationPaths.MediaTypeExtension.MP3,
            ApplicationPaths.MediaTypeExtension.ZIP,
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML
    })
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Find by ID")
    @APIResponse(responseCode = Values.Codes.OK,
                 description = "Find record by ID")
    @APIResponse(ref = Values.Responses.Error.UNAUTHORIZED)
    @APIResponse(ref = Values.Responses.Error.FORBIDDEN)
    @APIResponse(ref = Values.Responses.Error.NOT_FOUND)
    @APIResponse(ref = Values.Responses.Error.INTERNAL_SERVER_ERROR)
    @APIResponse(ref = Values.Responses.Error.BAD_GATEWAY)
    public Response findBy(
            @HeaderParam(ApplicationPaths.Headers.ID)
            @Parameter(ref = Parameters.ID,
                       description = "Cargo ID")
            final String id
    );


    @POST
    @Path("/")
    @Consumes({
            ApplicationPaths.MediaTypeExtension.TAR,
            ApplicationPaths.MediaTypeExtension.PNG,
            ApplicationPaths.MediaTypeExtension.JPEG,
            ApplicationPaths.MediaTypeExtension.GIF,
            ApplicationPaths.MediaTypeExtension.MP4,
            ApplicationPaths.MediaTypeExtension.MP3,
            ApplicationPaths.MediaTypeExtension.ZIP,
            MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML
    })
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "New record")
    @APIResponse(responseCode = Values.Codes.CREATED,
                 description = "Add new record to database")
    @APIResponse(ref = Values.Responses.Error.UNAUTHORIZED)
    @APIResponse(ref = Values.Responses.Error.FORBIDDEN)
    @APIResponse(ref = Values.Responses.Error.NOT_FOUND)
    @APIResponse(ref = Values.Responses.Error.INTERNAL_SERVER_ERROR)
    @APIResponse(ref = Values.Responses.Error.BAD_GATEWAY)
    public Response save(
            @Valid
            @RequestBody(ref = ApplicationPaths.RequestBodies.REQUEST_BODY, description = "Cargo Request")
            final CargoRequest requestBody
    );


}