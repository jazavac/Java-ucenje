package hr.tvz.java.vjezbe.entitet;

import java.math.BigDecimal;

public abstract class Publikacija implements ZaProdaju {
	
	private String nazivPublikacije;
	private int godinaIzdanja;
	private int brojStranicaPublikacije;
	private String vrstaPublikacije;
	private BigDecimal cijena;
	public static final String VRSTA_PUBLIKACIJE_ELEKTRONICKA = "VRSTA_PUBLIKACIJE_ELEKTRONICKA";
	public static final String VRSTA_PUBLIKACIJE_PAPIRNATA = "VRSTA_PUBLIKACIJE_PAPIRNATA";
	
	public Publikacija(String nazivPublikacije, int godinaIzdanja, int brojStranicaPublikacije, String vrstaPublikacije, BigDecimal cijenaPoStranici) {
		this.nazivPublikacije = nazivPublikacije;
		this.godinaIzdanja = godinaIzdanja;
		this.brojStranicaPublikacije = brojStranicaPublikacije;
		this.vrstaPublikacije = vrstaPublikacije;
		cijena = izracunCijene(brojStranicaPublikacije, vrstaPublikacije, cijenaPoStranici);
	}
	
	public String getNazivPublikacije() {
		return nazivPublikacije;
	}
	
	public int getGodinaIzdanja() {
		return godinaIzdanja;
	}

	public int getBrojStranicaPublikacije() {
		return brojStranicaPublikacije;
	}
	
	public String getVrstaPublikacije() {
		return vrstaPublikacije;
	}

	public BigDecimal getCijena() {
		return cijena;
	}
	
}
