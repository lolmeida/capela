package com.lolmeida.dto.request;

import com.lolmeida.entity.database.Cargo;
import com.lolmeida.entity.database.Client;
import lombok.Builder;

@Builder
public record RecebimentoRequest(
        String cargo,
        double amount,
        double otherAmount,
        String client
) {
}
