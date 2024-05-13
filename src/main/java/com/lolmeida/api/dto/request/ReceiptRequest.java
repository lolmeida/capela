package com.lolmeida.api.dto.request;

import lombok.Builder;

import com.lolmeida.api.entity.database.Cargo;
import com.lolmeida.api.entity.database.Client;

@Builder
public record ReceiptRequest(
        String cargoId,
        double amount,
        double otherAmount,
        String clientId
) {

}
