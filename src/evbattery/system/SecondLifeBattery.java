package evbattery.system;

public class SecondLifeBattery extends Baterai {
    private String idSertifikat;
    private String lokasiInstalasi;

    public SecondLifeBattery(String idBaterai, double kapasitasDesain, String jenisKimia, String idSertifikat, String lokasiInstalasi) {
        super(idBaterai, kapasitasDesain, jenisKimia);
        this.idSertifikat = idSertifikat;
        this.lokasiInstalasi = lokasiInstalasi;
    }

    public void simpanEnergiSurya() {
        System.out.println("Menyimpan energi surya pada baterai " + getIdBaterai() + " di " + lokasiInstalasi);
    }

    public void suplaiListrik() {
        System.out.println("Baterai " + getIdBaterai() + " sedang menyuplai listrik ke grid/rumah.");
    }

    @Override
    public void cekStatus() {
        System.out.println("=== Status Second Life Battery ===");
        System.out.println("ID Baterai       : " + getIdBaterai());
        System.out.println("ID Sertifikat    : " + idSertifikat);
        System.out.println("Lokasi Instalasi : " + lokasiInstalasi);
    }
}