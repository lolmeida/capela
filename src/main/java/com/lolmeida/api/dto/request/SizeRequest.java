package com.lolmeida.api.dto.request;

import lombok.Builder;

import com.lolmeida.api.entity.database.Cargo;

@Builder
public record SizeRequest(
        int volume,
        double length,
        double height,
        double width,
        String cargoId
) {

}
