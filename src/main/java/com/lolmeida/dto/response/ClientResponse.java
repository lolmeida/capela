package com.lolmeida.dto.response;

import com.lolmeida.entity.database.Cargo;
import com.lolmeida.entity.database.Receipt;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ClientResponse(
        String name,
        String phoneNumber,
        String address,
        String type,
        String email,
        List<Cargo> cargoList,
        List<Receipt> receiptList,




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
