package com.lolmeida.dto.request;

import java.util.List;

import lombok.Builder;

/**
 * Represents a request for a receipt.
 */
@Builder
public record ReceiptRequest(
        double amount,
        double otherAmount,
        String client,
        List<String> cargoList
) {
}
