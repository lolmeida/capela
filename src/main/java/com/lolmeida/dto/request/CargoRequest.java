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
        /**
         * The cargo number.
         */
        @Schema(description = "Cargo number", required = true, example = Examples.NUMBERS)
        String cargoNumber,
        /**
         * The client name.
         */
        @Schema(description = "Client name", required = true, example = Examples.ENTITY_ID)
        String client,
        /**
         * The recipient name.
         */
        @Schema(description = "Recipient name", required = true, example = Examples.ENTITY_ID)
        String recipient,
        /**
         * The total amount.
         */
        @Schema(description = "Total amount", required = true, example = Examples.DOUBLE_VALUES)
        double total,
        /**
         * The cargo status.
         */
        @Schema(description = "Cargo status", required = true)
        CargoStatus status,
        /**
         * The cargo size list.
         */
        @Schema(description = "Cargo size list", example = Examples.ID_LIST)
        List<String> sizeList
) {
}
