/**
 * Represents a response object for a cargo.
 * This class contains information about the cargo, such as cargo number, client name, recipient name, total amount, cargo status, and cargo size list.
 * It also inherits properties from the BaseEntity class, such as user, id, active, note, description, comments, attachment, image, createdBy, createdAt, createdTime, updatedBy, updatedAt, updatedTime, and date.
 */
package com.lolmeida.api.dto.response;


import java.time.LocalDateTime;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lolmeida.api.entity.CargoStatus;
import com.lolmeida.api.openapi.Examples;

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