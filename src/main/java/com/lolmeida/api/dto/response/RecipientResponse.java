/**
 * Represents a response object for a recipient.
 */
package com.lolmeida.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.Builder;

import com.lolmeida.ApplicationValues.Examples.Descriptions;
import com.lolmeida.ApplicationValues.Examples.Values;


@Builder
public record RecipientResponse(
        @Schema(
                description = Descriptions.NAME,
                required = true,
                example = Values.NAME)

        String name,

        @Schema(
                description = Descriptions.PHONE_NUMBER,
                required = true,
                example = Values.PHONE_NUMBER)
        String phoneNumber,

        @Schema(
                description = Descriptions.ADDRESS,
                required = true,
                example = Values.ADDRESS)
        String address,

        @Schema(
                description = "The type of the recipient",
                required = true,
                example = "CLIENT")
        String type,

        @Schema(
                description = Descriptions.EMAIL,
                required = true,
                example = Values.EMAIL)
        String email,
        List<String> cargoList,
        String user,
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
