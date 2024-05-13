package com.lolmeida.api.dto.request;

import com.lolmeida.api.entity.database.Cargo;
import lombok.Builder;

@Builder
public record SizeRequest(
        int volume,
        double length,
        double height,
        double width,
        Cargo cargo
) {
}
