package com.lolmeida;

import jakarta.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import com.lolmeida.ApplicationPaths.Parameters;
import com.lolmeida.openapi.Values;














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
                        securitySchemes = {},
                        schemas = {},
                        parameters = {
                                @Parameter(
                                        name = Parameters.FIELD,
                                        description = "Field to search",
                                        required = true,
                                        in = ParameterIn.PATH,
                                        schema = @Schema(ref = Values.Schemas.FIELD )
                                ),
                                @Parameter(
                                        name = Parameters.VALUE,
                                        description = "Value to search",
                                        required = true,
                                        in = ParameterIn.PATH,
                                        schema = @Schema(ref = Values.Schemas.VALUE )
                                ),
                                @Parameter(
                                        name = Parameters.ID,
                                        description = "Id to search",
                                        required = true,
                                        in = ParameterIn.PATH,
                                        schema = @Schema(ref = Values.Schemas.ID )
                                )
                        }
                )
        
)

public class MainApplication extends Application {

}
