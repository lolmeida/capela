package com.lolmeida.api.dto.request;

import com.lolmeida.api.entity.database.Receipt;
import com.lolmeida.api.entity.database.Cargo;

import lombok.Builder;

import java.util.List;

@Builder
public record ClientRequest(
         String name,
         String phoneNumber,
         String address,
         String type,
         String email,
         List<Cargo> cargoList,
         List<Receipt> receiptList
){
}
