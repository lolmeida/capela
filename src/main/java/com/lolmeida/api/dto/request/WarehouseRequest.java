package com.lolmeida.api.dto.request;


import lombok.Builder;


@Builder
public record WarehouseRequest(
        String name,
        String address,
        String phoneNumber
) {

}
