package com.lolmeida.dto.request;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.entity.CargoStatus;
import com.lolmeida.openapi.Examples;

/**
 * Represents a cargo request.
 */
@Builder
public record CargoRequest(
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
        List<String> sizeList
) {
}
