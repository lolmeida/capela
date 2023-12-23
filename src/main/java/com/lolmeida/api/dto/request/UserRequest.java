/**
 * Represents a user request.
 */
package com.lolmeida.api.dto.request;

import lombok.Builder;

@Builder
public record UserRequest(

        String email,
        String name,
        String phoneNumber,
        String address,
        String signature) {
}
