package com.lolmeida.dto.request;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ListaRequest(
        int Qtd,
        String NumfaturaArnaud,
        LocalDateTime DtFacturaArnaud,
        double ValorFaturaArnaud,
        String Agente,
        LocalDateTime DataChegada,
        String Para
) {
}
