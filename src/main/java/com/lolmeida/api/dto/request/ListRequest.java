package com.lolmeida.api.dto.request;

import java.time.LocalDateTime;

import lombok.Builder;

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
