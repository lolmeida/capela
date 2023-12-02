package com.lolmeida.dto.request;


import lombok.Builder;


@Builder
public record ArmazemRequest(
        String Armazem,
        String Morada,
        String Teletofe,
        boolean YN
) {
}
