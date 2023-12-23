package com.lolmeida.api.utils;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;

public class Utils {

    public static String generateRandomString() {
        int leftLimit = 48; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                                       .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                                       .limit(12)
                                       .collect(StringBuilder::new,
                                                StringBuilder::appendCodePoint,
                                                StringBuilder::append)
                                       .toString();
        return generatedString;
    }

    public static String activeUser() {
        return "lolmeida@gmail.com";
    }

    public static Long getEpochTime() {
        return System.currentTimeMillis();
    }

    public static LocalDateTime getLocalDateTime() {
        return LocalDateTime.now(ZoneId.of("UTC"));
    }

    public static String getCurrentUser() {
        return "lolmeida@gmail.com";
    }
}
