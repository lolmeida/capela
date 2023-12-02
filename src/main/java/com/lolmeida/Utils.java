package com.lolmeida;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;

public  class Utils {
    public static long currentTime = System.currentTimeMillis(); //Instant.now().toEpochMilli();
    public static LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("UTC"));


    public  static String generateRandomString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println(generatedString);

        return generatedString;
    }

    public static String activeUser() {
        return "lolmeida@gmail.com";
    }
}
