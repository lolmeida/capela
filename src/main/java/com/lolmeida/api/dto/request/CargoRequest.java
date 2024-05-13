package com.lolmeida.api.dto.request;

import java.util.List;

public record CargoRequest(
        String cargoNumber,
        String clientId,
        String recipientId,
        double total,
        String status

        //String Foto,
        //String Nota,
        //String Utilizador,
        //String Descricao

) {

}
