package com.lolmeida.api.mapper;

import jakarta.enterprise.context.Dependent;

import com.lolmeida.api.dto.request.ReceiptRequest;
import com.lolmeida.api.dto.response.ReceiptResponse;
import com.lolmeida.api.entity.database.Receipt;
import com.lolmeida.api.utils.Utils;

@Dependent
public class ReceiptMapper {
    public Receipt requestToObj(final ReceiptRequest request) {
        return Receipt.builder()
                .id(Utils.generateRandomString())
                .otherAmount(request.otherAmount())
                .amount(request.amount())
                .client(request.client())
                .cargoList(request.cargoList())
                .user(Utils.getCurrentUser())
                
                .build();
    }

    public ReceiptResponse objToResponse(final Receipt entity) {
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
