package com.lolmeida.dto.request;

import com.lolmeida.entity.database.Carga;
import com.lolmeida.entity.database.Dimensao;
import lombok.Builder;

@Builder
public record DimensaoRequest(
        int Vol,
        double Comprimento,
        double Altura,
        double Largura
) {
}
