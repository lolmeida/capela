package com.lolmeida.api.dto.request;

import lombok.Builder;

import com.lolmeida.api.entity.database.Cargo;
import com.lolmeida.api.entity.database.Client;

@Builder
public record ReceiptRequest(
        Cargo cargo,
        double amount,
        double otherAmount,
        Client client
) {

}
