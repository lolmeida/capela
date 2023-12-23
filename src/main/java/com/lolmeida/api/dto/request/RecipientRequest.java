/**
 * Represents a request object for a recipient.
 */
package com.lolmeida.api.dto.request;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues.Descriptions;
import com.lolmeida.ApplicationValues.Examples;

@Builder
public record RecipientRequest(
        @Schema(
                description = Descriptions.NAME,
                required = true,
                example = Examples.NAME)

        String name,

        @Schema(
                description = Descriptions.PHONE_NUMBER,
                required = true,
                example = Examples.PHONE_NUMBER)
        String phoneNumber,

        @Schema(
                description = Descriptions.ADDRESS,
                required = true,
                example = Examples.ADDRESS)
        String address,

        @Schema(
                description = "The type of the recipient",
                required = true,
                example = "CLIENT")
        String type,

        @Schema(
                description = Descriptions.EMAIL,
                required = true,
                example = Examples.EMAIL)
        String email
) {

}
