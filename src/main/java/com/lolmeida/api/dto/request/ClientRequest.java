package com.lolmeida.api.dto.request;

import java.util.List;

import lombok.Builder;

import com.lolmeida.api.entity.database.Cargo;
import com.lolmeida.api.entity.database.Receipt;

@Builder
public record ClientRequest(
        String name,
        String phoneNumber,
        String address,
        String type,
        String email,
        List<Cargo> cargoList,
        List<Receipt> receiptList
) {

}
