package com.lolmeida.dto.request;

import lombok.Builder;

@Builder
public record UserRequest(

        String email,
        String name,
        String phoneNumber,
        String address,
        String signature){
}
