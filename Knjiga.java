package hr.tvz.java.vjezbe.entitet;

import hr.tvz.java.vjezbe.enumeracija.Jezik;
import hr.tvz.java.vjezbe.enumeracija.VrstaPublikacije;
import hr.tvz.java.vjezbe.iznimke.NeisplativoObjavljivanjeException;

import java.math.BigDecimal;

public class Knjiga extends Publikacija implements ZaPosudbu {
	
	private Jezik jezikKnjige;
	private Izdavac izdavac;
	private boolean knjigaRaspoloziva = true;
	public static final BigDecimal CIJENA_PO_STRANICI_HR = new BigDecimal(0.5);
	public static final BigDecimal CIJENA_PO_STRANICI_STRANO = new BigDecimal(0.7);
	
	public Knjiga(String nazivKnjige, Jezik jezikKnjige, int godinaIzdanja, int brojStranicaPublikacije, VrstaPublikacije vrstaPublikacije, Izdavac izdavac,
			BigDecimal cijenaPoStranici) throws NeisplativoObjavljivanjeException {
		
		super(nazivKnjige, godinaIzdanja, brojStranicaPublikacije, vrstaPublikacije, cijenaPoStranici);
		this.jezikKnjige = jezikKnjige;
		this.izdavac = izdavac;
		if(this.getCijena().compareTo(new BigDecimal(100.0)) == 0 || this.getCijena().compareTo(new BigDecimal(100.0)) == -1) {
			throw new NeisplativoObjavljivanjeException("Neisplativo objavljivanje knjige!");
		}
	}

	public Jezik getJezikKnjige() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((izdavac == null) ? 0 : izdavac.hashCode());
		result = prime * result	+ ((jezikKnjige == null) ? 0 : jezikKnjige.hashCode());
		result = prime * result + (knjigaRaspoloziva ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Knjiga))
			return false;
		Knjiga other = (Knjiga) obj;
		if (izdavac == null) {
			if (other.izdavac != null)
				return false;
		} else if (!izdavac.equals(other.izdavac))
			return false;
		if (jezikKnjige != other.jezikKnjige)
			return false;
		if (knjigaRaspoloziva != other.knjigaRaspoloziva)
			return false;
		return true;
	}

	

}
