/**
 * Represents a response object for a receipt.
 */
package com.lolmeida.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;

@Builder
public record ReceiptResponse(
        double amount,
        double otherAmount,
        String client,
        List<String> cargoList,
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
        LocalDateTime dateTime,
        String updatedBy,
        LocalDateTime updatedAt,
        Long updated
) {
}
