package evbattery.system;

public abstract class Baterai {
    private String idBaterai;
    private double kapasitasDesain;
    private String jenisKimia;

    public Baterai(String idBaterai, double kapasitasDesain, String jenisKimia) {
        this.idBaterai = idBaterai;
        this.kapasitasDesain = kapasitasDesain;
        this.jenisKimia = jenisKimia;
    }

    public abstract void cekStatus();

    public String getIdBaterai() { return idBaterai; }
    public double getKapasitasDesain() { return kapasitasDesain; }
    public String getJenisKimia() { return jenisKimia; }
}