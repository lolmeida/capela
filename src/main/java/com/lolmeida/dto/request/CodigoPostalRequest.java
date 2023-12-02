package com.lolmeida.dto.request;

import lombok.Builder;

@Builder
public record CodigoPostalRequest(
         String codigo,
         String Localidade
) {
}
