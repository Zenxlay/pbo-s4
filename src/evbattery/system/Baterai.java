package evbattery.system;

import java.util.ArrayList;
import java.util.List;

public abstract class Baterai {
    private String idBaterai;
    private double kapasitasDesain;
    private double kapasitasSekarang;
    private String jenisKimia;
    private List<BarangElektronik> daftarElektronik;

    public Baterai(String idBaterai, double kapasitasDesain, String jenisKimia, double kapasitasSekarang) {
        this.idBaterai = idBaterai;
        this.kapasitasDesain = kapasitasDesain;
        this.kapasitasSekarang = kapasitasSekarang; 
        this.daftarElektronik = new ArrayList<>();
    }

    public abstract void cekStatus();
    
    public void dayaBaterai(double kwh) {
        this.kapasitasSekarang = Math.max(0, this.kapasitasSekarang - kwh);
    }


    public void tambahBarangElektronik(BarangElektronik barang) {
        this.daftarElektronik.add(barang);
        System.out.println(barang.getNama() + " berhasil dihubungkan ke baterai " + this.idBaterai);
    }

    public void nyalakanSemuaPerangkat(int durasiJam) {
        double totalKwhDibutuhkan = 0;
        System.out.println("\nMenghitung konsumsi daya untuk " + daftarElektronik.size() + " perangkat selama " + durasiJam + " jam...");
        
        for (BarangElektronik barang : daftarElektronik) {
            double kwhPerangkat = barang.konsumsiKwh(durasiJam);
            totalKwhDibutuhkan += kwhPerangkat;
            System.out.println("- " + barang.getNama() + " menggunakan " + String.format("%.2f", kwhPerangkat) + " kWh");
        }

        if (this.kapasitasSekarang >= totalKwhDibutuhkan) {
            dayaBaterai(totalKwhDibutuhkan);
            System.out.println("Status: Berhasil! Sisa kapasitas baterai: " + String.format("%.2f", getKapasitasSekarang()) + " kWh");
        } else {
            System.out.println("Status: Gagal! Kapasitas baterai tidak cukup. (Butuh: " + totalKwhDibutuhkan + " kWh, Tersedia: " + getKapasitasSekarang() + " kWh)");
        }
    }

    // --- Getters ---
    public String getIdBaterai() { return idBaterai; }
    public double getKapasitasDesain() { return kapasitasDesain; }
    public double getKapasitasSekarang() { return kapasitasSekarang; } 
    public String getJenisKimia() { return jenisKimia; }
    public List<BarangElektronik> getDaftarElektronik() { return daftarElektronik; }
}