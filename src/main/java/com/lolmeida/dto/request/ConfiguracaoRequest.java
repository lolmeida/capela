package com.lolmeida.dto.request;

import lombok.Builder;

@Builder
public record ConfiguracaoRequest(
        String Parametro,
         String Texto,
         String Valor
) {
}
