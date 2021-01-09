/*
 *  This is a Supplemental File from the Main Project used
 *  in Java Programming Core Fundamental III
 *  with FGroupIndonesia online & offline sessions.
 *  (c) FGroupIndonesia.com
 */
package sesi02;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ASUS
 */
public class EncryptionDecryptionMaker {

    SecretKeySpec secretKey;
    byte[] key;

    public static void main(String[] args) {

        String pesanWorldWar = "kontaminasi file besar-besaran!";
        EncryptionDecryptionMaker enigma = new EncryptionDecryptionMaker();
        
        String hasil = enigma.encrypt(pesanWorldWar, "jcfIII");
        System.out.println("Awal\t:" + pesanWorldWar);
        System.out.println("Menjadi\t:" + hasil);
        
    }

    public String encrypt(String msg, String key) {
        String endResult = null;
        try {
            setKey(key);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            endResult = Base64.getEncoder().encodeToString(cipher.doFinal(msg.getBytes("UTF-8")));

        } catch (Exception ex) {

        }

        return endResult;
    }

    public String decrypt(String msg, String key) {
        String endResult = null;
        try {
            setKey(key);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            endResult = new String(cipher.doFinal(Base64.getDecoder().decode(msg)));

        } catch (Exception ex) {

        }

        return endResult;

    }

    public void setKey(String myKey) {
        try {

            key = myKey.getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");

        } catch (Exception ex) {

        }
    }

}
