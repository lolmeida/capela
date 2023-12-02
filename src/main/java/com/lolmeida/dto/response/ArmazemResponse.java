package com.lolmeida.dto.response;


import lombok.Builder;

import java.time.LocalDateTime;


@Builder
public record ArmazemResponse(
        String Armazem,
        String Morada,
        String Teletofe,
        boolean YN,

        // BaseEntity
        String Id,
        String UserEmail,
        String ModificadoPor,
        boolean Activo,
        String Nota,
        String Anexo,
        String Utilizador,
        String Foto,
        String Descricao,
        Long createdTime,
        Long updatedTime,
        LocalDateTime Data,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
