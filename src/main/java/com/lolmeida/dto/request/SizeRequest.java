/**
 * Represents a request for size information.
 */
package com.lolmeida.dto.request;

import lombok.Builder;

@Builder
public record SizeRequest(
        int volume,
        double length,
        double height,
        double width
) {
}
