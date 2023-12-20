package com.lolmeida.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;

/**
 * Represents a response object for a user.
 */
@Builder
public record UserResponse(

        /**
         * The email of the user.
         */
        String email,
        
        /**
         * The name of the user.
         */
        String name,
        
        /**
         * The phone number of the user.
         */
        String phoneNumber,
        
        /**
         * The address of the user.
         */
        String address,
        
        /**
         * The signature of the user.
         */
        String signature,
        
        /**
         * The privilege of the user.
         */
        String privilege,
        
        /**
         * The permission of the user.
         */
        String permission,


        // BaseEntity
        /**
         * The ID of the user.
         */
        String id,
        
        /**
         * Indicates if the user is active or not.
         */
        boolean active,
        
        /**
         * A note for the user.
         */
        String note,
        
        /**
         * A description of the user.
         */
        String description,
        
        /**
         * An attachment related to the user.
         */
        String attachment,
        
        /**
         * An image of the user.
         */
        String image,
        
        /**
         * The user who created this record.
         */
        String createdBy,
        
        /**
         * The date and time when the user was created.
         */
        LocalDateTime createdAt,
        
        /**
         * The timestamp when the user was created.
         */
        Long createdTime,
        
        /**
         * The user who last updated this record.
         */
        String updatedBy,
        
        /**
         * The date and time when the user was last updated.
         */
        LocalDateTime updatedAt,
        
        /**
         * The timestamp when the user was last updated.
         */
        Long updatedTime,
        
        /**
         * The date associated with the user.
         */
        LocalDateTime date


){
}
