package com.lolmeida.mapper;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.ReceiptRequest;
import com.lolmeida.dto.response.ReceiptResponse;
import com.lolmeida.entity.database.Receipt;
import jakarta.enterprise.context.Dependent;

@Dependent
public class ReceiptMapper {
    public Receipt requestToObj(ReceiptRequest request) {
        return Receipt.builder()
                .id(Utils.generateRandomString())
                .otherAmount(request.otherAmount())
                .amount(request.amount())
                .client(request.client())
                .cargoList(request.cargoList())
                .user(Utils.getCurrentUser())
                
                .build();
    }

    public ReceiptResponse objToResponse(Receipt entity) {
        return ReceiptResponse.builder()
                .id(entity.getId())
                .otherAmount(entity.getOtherAmount())
                .amount(entity.getAmount())
                .client(entity.getClient())
                .cargoList(entity.getCargoList())



                // BaseEntity
                .user(entity.getUser())
                .active(entity.isActive())
                .note(entity.getNote())
                .description(entity.getDescription())
                .attachment(entity.getAttachment())
                .image(entity.getImage())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .createdTime(entity.getCreatedTime())
                .updatedBy(entity.getUpdatedBy())
                //.updatedTime(entity.getUpdatedTime())
                .updatedAt(entity.getUpdatedAt())
                //.date(entity.getDate())

                .build();
    }
}
