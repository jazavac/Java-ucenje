package hr.tvz.java.vjezbe.entitet;

import hr.tvz.java.vjezbe.iznimke.NeisplativoObjavljivanjeException;

import java.math.BigDecimal;

public class Casopis extends Publikacija {
	
	private int mjesecIzdavanja;
	public static final BigDecimal CIJENA_PO_PRIMJERKU = new BigDecimal(10.0);
	
	public Casopis(String nazivKnjige, int godinaIzdanja, int brojStranicaPublikacije, String vrstaPublikacije, int mjesecIzdavanja)
			throws NeisplativoObjavljivanjeException {
		
		super(nazivKnjige, godinaIzdanja, brojStranicaPublikacije, vrstaPublikacije, new BigDecimal(0.6));
		this.mjesecIzdavanja = mjesecIzdavanja;
		if(this.getCijena().compareTo(new BigDecimal(1.0)) == 0 || this.getCijena().compareTo(new BigDecimal(1.0)) == -1) {
			throw new NeisplativoObjavljivanjeException("Neisplativo objavljivanje časopisa!");
		}
	}

	public int getMjesecIzdavanja() {
		return mjesecIzdavanja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + mjesecIzdavanja;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Casopis))
			return false;
		Casopis other = (Casopis) obj;
		if (mjesecIzdavanja != other.mjesecIzdavanja)
			return false;
		return true;
	}
	
}
