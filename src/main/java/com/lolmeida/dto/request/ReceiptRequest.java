package com.lolmeida.dto.request;

import java.util.List;

import lombok.Builder;

@Builder
public record ReceiptRequest(


        double amount,

        double otherAmount,


        String client,
        List<String> cargoList
) {
}
