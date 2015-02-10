package hr.tvz.java.vjezbe.entitet;

public class Clan {
	
	private String ime;
	private String prezime;
	private String oibOsobe;
	
	public Clan(String ime, String prezime, String oibOsobe) {
		this.ime = ime;
		this.prezime = prezime;
		this.oibOsobe = oibOsobe;
	}
	
	public String getIme() {
		return ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public String getOibOsobe() {
		return oibOsobe;
	}
	
}
