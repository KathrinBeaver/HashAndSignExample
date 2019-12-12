package ru.mai.crypto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashExample {

    private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();

    public void testHashAlgorithms() {

        // Java hash
        System.out.println("------ Java hash -----");
        System.out.println("стол".hashCode());
        System.out.println("мама".hashCode());
        System.out.println("ляля".hashCode());

        // MD5
        System.out.println("------ MD5 -----");
        String hashIncorrectPassword = "35454B055CC325EA1AF2126E27707052";
        String hashCorrectPassword = "0f6e4a1df0cf5ee97c2066953bed21b2";
        String password = "StrongPassword";

        if (hashMD5(password).equals(hashIncorrectPassword)) {
            System.out.println("Correct password");
        } else {
            System.out.println("Incorrect password");
        }
        System.out.println(hashMD5(password));

        if (hashMD5(password).equals(hashCorrectPassword)) {
            System.out.println("Correct password");
        } else {
            System.out.println("Incorrect password");
        }

        //SHA256
        System.out.println("------ SHA256 -----");
        System.out.println(hashSHA256(password));
    }

    /**
     * MD5 hash
     * @param text
     * @return MD5 hash
     */
    private String hashMD5(String text) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            return bytesToHexV2(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * SHA256 hash
     * @param text
     * @return SHA256 hash
     */
    private String hashSHA256(String text) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
//            return bytesToHexV1(hash);
            return bytesToHexV2(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String bytesToHexV1(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int number = bytes[i] & 0xFF;
            hexChars[i * 2] = HEX_ARRAY[number >>> 4];
            hexChars[i * 2 + 1] = HEX_ARRAY[number & 0x0F];
        }
        return new String(hexChars);
    }

    private String bytesToHexV2(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte aHash : hash) {
            String hex = Integer.toHexString(0xff & aHash);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
