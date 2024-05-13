package com.lolmeida.dto.request;

import lombok.Builder;

@Builder
public record PostalCodeRequest(
         String code,
         String address
) {
}
