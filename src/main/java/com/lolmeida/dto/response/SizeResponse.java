package com.lolmeida.dto.response;

import com.lolmeida.entity.database.Cargo;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SizeResponse(
        int volume,
        double length,
        double height,
        double width,
        String cargoNumber,



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
