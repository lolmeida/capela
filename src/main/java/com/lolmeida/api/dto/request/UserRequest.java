package com.lolmeida.api.dto.request;

import lombok.Builder;

@Builder
public record UserRequest(
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
        String HojeMenosData
) {
}
