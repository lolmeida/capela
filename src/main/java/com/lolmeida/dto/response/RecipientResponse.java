package com.lolmeida.dto.response;

import com.lolmeida.entity.database.Cargo;
import com.lolmeida.entity.database.User;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record RecipientResponse(
        String name,
        String phoneNumber,
        String address,
        String type,
        String email,
        List<String> cargoList,


        String user,



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