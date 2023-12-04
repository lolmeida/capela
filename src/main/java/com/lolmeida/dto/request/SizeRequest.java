package com.lolmeida.dto.request;

import com.lolmeida.entity.database.Cargo;
import lombok.Builder;

@Builder
public record SizeRequest(
        int volume,
        double length,
        double height,
        double width,
        String cargoNumber
) {
}
