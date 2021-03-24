package by.tc.carrental.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordCoder {
    public static String code(String password) {
        String encodedPassword;
        String result;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] encoded = messageDigest.digest(password.getBytes());
            encodedPassword = new String(encoded);
            result = encodedPassword;
        } catch (NoSuchAlgorithmException e) {
            result = "";
        }
        return result;
    }
}
