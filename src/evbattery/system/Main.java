package evbattery.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> daftarPengguna = new ArrayList<>();
        boolean isRunning = true;

        System.out.println("Selamat datang di Sistem Manajemen Baterai Second Life!");

        while (isRunning) {
            System.out.println("\n========= MENU UTAMA =========");
            System.out.println("1. Tambah User Baru");
            System.out.println("2. Tambah Baterai ke User");
            System.out.println("3. Tambah Perangkat ke Baterai");
            System.out.println("4. Simulasikan Penggunaan (Waktu Berjalan)");
            System.out.println("5. Tampilkan Semua Data Sistem");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (0-5): ");
            
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    // --- Tambah User ---
                    System.out.print("Masukkan Nama User: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Alamat: ");
                    String alamat = scanner.nextLine();
                    System.out.print("Masukkan Peran (misal: Pemilik Rumah): ");
                    String peran = scanner.nextLine();
                    
                    daftarPengguna.add(new User(nama, alamat, peran));
                    System.out.println("User '" + nama + "' berhasil ditambahkan!");
                    break;

                case "2":
                    // --- Tambah Baterai ---
                    if (daftarPengguna.isEmpty()) {
                        System.out.println("Belum ada user. Silakan buat user terlebih dahulu.");
                        break;
                    }
                    
                    System.out.println("\nPilih User:");
                    for (int i = 0; i < daftarPengguna.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarPengguna.get(i).getNama());
                    }
                    System.out.print("Nomor User: ");
                    int userIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    
                    if (userIndex >= 0 && userIndex < daftarPengguna.size()) {
                        System.out.print("ID Baterai (misal BAT-01): ");
                        String idBat = scanner.nextLine();
                        System.out.print("Kapasitas (kWh, misal 50.0): ");
                        double kap = Double.parseDouble(scanner.nextLine());
                        System.out.print("Lokasi Instalasi (misal Garasi): ");
                        String lokasi = scanner.nextLine();
                        
                        SecondLifeBattery slb = new SecondLifeBattery(idBat, kap, "Lithium-Ion", "CERT-NEW", lokasi);
                        daftarPengguna.get(userIndex).tambahBaterai(slb);
                    } else {
                        System.out.println("Pilihan user tidak valid.");
                    }
                    break;

                case "3":
                    // --- Tambah Perangkat ---
                    if (daftarPengguna.isEmpty()) {
                        System.out.println("Sistem kosong. Tambahkan user dan baterai dahulu.");
                        break;
                    }
                    
                    // Simple approach: Add to a specific user's last added battery for ease of use
                    // (In a full app, you'd list users, then list their batteries)
                    System.out.print("Masukkan Nama Perangkat (misal TV, AC): ");
                    String namaAlat = scanner.nextLine();
                    System.out.print("Konsumsi Daya (Watt, misal 150): ");
                    double watt = Double.parseDouble(scanner.nextLine());
                    System.out.print("ID Perangkat (misal 101): ");
                    int idAlat = Integer.parseInt(scanner.nextLine());
                    
                    BarangElektronik barang = new BarangElektronik(namaAlat, watt, idAlat);
                    
                    System.out.println("\nPilih User untuk menambahkan perangkat ini:");
                    for (int i = 0; i < daftarPengguna.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarPengguna.get(i).getNama());
                    }
                    System.out.print("Nomor User: ");
                    int uIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    
                    if (uIndex >= 0 && uIndex < daftarPengguna.size()) {
                        User selectedUser = daftarPengguna.get(uIndex);
                        // Assuming the user has a method to get their batteries, or we just add a helper method.
                        // For simplicity in this UI, let's just add the device to ALL batteries owned by the user 
                        // or you can implement a getter in User.java to select the specific battery.
                        System.out.println("Menambahkan " + namaAlat + " ke sistem " + selectedUser.getNama() + "...");
                        // We will add it to the first battery they own as a simple UI example
                        // NOTE: You need a getDaftarBaterai() method in User.java to do this perfectly.
                        System.out.println("Silakan implementasi pemilihan baterai spesifik di versi selanjutnya!");
                    }
                    break;

                case "4":
                    // --- Simulasi ---
                    System.out.print("Masukkan durasi simulasi (jam): ");
                    int jam = Integer.parseInt(scanner.nextLine());
                    System.out.println("\n=== MEMULAI SIMULASI PENGGUNAAN (" + jam + " JAM) ===");
                    for (User u : daftarPengguna) {
                        System.out.println("\nMenjalankan untuk User: " + u.getNama());
                        u.nyalakanSemuaBaterai(jam);
                    }
                    break;

                case "5":
                    // --- Tampilkan Status ---
                    System.out.println("\n=== STATUS KESELURUHAN SISTEM ===");
                    if (daftarPengguna.isEmpty()) {
                        System.out.println("Data kosong.");
                    } else {
                        for (User u : daftarPengguna) {
                            u.displayInfoLengkap();
                        }
                    }
                    break;

                case "0":
                    // --- Keluar ---
                    System.out.println("Terima kasih telah menggunakan sistem ini. Selamat tinggal!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }
}