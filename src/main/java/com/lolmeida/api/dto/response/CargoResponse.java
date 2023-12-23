/**
 * Represents a response object for a cargo. This class contains information about the cargo, such as cargo number, client name,
 * recipient name, total amount, cargo status, and cargo size list. It also inherits properties from the BaseEntity class, such as
 * user, id, active, note, description, comments, attachment, image, createdBy, createdAt, createdTime, updatedBy, updatedAt,
 * updatedTime, and date.
 */
package com.lolmeida.api.dto.response;


import java.time.LocalDateTime;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lolmeida.ApplicationValues.Descriptions;
import com.lolmeida.api.entity.CargoStatus;
import com.lolmeida.ApplicationValues.Examples;

@Builder
public record CargoResponse(

        @Schema(description = Descriptions.NUMBERS,
                required = true,
                example = Examples.NUMBERS)
        String cargoNumber,
        @Schema(description = Descriptions.ENTITY_ID,
                required = true,
                example = Examples.ENTITY_ID)
        String client,
        @Schema(description = Descriptions.ENTITY_ID,
                required = true,
                example = Examples.ENTITY_ID)
        String recipient,
        @Schema(description = Descriptions.DOUBLE_VALUES,
                required = true,
                example = Examples.DOUBLE_VALUES)
        double total,

        @Schema(description = Descriptions.CARGO_STATUS,
                example = Examples.CARGO_STATUS,
                required = true)
        CargoStatus status,

        @Schema(description = Descriptions.ID_LIST,
                example = Examples.ID_LIST)
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
