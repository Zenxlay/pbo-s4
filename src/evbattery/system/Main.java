package evbattery.system;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistem Manajemen Siklus Hidup Baterai EV ===\n");

        User user1 = new User("Budi", "Padalarang, Jawa Barat", "Pemilik Kendaraan");

        EVBattery evBaterai1 = new EVBattery("BAT-EV-001", 60.0, "Lithium-Ion", 75.0);

        user1.tambahBaterai(evBaterai1);

        System.out.println("\n--- Pengecekan Awal EV Battery ---");
        evBaterai1.cekStatus();

        System.out.println("\n--- Proses di Certification Center ---");
        CertificationCenter center = new CertificationCenter();

        SecondLifeBattery slBaterai = center.rekondisi(evBaterai1);

        if (slBaterai != null) {
            System.out.println("\n--- Baterai Berhasil Direkondisi ---");
            
            slBaterai.cekStatus();

            System.out.println("\n--- Simulasi Penggunaan Baterai Second Life ---");
            slBaterai.simpanEnergiSurya();
            slBaterai.suplaiListrik();
            
            System.out.println("");
            user1.tambahBaterai(slBaterai);
        } else {
            System.out.println("\nBaterai harus didaur ulang (Recycle).");
        }
    }
}
// buat demo file