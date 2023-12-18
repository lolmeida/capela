package com.lolmeida.mapper;

import com.lolmeida.Utils;
import com.lolmeida.dto.request.ClientRequest;
import com.lolmeida.dto.response.ClientResponse;
import com.lolmeida.entity.database.Client;
import jakarta.enterprise.context.Dependent;

@Dependent
public class ClientMapper {
    public Client requestToObj(ClientRequest request) {
        return Client.builder()
                .id(Utils.generateRandomString())
                .name(request.name())
                .phoneNumber(request.phoneNumber())
                .address(request.address())
                .email(request.email())
                .user(Utils.getCurrentUser())

                .build();
    }

    public ClientResponse objToResponse(Client entity) {
        return ClientResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .email(entity.getEmail())
                .cargoList(entity.getCargoList())
                .receiptList(entity.getReceiptList())


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