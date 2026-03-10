package evbattery.system;

public abstract class Baterai {
    private String idBaterai;
    private double kapasitasDesain;
    private double kapasitasSekarang;
    private String jenisKimia;

    public Baterai(String idBaterai, double kapasitasDesain, String jenisKimia, double kapasitasSekarang) {
        this.idBaterai = idBaterai;
        this.kapasitasDesain = kapasitasDesain;
        this.kapasitasSekarang = kapasitasDesain;
        this.jenisKimia = jenisKimia;
    }

    public abstract void cekStatus();
    
    public void dayaBaterai(double kwh) {
    	this.kapasitasSekarang = Math.max(0, this.kapasitasSekarang - kwh);
    }

    public String getIdBaterai() { return idBaterai; }
    public double getKapasitasDesain() { return kapasitasDesain; }
    public double getKapasitasSekarang() { return kapasitasSekarang ;} 
    public String getJenisKimia() { return jenisKimia; }
}