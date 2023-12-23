package com.lolmeida.api.dto.request;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues;
import com.lolmeida.api.entity.CargoStatus;

/**
 * Represents a cargo request.
 */
@Builder
public record CargoRequest(
        @Schema(description = ApplicationValues.Descriptions.NUMBERS,
                required = true,
                example = ApplicationValues.Examples.NUMBERS)
        String cargoNumber,
        @Schema(description = ApplicationValues.Descriptions.ENTITY_ID,
                required = true,
                example = ApplicationValues.Examples.ENTITY_ID)
        String client,
        @Schema(description = ApplicationValues.Descriptions.ENTITY_ID,
                required = true,
                example = ApplicationValues.Examples.ENTITY_ID)
        String recipient,
        @Schema(description = ApplicationValues.Descriptions.DOUBLE_VALUES,
                required = true,
                example = ApplicationValues.Examples.DOUBLE_VALUES)
        double total,
        @Schema(description = ApplicationValues.Descriptions.CARGO_STATUS,
                required = true)
        CargoStatus status,
        @Schema(description = ApplicationValues.Descriptions.ID_LIST,
                example = ApplicationValues.Examples.ID_LIST)
        List<String> sizeList
) {

}
