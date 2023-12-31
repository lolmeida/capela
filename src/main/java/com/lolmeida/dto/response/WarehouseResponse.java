package com.lolmeida.dto.response;


import lombok.Builder;

import java.time.LocalDateTime;


@Builder
public record WarehouseResponse(
        String name,
        String address,
        String phoneNumber,


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
