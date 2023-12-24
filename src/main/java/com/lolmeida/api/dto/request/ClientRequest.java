/**
 * Represents a client request. This class is used to transfer client data from the client to the server.
 */
package com.lolmeida.api.dto.request;

import jakarta.validation.constraints.Pattern;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues.Examples.Descriptions;
import com.lolmeida.ApplicationValues.Examples.Regex;
import com.lolmeida.ApplicationValues.Examples.Values;

@Builder
public record ClientRequest(
        @Schema(description = Descriptions.NAME,
                required = true,
                example = Values.NAME)
        String name,

        @Schema(description = Descriptions.PHONE_NUMBER,
                required = true,
                example = Values.PHONE_NUMBER)
        @Pattern(regexp = Regex.PHONE_NUMBER,
                 message = Regex.PHONE_NUMBER_ERROR_MSG)
        String phoneNumber,

        @Schema(description = Descriptions.ADDRESS,
                required = true,
                example = Values.ADDRESS)
        String address,

        String type,

        @Schema(description = Descriptions.EMAIL,
                required = true,
                example = Values.EMAIL)

        @Pattern(regexp = Regex.EMAIL,
                 message = Regex.EMAIL_ERROR_MSG)
        String email
) {

}
