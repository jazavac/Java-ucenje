package hr.tvz.java.vjezbe.entitet;

import hr.tvz.java.vjezbe.enumeracija.VrstaPublikacije;

import java.math.BigDecimal;

public abstract class Publikacija implements ZaProdaju {
	
	private String nazivPublikacije;
	private int godinaIzdanja;
	private int brojStranicaPublikacije;
	private VrstaPublikacije vrstaPublikacije;
	private BigDecimal cijena;
		
	public Publikacija(String nazivPublikacije, int godinaIzdanja, int brojStranicaPublikacije, VrstaPublikacije vrstaPublikacije, BigDecimal cijenaPoStranici) {
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
	
	public VrstaPublikacije getVrstaPublikacije() {
		return vrstaPublikacije;
	}

	public BigDecimal getCijena() {
		return cijena;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brojStranicaPublikacije;
		result = prime * result + ((cijena == null) ? 0 : cijena.hashCode());
		result = prime * result + godinaIzdanja;
		result = prime * result + ((nazivPublikacije == null) ? 0 : nazivPublikacije.hashCode());
		result = prime * result + ((vrstaPublikacije == null) ? 0 : vrstaPublikacije.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Publikacija))
			return false;
		Publikacija other = (Publikacija) obj;
		if (brojStranicaPublikacije != other.brojStranicaPublikacije)
			return false;
		if (cijena == null) {
			if (other.cijena != null)
				return false;
		} else if (!cijena.equals(other.cijena))
			return false;
		if (godinaIzdanja != other.godinaIzdanja)
			return false;
		if (nazivPublikacije == null) {
			if (other.nazivPublikacije != null)
				return false;
		} else if (!nazivPublikacije.equals(other.nazivPublikacije))
			return false;
		if (vrstaPublikacije == null) {
			if (other.vrstaPublikacije != null)
				return false;
		} else if (!vrstaPublikacije.equals(other.vrstaPublikacije))
			return false;
		return true;
	}
	
}
