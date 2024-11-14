package net.hauntedstudio.bp.datastore.utils;

import java.security.SecureRandom;

public class UUIDGenerator {


    private static long counter = 1;  // Counter to increment the last part

    public static String generateUUID() {
        String randomPart = generateRandomPart(26);  // Generate random string (length 26)
        String incrementPart = String.format("%06d", counter++);  // Incrementing part with leading zeros (6 digits)

        return randomPart + incrementPart;
    }

    // Generates a random alphanumeric string of given length
    private static String generateRandomPart(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }
}
