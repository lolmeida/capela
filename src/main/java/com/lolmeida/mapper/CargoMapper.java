package com.lolmeida.mapper;

import jakarta.enterprise.context.Dependent;

import com.lolmeida.dto.request.CargoRequest;
import com.lolmeida.dto.response.CargoResponse;
import com.lolmeida.entity.database.Cargo;
import com.lolmeida.utils.Utils;

@Dependent
public class CargoMapper {
    public Cargo requestToObj(CargoRequest request) {
        return Cargo.builder()
                .id(Utils.generateRandomString())
                .cargoNumber(request.cargoNumber())
                .client(request.client())
                .recipient(request.recipient())
                .total(request.total())
                .sizeList(request.sizeList())
                .status(request.status())
                .sizeList(request.sizeList())
                .user(Utils.getCurrentUser())

                .build();
    }

    public CargoResponse objToResponse(Cargo entity) {
        return CargoResponse.builder()
                .id(entity.getId())
                .client(entity.getClient())
                .recipient(entity.getRecipient())
                .total(entity.getTotal())
                .sizeList(entity.getSizeList())
                .status(entity.getStatus())
                .cargoNumber(entity.getCargoNumber())
                .sizeList(entity.getSizeList())

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
                .comments(entity.getComments())

                .build();
    }
}
