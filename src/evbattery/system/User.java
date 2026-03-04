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

    public void tambahBaterai(Baterai baterai) {
        this.daftarBaterai.add(baterai);
        System.out.println("Baterai " + baterai.getIdBaterai() + " ditambahkan ke user " + this.nama);
    }
}