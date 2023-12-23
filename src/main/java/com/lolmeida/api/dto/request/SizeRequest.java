/**
 * Represents a request for size information.
 */
package com.lolmeida.api.dto.request;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues;
import com.lolmeida.ApplicationValues.Descriptions;

@Builder
public record SizeRequest(
        @Schema(
                description = Descriptions.NUMBERS,
                required = true,
                example = ApplicationValues.Examples.NUMBERS)
        int volume,

        @Schema(
                description = ApplicationValues.Descriptions.DOUBLE_VALUES,
                required = true,
                example = ApplicationValues.Examples.DOUBLE_VALUES)
        double length,

        @Schema(
                description = ApplicationValues.Descriptions.DOUBLE_VALUES,
                required = true,
                example = ApplicationValues.Examples.DOUBLE_VALUES)
        double height,

        @Schema(
                description = ApplicationValues.Descriptions.DOUBLE_VALUES,
                required = true,
                example = ApplicationValues.Examples.DOUBLE_VALUES)
        double width
) {

}
