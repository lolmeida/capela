package com.lolmeida.api.dto.request;

import lombok.Builder;

@Builder
public record ReceiptRequest(
        String cargoId,
        double amount,
        double otherAmount,
        String clientId
) {

}
