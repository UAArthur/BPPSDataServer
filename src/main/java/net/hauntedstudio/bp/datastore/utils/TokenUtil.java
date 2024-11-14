package net.hauntedstudio.bp.datastore.utils;

import java.security.SecureRandom;
import java.util.Base64;

public class TokenUtil {
    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generateToken(int byteLength) {
        // Generate the byte array with the specified length
        byte[] randomBytes = new byte[byteLength];
        secureRandom.nextBytes(randomBytes);

        // Return the Base64-encoded string without padding, which will give the exact length we want
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    public static String generateUpperCaseToken(int length) {
        byte[] randomBytes = new byte[length];
        secureRandom.nextBytes(randomBytes);
        String token = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
        return token.substring(0, length).toUpperCase();
    }

}
