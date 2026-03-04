package evbattery.system;

import java.util.UUID;

public class CertificationCenter {

    public boolean ujiKesehatan(EVBattery evBattery) {
        System.out.println("Menguji baterai EV: " + evBattery.getIdBaterai() + "...");
        return evBattery.getSoH() < 80.0 && evBattery.getSoH() >= 40.0;
    }

    public String terbitkanSertifikat() {
        String certId = "CERT-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        System.out.println("Sertifikat berhasil diterbitkan: " + certId);
        return certId;
    }

    public SecondLifeBattery rekondisi(EVBattery evBattery) {
        if (ujiKesehatan(evBattery)) {
            System.out.println("Memulai proses rekondisi...");
            String sertifikatBaru = terbitkanSertifikat();
            
            return new SecondLifeBattery(
                evBattery.getIdBaterai() + "-SL",
                evBattery.getKapasitasDesain(),
                evBattery.getJenisKimia(),
                sertifikatBaru,
                "Belum diatur"
            );
        } else {
            System.out.println("Baterai rusak parah, tidak bisa direkondisi (Harus di-recycle).");
            return null;
        }
    }
}