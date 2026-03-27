package evbattery.system;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIMULASI SISTEM MULTI-BATERAI & MULTI-PERANGKAT ===\n");

        // 1. Create a User
        User pakBudi = new User("Budi Santoso", "Jl. Merdeka No. 10", "Pemilik Rumah");

        // 2. Create Two Separate Batteries
        // Battery 1: For the main house (50 kWh)
        SecondLifeBattery bateraiRumah = new SecondLifeBattery("BAT-SL-001", 50.0, "Lithium-Ion", "CERT-111", "Garasi Rumah");
        
        // Battery 2: For the workshop/kitchen (30 kWh)
        SecondLifeBattery bateraiWorkshop = new SecondLifeBattery("BAT-SL-002", 30.0, "LFP", "CERT-222", "Area Workshop");

        // Assign both batteries to the User
        pakBudi.tambahBaterai(bateraiRumah);
        pakBudi.tambahBaterai(bateraiWorkshop);
        System.out.println();

        // 3. Create Electronic Devices
        // Devices for Battery 1 (Rumah)
        BarangElektronik ac = new BarangElektronik("AC Inverter 1 PK", 750.0, 101);
        BarangElektronik tv = new BarangElektronik("Smart TV 55 Inch", 150.0, 102);
        
        // Devices for Battery 2 (Workshop)
        BarangElektronik ovenListrik = new BarangElektronik("Oven Listrik", 1500.0, 201);
        BarangElektronik mesinCuci = new BarangElektronik("Mesin Cuci", 500.0, 202);

        // 4. Connect Devices to their respective Batteries
        System.out.println("--- Menghubungkan Perangkat ke Baterai Rumah ---");
        bateraiRumah.tambahBarangElektronik(ac);
        bateraiRumah.tambahBarangElektronik(tv);

        System.out.println("\n--- Menghubungkan Perangkat ke Baterai Workshop ---");
        bateraiWorkshop.tambahBarangElektronik(ovenListrik);
        bateraiWorkshop.tambahBarangElektronik(mesinCuci);

        // 5. Simulate Usage Separately
        System.out.println("\n--- Simulasi Penggunaan ---");
        System.out.println(">> Baterai Rumah dinyalakan selama 10 jam (Malam hari):");
        bateraiRumah.nyalakanSemuaPerangkat(10);

        System.out.println("\n>> Baterai Workshop dinyalakan selama 3 jam (Pekerjaan siang):");
        bateraiWorkshop.nyalakanSemuaPerangkat(3);

        // 6. Display Final Status for the User
        pakBudi.displayInfoLengkap();
    }
}