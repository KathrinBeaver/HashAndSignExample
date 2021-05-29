package ru.mai;

import ru.mai.crypto.Base64Example;
import ru.mai.crypto.HashExample;
import ru.mai.crypto.SignExample;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class HashAndSignExample {
    public static void main(String[] args) {

        Base64Example base64Example = new Base64Example();
        base64Example.testBase64Algorithm();

        // Hash examples
//        HashExample hashExample = new HashExample();
//        hashExample.testHashAlgorithms();

        // Sign examples
//        SignExample signExample = new SignExample();
//        signExample.testSignAlgorithms();
    }
}
