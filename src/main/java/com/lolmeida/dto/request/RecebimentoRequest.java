package com.lolmeida.dto.request;

import com.lolmeida.entity.database.Cargo;
import com.lolmeida.entity.database.Client;
import lombok.Builder;

@Builder
public record RecebimentoRequest(
        Cargo cargo,
        double amount,
        double otherAmount,
        Client client
) {
}
