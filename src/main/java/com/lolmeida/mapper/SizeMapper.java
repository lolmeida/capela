package com.lolmeida.mapper;

import jakarta.enterprise.context.Dependent;

import com.lolmeida.dto.request.SizeRequest;
import com.lolmeida.dto.response.SizeResponse;
import com.lolmeida.entity.database.Size;
import com.lolmeida.utils.Utils;

@Dependent
public class SizeMapper {
    public Size requestToObj(SizeRequest request) {
        return Size.builder()
                .id(Utils.generateRandomString())
                .volume(request.volume())
                .length(request.length())
                .width(request.width())
                .user(Utils.getCurrentUser())

                .build();
    }

    public SizeResponse objToResponse(Size entity) {
        return SizeResponse.builder()
                .id(entity.getId())
                .volume(entity.getVolume())
                .length(entity.getLength())
                .height(entity.getHeight())
                .width(entity.getWidth())

                

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
