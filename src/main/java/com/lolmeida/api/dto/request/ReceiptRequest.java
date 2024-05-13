package com.lolmeida.api.dto.request;

import com.lolmeida.api.entity.database.Cargo;
import com.lolmeida.api.entity.database.Client;
import lombok.Builder;

@Builder
public record ReceiptRequest(
        Cargo cargo,
        double amount,
        double otherAmount,
        Client client
) {
}
