/**
 * Represents a request object for a recipient.
 */
package com.lolmeida.dto.request;

import lombok.Builder;

@Builder
public record RecipientRequest(
         String name,
         String phoneNumber,
         String address,
         String type,
         String email
){
}
