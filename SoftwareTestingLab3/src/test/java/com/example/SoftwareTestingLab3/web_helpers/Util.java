package com.example.SoftwareTestingLab3.web_helpers;

import java.util.Random;

public class Util {

    public static String getRandomLetterSequence(int length, String letters) {

        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) { sb.append(letters.charAt(random.nextInt(letters.length()))); }
        return sb.toString();
    }

    public static String createRandomSequence(int length) {
        return getRandomLetterSequence(length, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
    }

}
