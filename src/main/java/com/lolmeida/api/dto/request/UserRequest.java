/**
 * Represents a user request.
 */
package com.lolmeida.api.dto.request;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues;

@Builder
public record UserRequest(
        @Schema(
                description = ApplicationValues.Descriptions.EMAIL,
                required = true,
                example = ApplicationValues.Examples.EMAIL)
        String email,

        @Schema(
                description = ApplicationValues.Descriptions.NAME,
                required = true,
                example = ApplicationValues.Examples.NAME)
        String name,

        @Schema(
                description = ApplicationValues.Descriptions.PHONE_NUMBER,
                required = true,
                example = ApplicationValues.Examples.PHONE_NUMBER)
        String phoneNumber,

        @Schema(
                description = ApplicationValues.Descriptions.ADDRESS,
                required = true,
                example = ApplicationValues.Examples.ADDRESS)
        String address,

        @Schema(description = "The user's signature")
        String signature) {

}
