package com.lolmeida.dto.request;

import com.lolmeida.entity.database.Cargo;
import com.lolmeida.entity.database.Receipt;
import lombok.Builder;

import java.util.List;

@Builder
public record ClienteRequest (
         String name,
         String phoneNumber,
         String address,
         String type,
         String email,
         List<Cargo> cargoList,
         List<Receipt> receiptList
){
}
