package com.lolmeida.mapper;

import jakarta.enterprise.context.Dependent;

import com.lolmeida.dto.request.UserRequest;
import com.lolmeida.dto.response.UserResponse;
import com.lolmeida.entity.database.User;
import com.lolmeida.utils.Utils;

@Dependent
public class UserMapper {
    public User requestToObj(UserRequest request) {
        return User.builder()
                .id(Utils.generateRandomString())
                .name(request.name())
                .phoneNumber(request.phoneNumber())
                .address(request.address())
                .email(request.email())
                .signature(request.signature())

                .build();
    }

    public UserResponse objToResponse(User entity) {
        return UserResponse.builder()

                .email(entity.getEmail())
                .name(entity.getName())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .signature(entity.getSignature())
                .privilege(entity.getPrivilege())
                .permission(entity.getPermission())

                // BaseEntity
                .id(entity.getId())
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
