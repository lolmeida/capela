package com.lolmeida.dto.request;


import lombok.Builder;


@Builder
public record ArmazemRequest(
        String name,
        String address,
        String phoneNumber
) {
}
