package com.lolmeida.dto.request;

import com.lolmeida.entity.database.Carga;
import com.lolmeida.entity.database.Cliente;
import lombok.Builder;

@Builder
public record RecebimentoRequest(
        Carga Guia,
        String ValorPago,
        String Outros,
        Cliente Cliente
) {
}
