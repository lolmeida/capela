package com.lolmeida.api.dto.request;

import lombok.Builder;

@Builder
public record ConfigurationRequest(
        String key,
         String value,
         String description
) {
}
