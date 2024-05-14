package com.lolmeida.api;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;

import com.lolmeida.api.dto.response.CargoResponse;
import com.lolmeida.api.entity.database.Cargo;

public class Utils {

    public static long currentTime = System.currentTimeMillis(); //Instant.now().toEpochMilli();
    public static LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("UTC"));


    public static String generateRandomString() {
        int leftLimit = 48; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                                       .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                                       .limit(12)
                                       .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                       .toString();
        return generatedString;
    }

    public static String activeUser() {
        return "lolmeida@gmail.com";
    }

    public static CargoResponse entityToResponse(Cargo entity) {
        return CargoResponse
                .builder()
                // BASE ENTITY:
                // Auto generated fields
                .active(entity.isActive())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .createdTime(entity.getCreatedTime())
                .updatedTime(entity.getUpdatedTime())
                .updatedAt(entity.getUpdatedAt())
                .date(entity.getDate())
                .receipt(entity.getReceipt())
                .recipient(entity.getRecipient())
                .updatedBy(entity.getUpdatedBy())
                // Other fields
                .note(entity.getNote())
                .description(entity.getDescription())
                .attachment(entity.getAttachment())
                .image(entity.getImage())
                .build();
    }

}
