package com.lolmeida.dto.response;

import com.lolmeida.entity.database.Carga;
import com.lolmeida.entity.database.Cliente;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record RecebimentoResponse(
        Carga Guia,
        String ValorPago,
        String Outros,
        Cliente Cliente,

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
