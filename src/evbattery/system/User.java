package evbattery.system;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String nama;
    private String alamat;
    private String peran;
    private List<Baterai> daftarBaterai; 

    public User(String nama, String alamat, String peran) {
        this.nama = nama;
        this.alamat = alamat;
        this.peran = peran;
        this.daftarBaterai = new ArrayList<>();
    }

    public String getNama() {
        return this.nama;
    }
    
    public List<Baterai> getDaftarBaterai() {
        return this.daftarBaterai;
    }
    
    public void tambahBaterai(Baterai baterai) {
        this.daftarBaterai.add(baterai);
        System.out.println("Baterai " + baterai.getIdBaterai() + " ditambahkan ke user " + this.nama);
    }
    
    public void nyalakanSemuaBaterai(int durasiJam) {
        for (Baterai b : daftarBaterai) {
            b.nyalakanSemuaPerangkat(durasiJam);
        }
    }
    
    public void displayInfoLengkap() {
        System.out.println("\n========= INFO USER =========");
        System.out.println("Nama   : " + nama);
        System.out.println("Peran  : " + peran);
        System.out.println("Daftar Baterai Milik User:");
        for (Baterai b : daftarBaterai) {
            b.cekStatus();
            System.out.println("Sisa Energi Saat Ini       : " + String.format("%.2f", b.getKapasitasSekarang()) + " kWh");
            System.out.println("Jumlah Perangkat Terhubung : " + b.getDaftarElektronik().size());
            System.out.println("-----------------------------");
        }
    }
}