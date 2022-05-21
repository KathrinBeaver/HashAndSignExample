package ru.mai.crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class SignExample {

    private SecretKey secretKey;

    public void testSignAlgorithms() {
        System.out.println("------ AES -----");
        testAES("Очень секретная строка");
        testAES("Hello");
    }

    private void testAES(String data) {

        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            this.secretKey = keyGenerator.generateKey();

            System.out.println(this.secretKey.getAlgorithm());

            for (int i = 0; i < 1; i++) {
                System.out.println("---- Iteration " + (i + 1));
                byte[] cypher = makeAes(data.getBytes(), Cipher.ENCRYPT_MODE);
                System.out.println(cypher);
                System.out.println(new String(cypher));
                byte[] src = makeAes(cypher, Cipher.DECRYPT_MODE);
                System.out.println(src);
                System.out.println(new String(src));
            }

        } catch (NoSuchAlgorithmException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private byte[] makeAes(byte[] rawMessage, int cipherMode){
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, this.secretKey);
            byte [] output = cipher.doFinal(rawMessage);
            return output;
        } catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
            return null;
        }
    }
}
