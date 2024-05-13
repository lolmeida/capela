package com.lolmeida.api.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record ListResponse(
        int quantity,
        String numInvoiceArnaud,
        LocalDateTime dateInvoiceArnaud,
        double valueInvoiceArnaud,
        String agent,
        LocalDateTime arrivedDate,
        String to,

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
