package com.lolmeida.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UtilizadorResponse(
        String Mail,
        String Nome,
        String Telefone,
        String Morada,
        String Assinatura,
        String Previlegio,
        String Perfil,
        String Clientes,
        String Recebimentos,
        String Cargas,
        String DiasEdicaoDocumento,
        String PrazoAnularEstadoDias,
        String DiasEliminarDocumento,
        String QtdMaxFactDivida,
        String DiasMaxFactDivida,
        String HojeMenosData,

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
