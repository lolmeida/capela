package com.lolmeida.dto.request;

import com.lolmeida.entity.database.Client;
import com.lolmeida.entity.database.Recipient;
import com.lolmeida.entity.database.Size;

import java.util.List;

public record CargoRequest(
        String cargoNumber,
        String client,
        String recipient,
        double total,

        String status,

        List<String> sizeList


) {
}
