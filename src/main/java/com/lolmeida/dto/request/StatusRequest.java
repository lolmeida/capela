package com.lolmeida.dto.request;

import lombok.Builder;

@Builder
public record StatusRequest(
        String status,
        int quantity,
        String formula,
        String type
) {
}
