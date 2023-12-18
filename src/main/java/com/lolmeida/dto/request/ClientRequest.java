package com.lolmeida.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
public record ClientRequest(
         String name,

         @Pattern(regexp = "^\\+351\\d{9}$", message = "Invalid phone number")
         String phoneNumber,
         String address,
         String type,

         @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Invalid email address")
         String email
){
}
