/**
 * Represents a response object for a client.
 */
package com.lolmeida.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;

@Builder
public record ClientResponse(
        String name,
        String phoneNumber,
        String address,
        String type,
        String email,
        List<String> cargoList,
        List<String> receiptList,

        String user,



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
) {
}
