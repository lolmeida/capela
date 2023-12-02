package com.lolmeida.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record AppResponse(
         String appName,
         String appLogo,

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
