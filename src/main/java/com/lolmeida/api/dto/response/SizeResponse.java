/**
 * Represents a response object containing size information.
 */
package com.lolmeida.api.dto.response;

import java.time.LocalDateTime;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues.Descriptions;
import com.lolmeida.ApplicationValues.Examples;


@Builder
public record SizeResponse(
        @Schema(
                description = Descriptions.NUMBERS,
                required = true,
                example = Examples.NUMBERS)
        int volume,

        @Schema(
                description = Descriptions.DOUBLE_VALUES,
                required = true,
                example = Examples.DOUBLE_VALUES)
        double length,

        @Schema(
                description = Descriptions.DOUBLE_VALUES,
                required = true,
                example = Examples.DOUBLE_VALUES)
        double height,

        @Schema(
                description = Descriptions.DOUBLE_VALUES,
                required = true,
                example = Examples.DOUBLE_VALUES)
        double width,
        String cargo,
        String user,
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
