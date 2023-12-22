package com.lolmeida.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;

/**
 * Represents a response object for a user.
 * 
 */
@Builder
public record UserResponse(
        String email,
        String name,
        String phoneNumber,
        String address,
        String signature,
        String privilege,
        String permission,


        // BaseEntity

        String id,
        boolean active,
        String note,
        String description,
        String attachment,
        String image,
        String createdBy,
        LocalDateTime createdAt,
        Long createdTime,
        String updatedBy,
        LocalDateTime updatedAt,
        Long updatedTime,
        LocalDateTime date


)
{ }
