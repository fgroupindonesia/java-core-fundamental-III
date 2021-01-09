/*
 *  This is a Supplemental File from the Main Project used
 *  in Java Programming Core Fundamental III
 *  with FGroupIndonesia online & offline sessions.
 *  (c) FGroupIndonesia.com
 */
package sesi02;

import java.io.FileInputStream;
import java.security.KeyStore;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ASUS
 */
public class KeyStoreLatihan {
    public static void main(String[] args) throws Exception {
        
         KeyStore keyStore = KeyStore.getInstance("JCEKS");

      //Loading the KeyStore object
      char[] password = "changeit".toCharArray();
      String path = "C:\\Program Files\\Java\\jre1.8.0_261\\lib\\security\\cacerts";
      java.io.FileInputStream fis = new FileInputStream(path);
      keyStore.load(fis, password);
      
      //Creating the KeyStore.ProtectionParameter object
      KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);

      //Creating SecretKey object
      SecretKey mySecretKey = new SecretKeySpec("myPassword".getBytes(), "DSA");
      
      //Creating SecretKeyEntry object
      KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(mySecretKey);
      keyStore.setEntry("secretKeyAlias", secretKeyEntry, protectionParam);

      //Storing the KeyStore object
      java.io.FileOutputStream fos = null;
      fos = new java.io.FileOutputStream("newKeyStoreName");
      keyStore.store(fos, password);
      System.out.println("data stored");
        
    }
}
