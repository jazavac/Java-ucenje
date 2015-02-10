package hr.tvz.java.vjezbe.entitet;

import java.math.BigDecimal;

public class Knjiga extends Publikacija implements ZaPosudbu {
	
	private String jezikKnjige;
	private Izdavac izdavac;
	private boolean knjigaRaspoloziva = true;
	public static final BigDecimal CIJENA_PO_STRANICI_HR = new BigDecimal(0.5);
	public static final BigDecimal CIJENA_PO_STRANICI_STRANO = new BigDecimal(0.7);
	
	public Knjiga(String nazivKnjige, String jezikKnjige, int godinaIzdanja, int brojStranicaPublikacije, String vrstaPublikacije, Izdavac izdavac, BigDecimal cijenaPoStranici) {
		super(nazivKnjige, godinaIzdanja, brojStranicaPublikacije, vrstaPublikacije, cijenaPoStranici);
		this.jezikKnjige = jezikKnjige;
		this.izdavac = izdavac;
	}

	public String getJezikKnjige() {
		return jezikKnjige;
	}

	public Izdavac getIzdavac() {
		return izdavac;
	}
	
	public boolean isKnjigaRaspoloziva() {
		return knjigaRaspoloziva;
	}
	
	public void posudba(){
		knjigaRaspoloziva = false;
	}
	
	public void vracanje(){
		knjigaRaspoloziva = true;
	}
	
	public boolean provjeriRaspolozivost(){
		return knjigaRaspoloziva;
	}

	

}
