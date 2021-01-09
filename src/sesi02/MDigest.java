/*
 *  This is a Supplemental File from the Main Project used
 *  in Java Programming Core Fundamental III
 *  with FGroupIndonesia online & offline sessions.
 *  (c) FGroupIndonesia.com
 */
package sesi02;


import java.security.MessageDigest;

/**
 *
 * @author ASUS
 */
public class MDigest {
    public static void main(String[] args) {
        
        try{
        String message = "kata penting";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(message.getBytes());
        byte[] digest = md.digest(); 
        
        
        System.out.println("Awalnya : " + message);
        System.out.println("Menjadi : " + digest);
        System.out.println("Setelah di show : ");
        
        showData(digest);
        
        } catch (Exception ex){
            
        }
        
    }
    
    private static void showData(byte[] digest){
        
        String hexString ="";

        for (int i = 0; i < digest.length; i++) {
            hexString += Integer.toHexString(0xFF & digest[i]);
        }

          System.out.println("Hash Value : " + hexString);

        
    }
    
}
