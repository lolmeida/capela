package com.lolmeida.dto.response;

import com.lolmeida.entity.database.Carga;
import com.lolmeida.entity.database.Recebimento;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ClienteResponse(
        String Cliente,
        String Telefone,
        String Morada,
        String Tipo,
        String Email,
        List<Carga> cargas,
        List<Recebimento> recebimentos,

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
