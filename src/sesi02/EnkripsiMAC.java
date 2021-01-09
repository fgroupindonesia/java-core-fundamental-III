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
public class EnkripsiMAC {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");

      //Creating a SecureRandom object
      SecureRandom secRandom = new SecureRandom();

      //Initializing the KeyGenerator
      keyGen.init(secRandom);

      //Creating/Generating a key
      Key key = keyGen.generateKey();	 

      //Creating a Mac object
      Mac mac = Mac.getInstance("HmacSHA256");

      //Initializing the Mac object
      mac.init(key);

      //Computing the Mac
      String msg = new String("Hi how are you");
      byte[] bytes = msg.getBytes();      
      byte[] macResult = mac.doFinal(bytes);

      System.out.println("Mac result:");
      System.out.println(new String(macResult)); 
      
      
    }
}
