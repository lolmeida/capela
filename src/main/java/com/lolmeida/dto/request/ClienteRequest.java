package com.lolmeida.dto.request;

import lombok.Builder;

@Builder
public record ClienteRequest (
         String name,
         String phoneNumber,
         String address,
         String type,
         String email
){
}
