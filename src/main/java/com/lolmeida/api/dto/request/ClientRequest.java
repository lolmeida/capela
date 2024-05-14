package com.lolmeida.api.dto.request;

import lombok.Builder;

@Builder
public record ClientRequest(
        String name,
        String phoneNumber,
        String address,
        String type,
        String email
) {

}
