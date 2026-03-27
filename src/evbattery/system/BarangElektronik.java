package evbattery.system;

public class BarangElektronik {
	private String nama;
	private int barangid;
	private double konsumsiWatt;
	
	public BarangElektronik(String nama, double konsumsiWatt, int barangid) {
		this.nama = nama;
		this.barangid = barangid; 
		this.konsumsiWatt = konsumsiWatt;
	}
	
	public double konsumsiKwh (int durasijam) {
		return (konsumsiWatt * durasijam)/1000.0 ;
	}
	
	public String getNama() { return nama; }
	public double getKonsumsiWatt() { return konsumsiWatt; }
}
