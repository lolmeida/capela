package com.lolmeida.api;


import jakarta.enterprise.context.RequestScoped;
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
import com.lolmeida.ApplicationPaths.Parameters.Refs;
import com.lolmeida.ApplicationValues;
import com.lolmeida.openapi.Values;
import com.lolmeida.openapi.Values.Responses.Descriptions;
import com.lolmeida.openapi.Values.Responses.Summary;

@Path(ApplicationPaths.API_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = ApplicationValues.API_NAME, description = ApplicationValues.API_DESCRIPTION)
@RequestScoped
public interface  ApiEndpoints<R> {

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
    @Operation(summary = "Hello World")
    @APIResponse(responseCode = Values.Codes.OK,
                 description = "It works")
    @APIResponse(ref = Values.Responses.Error.UNAUTHORIZED)
    @APIResponse(ref = Values.Responses.Error.FORBIDDEN)
    @APIResponse(ref = Values.Responses.Error.NOT_FOUND)
    @APIResponse(ref = Values.Responses.Error.INTERNAL_SERVER_ERROR)
    @APIResponse(ref = Values.Responses.Error.BAD_GATEWAY)
    Response hello();


    @GET
    @Path(ApplicationPaths.API_ROOT)
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

    @Operation(summary = Summary.LIST)
    @APIResponse(responseCode = Values.Codes.OK,
                 description = Values.Responses.Descriptions.LIST)
    @APIResponse(ref = Values.Responses.Error.UNAUTHORIZED)
    @APIResponse(ref = Values.Responses.Error.FORBIDDEN)
    @APIResponse(ref = Values.Responses.Error.NOT_FOUND)
    @APIResponse(ref = Values.Responses.Error.INTERNAL_SERVER_ERROR)
    @APIResponse(ref = Values.Responses.Error.BAD_GATEWAY)
    Response getAll();

    @GET
    @Path(ApplicationPaths.API_SEARCH)
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

    @Operation(summary = Summary.SEARCH)
    @APIResponse(responseCode = Values.Codes.OK,
                 description = Descriptions.SEARCH)
    @APIResponse(ref = Values.Responses.Error.UNAUTHORIZED)
    @APIResponse(ref = Values.Responses.Error.FORBIDDEN)
    @APIResponse(ref = Values.Responses.Error.NOT_FOUND)
    @APIResponse(ref = Values.Responses.Error.INTERNAL_SERVER_ERROR)
    @APIResponse(ref = Values.Responses.Error.BAD_GATEWAY)
    Response search(
            @HeaderParam(ApplicationPaths.Headers.FIELD)
            @Parameter(ref = Refs.FIELD,
                       description = Parameters.Descriptions.FIELD)
            final String field,

            @HeaderParam(ApplicationPaths.Headers.VALUE)
            @Parameter(ref = Refs.VALUE,
                       description = Parameters.Descriptions.VALUE)
            final String value);


    @GET
    @Path(ApplicationPaths.API_ID)
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

    @Operation(summary = Summary.FIND)
    @APIResponse(responseCode = Values.Codes.OK,
                 description = Descriptions.FIND)
    @APIResponse(ref = Values.Responses.Error.UNAUTHORIZED)
    @APIResponse(ref = Values.Responses.Error.FORBIDDEN)
    @APIResponse(ref = Values.Responses.Error.NOT_FOUND)
    @APIResponse(ref = Values.Responses.Error.INTERNAL_SERVER_ERROR)
    @APIResponse(ref = Values.Responses.Error.BAD_GATEWAY)
    Response findBy(
            @HeaderParam(ApplicationPaths.Headers.ID)
            @Parameter(ref = Refs.ID,
                       description = Parameters.Descriptions.ID)
            final String id
    );


    @POST
    @Path(ApplicationPaths.API_ROOT)
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

    @Operation(summary = Summary.ADD)
    @APIResponse(responseCode = Values.Codes.CREATED,
                 description = Descriptions.ADD)
    @APIResponse(ref = Values.Responses.Error.UNAUTHORIZED)
    @APIResponse(ref = Values.Responses.Error.FORBIDDEN)
    @APIResponse(ref = Values.Responses.Error.NOT_FOUND)
    @APIResponse(ref = Values.Responses.Error.INTERNAL_SERVER_ERROR)
    @APIResponse(ref = Values.Responses.Error.BAD_GATEWAY)
    Response save(
            @Valid
            @RequestBody(ref = ApplicationPaths.RequestBodies.REQUEST_BODY, description = "Request body")
            final R requestBody
    );


}