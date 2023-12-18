package com.lolmeida.dto.response;


import com.lolmeida.entity.database.Client;
import com.lolmeida.entity.database.Recipient;
import com.lolmeida.entity.database.Size;
import com.lolmeida.entity.database.User;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record CargoResponse(
        String cargoNumber,
        String client,
        String recipient,
        double total,
        String status,
        List<String> sizeList,


        // BaseEntity

        String user,
        String id,
        boolean active,
        String note,
        String description,
        String comments,
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
