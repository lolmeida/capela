package com.lolmeida.api.dto.request;

import lombok.Builder;

@Builder
public record PostalCodeRequest(
        String code,
        String address
) {

}
