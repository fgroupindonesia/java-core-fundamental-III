package sesi02;

import java.security.MessageDigest;

/*
 *  This is a Supplemental File from the Main Project used
 *  in Java Programming Core Fundamental III
 *  with FGroupIndonesia online & offline sessions.
 *  (c) FGroupIndonesia.com
 */
/**
 *
 * @author ASUS
 */
public class Enkripsi {

    public static void main(String[] args) throws Exception {
        String message = "Windows 7";
        System.out.println("Real Message : " + message);

        printAs("SHA-1", message);
        printAs("SHA-256", message);
        printAs("MD5", message);

    }

    public static String printAs(String algo, String text) throws Exception {
        //Creating the MessageDigest object  
        MessageDigest md = MessageDigest.getInstance(algo);

        //Passing data to the created MessageDigest Object
        md.update(text.getBytes());

        //Compute the message digest
        byte[] digest = md.digest();
        System.out.println(digest + " with price " + digest.length);
        System.out.println(new String(digest));
        //Converting the byte array in to HexString format
        String hexString ="";

        for (int i = 0; i < digest.length; i++) {
            hexString += Integer.toHexString(0xFF & digest[i]);
        }
        //System.out.println("Hash Value : " + hexString);
        
        return hexString;
    }

}
