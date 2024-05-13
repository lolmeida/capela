package com.lolmeida.api.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;

import com.lolmeida.api.entity.database.Cargo;

@Builder
public record SizeResponse(
        int volume,
        double length,
        double height,
        double width,
        Cargo cargo,

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
