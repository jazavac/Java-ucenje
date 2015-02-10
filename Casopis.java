package hr.tvz.java.vjezbe.entitet;

import java.math.BigDecimal;

public class Casopis extends Publikacija {
	
	private int mjesecIzdavanja;
	public static final BigDecimal CIJENA_PO_PRIMJERKU = new BigDecimal(10.0);
	
	public Casopis(String nazivKnjige, int godinaIzdanja, int brojStranicaPublikacije, String vrstaPublikacije, int mjesecIzdavanja) {
		
		super(nazivKnjige, godinaIzdanja, brojStranicaPublikacije, vrstaPublikacije, new BigDecimal(0.6));
		this.mjesecIzdavanja = mjesecIzdavanja;
	}

	public int getMjesecIzdavanja() {
		return mjesecIzdavanja;
	}
	
}
