package com.lolmeida.dto.request;

import lombok.Builder;

@Builder
public record ClienteRequest (
         String Cliente,
         String Telefone,
         String Morada,
         String Tipo,
         String Email
){
}
