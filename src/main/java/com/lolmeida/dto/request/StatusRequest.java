package com.lolmeida.dto.request;

import lombok.Builder;

@Builder
public record StatusRequest(
        String Status,
        int Qtd,
        String Formula,
        String Tipo
) {
}
