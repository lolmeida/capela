package com.lolmeida.dto.response;

import com.lolmeida.entity.database.Cargo;
import com.lolmeida.entity.database.Client;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReceiptResponse(
        Cargo cargo,
        double amount,
        double otherAmount,
        Client client,

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
