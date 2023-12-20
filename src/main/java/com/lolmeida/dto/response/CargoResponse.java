package com.lolmeida.dto.response;


import java.time.LocalDateTime;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lolmeida.entity.CargoStatus;
import com.lolmeida.openapi.Examples;

@Builder
public record CargoResponse(

        @Schema(description = "Cargo number", required = true, example = Examples.NUMBERS)
        String cargoNumber,
        @Schema(description = "Client name", required = true, example = Examples.ENTITY_ID)
        String client,
        @Schema(description = "Recipient name", required = true, example = Examples.ENTITY_ID)
        String recipient,
        @Schema(description = "Total amount", required = true, example = Examples.DOUBLE_VALUES)
        double total,

        @Schema(description = "Cargo status", required = true)
        CargoStatus status,

        @Schema(description = "Cargo size list", example = Examples.ID_LIST)
        List<String> sizeList,


        // BaseEntity

        String user,
        String id,

        @JsonIgnore
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
