package com.lolmeida.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;

import com.lolmeida.api.entity.database.Cargo;
import com.lolmeida.api.entity.database.Receipt;

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
