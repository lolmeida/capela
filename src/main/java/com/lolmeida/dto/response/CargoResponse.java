package com.lolmeida.dto.response;


import com.lolmeida.entity.database.Client;
import com.lolmeida.entity.database.Receipt;
import com.lolmeida.entity.database.Size;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Builder
public record CargoResponse(
        String cargoNumber,
        String client,
        String recipient,
        double total,
        List<String> sizeList,
        String status,
        String receipt,


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
