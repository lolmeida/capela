/**
 * Represents a request for size information.
 */
package com.lolmeida.api.dto.request;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues.Examples.Descriptions;
import com.lolmeida.ApplicationValues.Examples.Values;

@Builder
public record SizeRequest(
        @Schema(
                description = Descriptions.NUMBERS,
                required = true,
                example = Values.NUMBERS)
        int volume,

        @Schema(
                description = Descriptions.DOUBLE_VALUES,
                required = true,
                example = Values.DOUBLE_VALUES)
        double length,

        @Schema(
                description = Descriptions.DOUBLE_VALUES,
                required = true,
                example = Values.DOUBLE_VALUES)
        double height,

        @Schema(
                description = Descriptions.DOUBLE_VALUES,
                required = true,
                example = Values.DOUBLE_VALUES)
        double width
) {

}
