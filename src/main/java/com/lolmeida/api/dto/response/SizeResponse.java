/**
 * Represents a response object containing size information.
 */
package com.lolmeida.api.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;


@Builder
public record SizeResponse(
        int volume,
        double length,
        double height,
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