package com.lolmeida.dto.request;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ListRequest(
        int quantity,
        String numInvoiceArnaud,
        LocalDateTime dateInvoiceArnaud,
        double valueInvoiceArnaud,
        String agent,
        LocalDateTime arrivedDate,
        String to
) {
}
