/**
 * Represents a response object for a receipt.
 */
package com.lolmeida.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues.Descriptions;
import com.lolmeida.ApplicationValues.Examples;

@Builder
public record ReceiptResponse(
        @Schema(description = Descriptions.DOUBLE_VALUES,
                required = true,
                example = Examples.DOUBLE_VALUES)
        double amount,

        @Schema(description = Descriptions.DOUBLE_VALUES,
                required = true,
                example = Examples.DOUBLE_VALUES)
        double otherAmount,

        @Schema(description = Descriptions.ENTITY_ID,
                required = true,
                example = Examples.ENTITY_ID)
        String client,

        @Schema(description = Descriptions.ENTITY_ID,
                required = false,
                example = Examples.ID_LIST)
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
        LocalDateTime dateTime,
        String updatedBy,
        LocalDateTime updatedAt,
        Long updated
) {

}
