package com.lolmeida;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import com.lolmeida.ApplicationPaths.Parameters.Refs;
import com.lolmeida.ApplicationPaths.RequestBodies;
import com.lolmeida.api.dto.request.CargoRequest;
import com.lolmeida.api.dto.request.ClientRequest;
import com.lolmeida.api.dto.request.ReceiptRequest;
import com.lolmeida.api.dto.request.RecipientRequest;
import com.lolmeida.api.dto.request.SizeRequest;
import com.lolmeida.api.dto.request.UserRequest;
import com.lolmeida.api.openapi.Values;

@OpenAPIDefinition(
        info = @Info(
                title = ApplicationValues.API_TITLE,
                version = ApplicationValues.API_VERSION,
                contact = @Contact(
                        name = ApplicationValues.API_CONTACT_NAME,
                        email = ApplicationValues.API_CONTACT_EMAIL,
                        url = ApplicationValues.API_CONTACT_URL
                )

        ),
        components = @Components(
                //securitySchemes = {},

                parameters = {
                        @Parameter(
                                name = Refs.FIELD,
                                description = "Field to search",
                                required = true,
                                in = ParameterIn.PATH,
                                schema = @Schema(ref = Values.Schemas.FIELD)
                        ),
                        @Parameter(
                                name = Refs.VALUE,
                                description = "Value to search",
                                required = true,
                                in = ParameterIn.PATH,
                                schema = @Schema(ref = Values.Schemas.VALUE)
                        ),
                        @Parameter(
                                name = Refs.ID,
                                description = "Id to search",
                                required = true,
                                in = ParameterIn.PATH,
                                schema = @Schema(ref = Values.Schemas.ID)
                        )
                },
                requestBodies = {
                        @RequestBody(
                                name = RequestBodies.REQUEST_BODY,
                                required = true,
                                description = "Cargo request body",
                                content = @Content(
                                        mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(implementation = CargoRequest.class)
                                )),
                        @RequestBody(
                                name = RequestBodies.CLIENT,
                                required = true,
                                description = "Client request body",
                                content = @Content(
                                        mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(implementation = ClientRequest.class)
                                )),
                        @RequestBody(
                                name = RequestBodies.RECEIPT,
                                required = true,
                                description = "Receipt request body",
                                content = @Content(
                                        mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(implementation = ReceiptRequest.class)
                                )),
                        @RequestBody(
                                name = RequestBodies.RECIPTENT,
                                required = true,
                                description = "Recipient request body",
                                content = @Content(
                                        mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(implementation = RecipientRequest.class)
                                )),
                        @RequestBody(
                                name = RequestBodies.SIZE,
                                required = true,
                                description = "Size request body",
                                content = @Content(
                                        mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(implementation = SizeRequest.class)
                                )),
                        @RequestBody(
                                name = RequestBodies.USER,
                                required = true,
                                description = "User request body",
                                content = @Content(
                                        mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(implementation = UserRequest.class)
                                ))
                },
                responses = {
                        @APIResponse(
                                name = Values.Responses.CARGO,
                                description = Values.Responses.Descriptions.CARGO,
                                content = @Content(
                                        mediaType = MediaType.APPLICATION_JSON,
                                        schema = @Schema(type = SchemaType.STRING)
                                )
                        )
                }

        )

)

public class MainApplication extends Application {

}
