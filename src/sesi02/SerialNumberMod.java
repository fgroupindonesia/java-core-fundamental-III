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
public class SerialNumberMod {
    public static void main(String[] args) throws Exception {
        
        String namaOrang = "x";
        String namaEmail = "my@email.com";
        
        System.out.println(generate(16, namaEmail));
    }
    
    public static String generate(int total, String input) throws Exception {
        
        String hasilSemula = Enkripsi.printAs("MD5", input);
        System.out.println("Awal " + hasilSemula);
        String hasilBaru = cutLength(hasilSemula, total);
        System.out.println("Kini " + hasilBaru);
        String hasilKhusus = addSeparator(hasilBaru, "-", 4);
        System.out.println("Final " + hasilKhusus);
        return hasilKhusus;
    }
    
    public static String addSeparator(String textAwal, String symbol, int divider){
        
        String baru=  "";
        
        char huruf [] = textAwal.toCharArray();
        int posisi = 0;
        for(char satuan:huruf){
            
            if(posisi==divider){
                baru += symbol;
                posisi=0;
            }
            
            baru+= satuan;
            
            posisi++;
        }
        
        return baru.toUpperCase();
        
    }
    
    public static String cutLength(String input, int batas){
        
        char huruf[] = input.toCharArray();
        String terpotong = "";
        
        int totalDidapat = 0;
        
        for(char satuan:huruf){
            
            
            if(batas == totalDidapat){
                break;
            }
            terpotong += satuan;
            
            totalDidapat++;
        }
    
        return terpotong;
        
    }
}
