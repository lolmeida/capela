package com.lolmeida.api.dto.request;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues.Examples.Descriptions;
import com.lolmeida.ApplicationValues.Examples.Values;

/**
 * Represents a request for a receipt.
 */
@Builder
public record ReceiptRequest(
        @Schema(description = Descriptions.DOUBLE_VALUES,
                required = true,
                example = Values.DOUBLE_VALUES)
        double amount,

        @Schema(description = Descriptions.DOUBLE_VALUES,
                required = true,
                example = Values.DOUBLE_VALUES)
        double otherAmount,

        @Schema(description = Descriptions.ENTITY_ID,
                required = true,
                example = Values.ENTITY_ID)
        String client,

        @Schema(description = Descriptions.ENTITY_ID,
                required = false,
                example = Values.ID_LIST)
        List<String> cargoList
) {

}
