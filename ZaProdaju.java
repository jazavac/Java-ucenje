package hr.tvz.java.vjezbe.entitet;

import hr.tvz.java.vjezbe.enumeracija.VrstaPublikacije;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface ZaProdaju {
	
	default public BigDecimal izracunCijene(int brojStranica, VrstaPublikacije vrstaPublikacije, BigDecimal cijenaPoStranici) {
		BigDecimal cijena;
		cijena = cijenaPoStranici.multiply(new BigDecimal(brojStranica)).setScale(2, RoundingMode.HALF_UP);
		if(vrstaPublikacije.equals(VrstaPublikacije.PAPIRNATA)) {
			return cijena;
		} else {
			cijena = cijena.divide(new BigDecimal(1.1), RoundingMode.HALF_UP).setScale(2);
			return cijena;
		}
		
	}
	
}
