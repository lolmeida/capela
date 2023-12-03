package com.lolmeida.dto.request;

import lombok.Builder;

@Builder
public record CodigoPostalRequest(
         String code,
         String address
) {
}
