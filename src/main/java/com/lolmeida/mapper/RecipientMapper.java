package com.lolmeida.mapper;

import com.lolmeida.utils.Utils;
import com.lolmeida.dto.request.RecipientRequest;
import com.lolmeida.dto.response.RecipientResponse;
import com.lolmeida.entity.database.Recipient;
import jakarta.enterprise.context.Dependent;

@Dependent
public class RecipientMapper {
    public Recipient requestToObj(RecipientRequest request) {
        return Recipient.builder()
                .id(Utils.generateRandomString())
                .name(request.name())
                .phoneNumber(request.phoneNumber())
                .address(request.address())
                .email(request.email())
                .user(Utils.getCurrentUser())

                .build();
    }

    public RecipientResponse objToResponse(Recipient entity) {
        return RecipientResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .email(entity.getEmail())
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
                .updatedTime(entity.getUpdatedTime())
                .updatedAt(entity.getUpdatedAt())
                .date(entity.getDate())

                .build();
    }
}
