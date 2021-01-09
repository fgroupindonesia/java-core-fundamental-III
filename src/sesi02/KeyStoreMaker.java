/*
 *  This is a Supplemental File from the Main Project used
 *  in Java Programming Core Fundamental III
 *  with FGroupIndonesia online & offline sessions.
 *  (c) FGroupIndonesia.com
 */
package sesi02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.KeyStore.SecretKeyEntry;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ASUS
 */
public class KeyStoreMaker {

    public static void main(String[] args) {

        try {
            KeyStore keyStore = KeyStore.getInstance("JCEKS");
            String path = "C:\\Program Files\\Java\\jre1.8.0_261\\lib\\security\\cacerts";
            char[] pass = "changeit".toCharArray();

            FileInputStream fis = new FileInputStream(path);
            keyStore.load(fis, pass);
            KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection(pass);

            SecretKey mySecretKey = new SecretKeySpec("myPassword".getBytes(), "DSA");
            SecretKeyEntry secretKeyEntry = new SecretKeyEntry(mySecretKey);
            keyStore.setEntry("secretKeyAlias", secretKeyEntry, protectionParam);
            
            FileOutputStream fos = new FileOutputStream("fileStoreBaru");
            keyStore.store(fos, pass);
            

        } catch (Exception ex) {
            System.out.println("Error on " + ex.getMessage());
        }

    }

}
