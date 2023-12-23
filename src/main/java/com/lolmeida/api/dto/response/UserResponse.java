package com.lolmeida.api.dto.response;

import java.time.LocalDateTime;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues.Descriptions;
import com.lolmeida.ApplicationValues.Examples;

/**
 * Represents a response object for a user.
 */
@Builder
public record UserResponse(
        @Schema(
                description = Descriptions.EMAIL,
                required = true,
                example = Examples.EMAIL)
        String email,

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

        @Schema(description = Descriptions.SINGATURE)
        String signature,
        String privilege,
        String permission,

        // BaseEntity

        String id,
        boolean active,
        String note,
        String description,
        String attachment,
        String image,
        String createdBy,
        LocalDateTime createdAt,
        Long createdTime,
        String updatedBy,
        LocalDateTime updatedAt,
        Long updatedTime,
        LocalDateTime date

) {

}
