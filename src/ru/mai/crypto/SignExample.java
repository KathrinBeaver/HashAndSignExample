package ru.mai.crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class SignExample {

    private SecretKey secretKey;

    public void testHashAlgorithms() {
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

            for (int i = 0; i < 2; i++) {
                System.out.println("---- Iteration " + (i + 1));
                byte[] cypher = makeAes(data.getBytes(), Cipher.ENCRYPT_MODE);
                System.out.println(cypher);
                System.out.println(new String(cypher));
                byte[] src = makeAes(cypher, Cipher.DECRYPT_MODE);
                System.out.println(src);
                System.out.println(new String(src));
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private byte[] makeAes(byte[] rawMessage, int cipherMode){
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, this.secretKey);
            byte [] output = cipher.doFinal(rawMessage);
            return output;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
