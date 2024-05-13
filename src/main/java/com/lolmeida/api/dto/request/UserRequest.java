package com.lolmeida.api.dto.request;

import lombok.Builder;

@Builder
public record UserRequest(
        String Mail,
        String Nome,
        String Telefone,
        String Morada
) {

}
