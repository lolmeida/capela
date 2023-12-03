package com.lolmeida.dto.response;


import com.lolmeida.entity.database.Client;
import com.lolmeida.entity.database.Size;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record CargoResponse(
        String cargoNumber,
        Client client,
        Client recipient,
        double total,
        List<Size> sizeList,
        String status,


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
