package com.lolmeida.dto.request;

public record AnuncioRequest(
        String Tipo,
        String Título,
        String Url,
        String idUrl
        ) {
}
