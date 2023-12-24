/**
 * Represents a user request.
 */
package com.lolmeida.api.dto.request;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues.Examples.Descriptions;
import com.lolmeida.ApplicationValues.Examples.Values;

@Builder
public record UserRequest(
        @Schema(
                description = Descriptions.EMAIL,
                required = true,
                example = Values.EMAIL)
        String email,

        @Schema(
                description = Descriptions.NAME,
                required = true,
                example = Values.NAME)
        String name,

        @Schema(
                description = Descriptions.PHONE_NUMBER,
                required = true,
                example = Values.PHONE_NUMBER)
        String phoneNumber,

        @Schema(
                description = Descriptions.ADDRESS,
                required = true,
                example = Values.ADDRESS)
        String address,

        @Schema(description = Descriptions.SINGATURE)
        String signature) {

}
