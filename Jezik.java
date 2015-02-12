package hr.tvz.java.vjezbe.enumeracija;

public enum Jezik {
	
	HRVATSKI (1, "HRVATSKI"),
	ENGLESKI (2, "ENGLESKI"),
	NJEMACKI (3, "NJEMACKI"),
	FRANCUSKI (4, "FRANCUSKI"),
	TALIJANSKI (5, "TALIJANSKI"),
	RUSKI (6, "RUSKI"),
	KINESKI (7, "KINESKI");
	
	private int kod;
	private String opis;
	
	private Jezik(int kod, String opis) {
		this.kod = kod;
		this.opis = opis;
	}

	public int getKod() {
		return kod;
	}
	
	public String getOpis() {
		return opis;
	}

	public String valueOf(int kod) {
		return opis;
	}
	
}
