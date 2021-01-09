/*
 *  This is a Supplemental File from the Main Project used
 *  in Java Programming Core Fundamental III
 *  with FGroupIndonesia online & offline sessions.
 *  (c) FGroupIndonesia.com
 */
package sesi01;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author ASUS
 */
public class AppLoc {

    public static void main(String[] args) {

        //String lokasi = System.getProperty("user.home");
        String lokasi = System.getenv("APPDATA");

        String namaApp = "System Kasir";

        String lokasiLengkap = lokasi + File.separator + namaApp;

        System.out.println("bernilai " + lokasiLengkap);

        String myOS = System.getProperty("os.name");

        System.out.println("OS Saya ternyata : " + myOS);

        //File targetDelete = new File("datapenting");
        //targetDelete.delete();
        AppLoc contoh = new AppLoc();
        contoh.hapus(new File("datapenting"));
        
        contoh.pindahkan(new File("penting.accdb"), new File("D:\\penting.xls"));

    }

    public void pindahkan(File awal, File ke) {

        try {
            Files.move(awal.toPath(), ke.toPath(), StandardCopyOption.ATOMIC_MOVE);
        } catch (Exception ex) {
            System.out.println("ADa kesalahan saat moving");
        }

    }

    public void hapus(File target) {

        if (target.isDirectory()) {
            for (File isi : target.listFiles()) {
                hapus(isi);
            }
        }

        target.delete();
    }
}
