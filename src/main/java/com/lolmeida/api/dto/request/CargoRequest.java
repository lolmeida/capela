package com.lolmeida.api.dto.request;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues.Examples.Descriptions;
import com.lolmeida.ApplicationValues.Examples.Values;
import com.lolmeida.api.entity.CargoStatus;

/**
 * Represents a cargo request.
 */
@Builder
public record CargoRequest(
        @Schema(description = Descriptions.NUMBERS,
                required = true,
                example = Values.NUMBERS)
        String cargoNumber,
        @Schema(description = Descriptions.ENTITY_ID,
                required = true,
                example = Values.ENTITY_ID)
        String client,
        @Schema(description = Descriptions.ENTITY_ID,
                required = true,
                example = Values.ENTITY_ID)
        String recipient,
        @Schema(description = Descriptions.DOUBLE_VALUES,
                required = true,
                example = Values.DOUBLE_VALUES)
        double total,
        @Schema(description = Descriptions.CARGO_STATUS,
                required = true)
        CargoStatus status,
        @Schema(description = Descriptions.ID_LIST,
                example = Values.ID_LIST)
        List<String> sizeList
) {

}
