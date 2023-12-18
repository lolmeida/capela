package com.lolmeida.dto.request;

import com.lolmeida.entity.database.Cargo;
import com.lolmeida.entity.database.Client;
import lombok.Builder;

import java.util.List;

@Builder
public record ReceiptRequest(


        double amount,

        double otherAmount,


        String client,
        List<String> cargoList
) {
}
