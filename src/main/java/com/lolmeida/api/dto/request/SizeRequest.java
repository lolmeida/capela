/**
 * Represents a request for size information.
 */
package com.lolmeida.api.dto.request;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues.Descriptions;
import com.lolmeida.ApplicationValues.Examples;

@Builder
public record SizeRequest(
        @Schema(
                description = Descriptions.NUMBERS,
                required = true,
                example = Examples.NUMBERS)
        int volume,

        @Schema(
                description = Descriptions.DOUBLE_VALUES,
                required = true,
                example = Examples.DOUBLE_VALUES)
        double length,

        @Schema(
                description = Descriptions.DOUBLE_VALUES,
                required = true,
                example = Examples.DOUBLE_VALUES)
        double height,

        @Schema(
                description = Descriptions.DOUBLE_VALUES,
                required = true,
                example = Examples.DOUBLE_VALUES)
        double width
) {

}
