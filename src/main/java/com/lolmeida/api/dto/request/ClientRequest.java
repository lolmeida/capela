/**
 * Represents a client request. This class is used to transfer client data from the client to the server.
 */
package com.lolmeida.api.dto.request;

import jakarta.validation.constraints.Pattern;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues;

@Builder
public record ClientRequest(
        @Schema(description = ApplicationValues.Descriptions.NAME,
                required = true,
                example = ApplicationValues.Examples.NAME)
        String name,

        @Schema(description = ApplicationValues.Descriptions.PHONE_NUMBER,
                required = true,
                example = ApplicationValues.Examples.PHONE_NUMBER)
        @Pattern(regexp = ApplicationValues.Regex.PHONE_NUMBER,
                 message = ApplicationValues.Regex.PHONE_NUMBER_ERROR_MSG)
        String phoneNumber,

        @Schema(description = ApplicationValues.Descriptions.ADDRESS,
                required = true,
                example = ApplicationValues.Examples.ADDRESS)
        String address,

        String type,

        @Schema(description = ApplicationValues.Descriptions.EMAIL,
                required = true,
                example = ApplicationValues.Examples.EMAIL)

        @Pattern(regexp = ApplicationValues.Regex.EMAIL,
                 message = ApplicationValues.Regex.EMAIL_ERROR_MSG)
        String email
) {

}
