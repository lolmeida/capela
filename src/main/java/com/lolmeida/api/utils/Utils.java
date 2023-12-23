package com.lolmeida.api.utils;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import lombok.extern.java.Log;

@Log
public class Utils {

    public static StringBuilder queries = new StringBuilder();
    public static List<String> params = new ArrayList<>();

    @SafeVarargs
    public static void createCriteria(final Map<String, String>... fieldsAndValues) {
        List<Map<String, String>> list = Arrays.stream(fieldsAndValues).toList();

        list.forEach(map -> {
            map.forEach((key, value) -> {
                queries.append("LOWER(").append(key).append(") like ?").append(params.size() + 1).append(" and ");
                params.add("%" + value.toLowerCase() + "%");
            });
        });

        queries = new StringBuilder(queries.toString().substring(0, queries.toString().length() - 4));
    }

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
