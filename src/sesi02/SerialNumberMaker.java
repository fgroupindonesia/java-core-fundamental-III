/*
 *  This is a Supplemental File from the Main Project used
 *  in Java Programming Core Fundamental III
 *  with FGroupIndonesia online & offline sessions.
 *  (c) FGroupIndonesia.com
 */
package sesi02;

/**
 *
 * @author ASUS
 */
public class SerialNumberMaker {
    public static void main(String[] args) {
        
        EncryptionDecryptionMaker enigma = new EncryptionDecryptionMaker();
        
        String pesan = "myEmail@gmail.com";
        String hasilAwal = enigma.encrypt(pesan, "cryptograph");
        String hasilBaru = hasilAwal.substring(0, 16);
        
        String hasilTerpisah = divideBy(hasilBaru, 4, "-");
        
        System.out.println("Awalnya\t: "+pesan);
        System.out.println("Encrypt\t: "+hasilAwal);
        System.out.println("Cut\t: "+hasilBaru);
        System.out.println("End\t: "+hasilTerpisah);
                
        
    }
    
    private static String divideBy(String input, int limit, String symbol){

        String result = "";
        int posisi = 0;
        char rentetanHuruf [] = input.toCharArray();
        
        for(char satuHuruf: rentetanHuruf){
            
            if(posisi==limit){
                result += "-";
                posisi = 0;
            }
            
            result += satuHuruf;
            posisi++;
            
        }
        
        return result.toUpperCase();
        
    }
}
