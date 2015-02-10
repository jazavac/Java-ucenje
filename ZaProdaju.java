package hr.tvz.java.vjezbe.entitet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface ZaProdaju {
	
	default public BigDecimal izracunCijene(int brojStranica, String vrstaPublikacije, BigDecimal cijenaPoStranici) {
		BigDecimal cijena;
		cijena = cijenaPoStranici.multiply(new BigDecimal(brojStranica)).setScale(2, RoundingMode.HALF_UP);
		if(vrstaPublikacije.equals(Publikacija.VRSTA_PUBLIKACIJE_PAPIRNATA)) {
			return cijena;
		} else {
			cijena = cijena.divide(new BigDecimal(1.1), RoundingMode.HALF_UP).setScale(2);
			return cijena;
		}
		
	}
	
}
