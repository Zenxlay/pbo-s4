package evbattery.system;

public class EVBattery extends Baterai {
    private double soH;

    public EVBattery(String idBaterai, double kapasitasDesain, String jenisKimia, double soH) {
        super(idBaterai, kapasitasDesain, jenisKimia, soH);
        this.soH = soH;
    }

    public boolean isEligibleForEV() {
        return this.soH >= 80.0;
    }

    @Override
    public void cekStatus() {
        System.out.println("=== Status EV Battery ===");
        System.out.println("ID Baterai : " + getIdBaterai());
        System.out.println("SoH        : " + soH + "%");
        System.out.println("Status EV  : " + (isEligibleForEV() ? "Layak" : "Tidak Layak, butuh rekondisi"));
    }

    public double getSoH() { return soH; }
}