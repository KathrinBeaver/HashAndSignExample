package ru.mai;

import ru.mai.crypto.HashExample;
import ru.mai.crypto.SignExample;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class HashAndSignExample {
    public static void main(String[] args) {

        System.out.println("------ Base64 -----");
        String data = "Эту строку нужно передать на фронт.";
        try {
            // Base64 encode
            byte[] encodedData = Base64.getEncoder().encode(data.getBytes("UTF-8"));
            System.out.println(encodedData);
            String encodedStr = new String(encodedData);
            System.out.println(encodedStr);

            // Base64 decode
            byte[] resData = Base64.getDecoder().decode(encodedData);
            System.out.println(resData);
            String resStr = new String(resData, "UTF-8");
            System.out.println(resStr);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Hash examples
        HashExample hashExample = new HashExample();
        hashExample.testHashAlgorithms();

        // Sign examples
        SignExample signExample = new SignExample();
        signExample.testHashAlgorithms();
    }
}
