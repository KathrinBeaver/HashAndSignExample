package ru.mai.crypto;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Example {

    public void testBase64Algorithm() {
        System.out.println("------ Base64 -----");
        String data = "Эту строку нужно передать на фронт.";
        try {
            // Base64 encode
            byte[] encodedData = Base64.getEncoder().encode(data.getBytes("UTF-8"));
            System.out.println(encodedData);
            for(byte b : data.getBytes("UTF-8")) {
                System.out.print(b + " ");
            }
            String encodedStr = new String(encodedData);
            System.out.println("\n" + encodedStr);

            // Base64 decode
            byte[] resData = Base64.getDecoder().decode(encodedData);
            System.out.println("\n" + resData);

            for(byte b : resData) {
                System.out.print(b + " ");
            }
            String resStr = new String(resData, "UTF-8");
            System.out.println("\n" + resStr);

        } catch (UnsupportedEncodingException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
