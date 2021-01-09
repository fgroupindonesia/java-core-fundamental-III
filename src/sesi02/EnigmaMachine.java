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
public class EnigmaMachine {

    private SecretKeySpec secretKey;
    private byte[] key;

    public String decrypt(String msg, String key) {

        String endResult = null;
        try {
            setKey(key);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            endResult = new String(cipher.doFinal(Base64.getDecoder().decode(msg)));
        } catch (Exception e) {
            System.out.println("Error saat decrypting: " + e.toString());
        }
        return endResult;
    }

    public String encrypt(String msg, String key) {
        String endResult = null;

        try {
            setKey(key);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            endResult = Base64.getEncoder().encodeToString(cipher.doFinal(msg.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error saat encrypting: " + e.toString());
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
        } catch (Exception e) {
            System.out.println("Error saat setKey: " + e.toString());
        }
    }

    public static void main(String[] args) {
        EnigmaMachine engine = new EnigmaMachine();
        String kunci = "secret";
        String kodeRahasia = engine.encrypt("pesan", kunci);
        System.out.println(kodeRahasia);
        String terjemahan = engine.decrypt(kodeRahasia, kunci);
        System.out.println(terjemahan);
    }
    
}
