package com.lolmeida.api.mapper;

import jakarta.enterprise.context.Dependent;

import com.lolmeida.api.dto.request.SizeRequest;
import com.lolmeida.api.dto.response.SizeResponse;
import com.lolmeida.api.entity.database.Size;
import com.lolmeida.api.utils.Utils;

@Dependent
public class SizeMapper {

    public Size requestToObj(final SizeRequest request) {
        return Size.builder()
                   .id(Utils.generateRandomString())
                   .volume(request.volume())
                   .length(request.length())
                   .width(request.width())
                   .user(Utils.getCurrentUser())

                   .build();
    }

    public SizeResponse objToResponse(final Size entity) {
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
