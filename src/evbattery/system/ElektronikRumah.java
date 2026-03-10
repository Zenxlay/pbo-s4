package evbattery.system;

public class ElektronikRumah {
	private String nama;
	private double konsumsiWatt;
	
	public ElektronikRumah(String nama, double konsumsiWatt) {
		this.nama = nama;
		this.konsumsiWatt = konsumsiWatt;
	}
	
	public double konsumsiKwh (int durasijam) {
		return (konsumsiWatt * durasijam)/1000.0 ;
	}
	
	public String getNama() { return nama; }
}
