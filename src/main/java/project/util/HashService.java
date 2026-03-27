package project.util;

import java.security.MessageDigest;

public class HashService {
    
    public static String generateHash(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            byte[] hashBytes = md.digest(text.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);

                if (hex.length() == 1) {
                    sb.append('0');
                }

                sb.append(hex);
            }

            return sb.toString();

        } catch (Exception e) {
            return null;
        }
    }
}
