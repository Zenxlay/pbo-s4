package evbattery.system;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistem Manajemen Siklus Hidup Baterai EV ===\n");

        // 1. Inisialisasi User
        User user1 = new User("Budi", "Padalarang", "Pemilik Kendaraan & Home Energy Storage");

        // 2. Inisialisasi Baterai (Awalnya EV Battery)
        EVBattery evBaterai1 = new EVBattery("BAT-EV-001", 60.0, "Lithium-Ion", 75.0);
        user1.tambahBaterai(evBaterai1);

        // 3. Proses Rekondisi ke Second Life
        System.out.println("\n--- Proses Rekondisi Certification Center ---");
        CertificationCenter center = new CertificationCenter();
        SecondLifeBattery slBaterai = center.rekondisi(evBaterai1);

        if (slBaterai != null) {
            slBaterai.setLokasiInstalasi("Rumah Budi - Padalarang");
            user1.tambahBaterai(slBaterai);

            // 4. Daftar Perangkat Elektronik (Minimal 5)
            List<ElektronikRumah> perabotan = new ArrayList<>();
            perabotan.add(new ElektronikRumah("Kulkas Inverter", 150));
            perabotan.add(new ElektronikRumah("AC Split", 750));
            perabotan.add(new ElektronikRumah("Smart TV 55 Inch", 100));
            perabotan.add(new ElektronikRumah("Mesin Cuci", 350));
            perabotan.add(new ElektronikRumah("Lampu LED Rumah", 50));

            // 5. Simulasi Penggunaan Dinamis (Misal: Dipakai selama 10 jam)
            System.out.println("\n--- Simulasi Penggunaan Daya Selama 10 Jam ---");
            int durasi = 10;
            double totalKonsumsi = 0;

            for (ElektronikRumah alat : perabotan) {
                double kwh = alat.konsumsiKwh(durasi);
                totalKonsumsi += kwh;
                System.out.println("- " + alat.getNama() + " menghabiskan: " + kwh + " kWh");
            }

            slBaterai.dayaBaterai(totalKonsumsi);
            System.out.println("\nTotal Energi Terkuras: " + totalKonsumsi + " kWh");

            // 6. Menampilkan Info User Akhir
            user1.displayInfoLengkap();

        } else {
            System.out.println("\nBaterai tidak layak pakai dan harus didaur ulang.");
        }
    }
}