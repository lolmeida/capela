package com.lolmeida.dto.request;

import com.lolmeida.entity.database.Cargo;
import jakarta.persistence.Column;
import lombok.Builder;

@Builder
public record SizeRequest(
        int volume,
        double length,
        double height,
        double width
) {
}
