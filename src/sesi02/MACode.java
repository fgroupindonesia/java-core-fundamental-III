/*
 *  This is a Supplemental File from the Main Project used
 *  in Java Programming Core Fundamental III
 *  with FGroupIndonesia online & offline sessions.
 *  (c) FGroupIndonesia.com
 */
package sesi02;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

/**
 *
 * @author ASUS
 */
public class MACode {

    public static void main(String[] args) {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            SecureRandom secRandom = new SecureRandom();
            keyGen.init(secRandom);

            Key key = keyGen.generateKey();
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(key);

            String msg = "info penting";
            
            System.out.println("Awalnya : " + msg);
            
            byte[] macResult = mac.doFinal(msg.getBytes());
            System.out.println("Menjadi : " + new String(macResult));

        } catch (Exception ex) {

        }

    }
}
