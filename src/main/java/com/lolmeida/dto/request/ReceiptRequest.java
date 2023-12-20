package com.lolmeida.dto.request;

import java.util.List;

import lombok.Builder;

/**
 * Represents a request for a receipt.
 */
@Builder
public record ReceiptRequest(
        /**
         * The amount of the receipt.
         */
        double amount,

        /**
         * The other amount of the receipt.
         */
        double otherAmount,

        /**
         * The client associated with the receipt.
         */
        String client,

        /**
         * The list of cargo associated with the receipt.
         */
        List<String> cargoList
) {
}
