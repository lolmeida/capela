package com.lolmeida.api.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record PostalCodeResponse(
        String code,
        String address,

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
