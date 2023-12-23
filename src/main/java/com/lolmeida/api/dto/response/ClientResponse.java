/**
 * Represents a response object for a client.
 */
package com.lolmeida.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.Pattern;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues.Descriptions;
import com.lolmeida.ApplicationValues.Examples;
import com.lolmeida.ApplicationValues.Regex;

@Builder
public record ClientResponse(
        @Schema(description = Descriptions.NAME,
                required = true,
                example = Examples.NAME)
        String name,

        @Schema(description = Descriptions.PHONE_NUMBER,
                required = true,
                example = Examples.PHONE_NUMBER)
        @Pattern(regexp = Regex.PHONE_NUMBER,
                 message = Regex.PHONE_NUMBER_ERROR_MSG)
        String phoneNumber,

        @Schema(description = Descriptions.ADDRESS,
                required = true,
                example = Examples.ADDRESS)
        String address,

        String type,

        @Schema(description = Descriptions.EMAIL,
                required = true,
                example = Examples.EMAIL)

        @Pattern(regexp = Regex.EMAIL,
                 message = Regex.EMAIL_ERROR_MSG)
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
