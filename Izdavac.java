package hr.tvz.java.vjezbe.entitet;

public class Izdavac {
	
	private String nazivIzdavaca;
	private String drzavaIzdavaca;
	
	public Izdavac(String nazivIzdavaca, String drzavaIzdavaca) {
		this.nazivIzdavaca = nazivIzdavaca;
		this.drzavaIzdavaca = drzavaIzdavaca;
	}
	
	public String getNazivIzdavaca() {
		return nazivIzdavaca;
	}
	
	public String getDrzavaIzdavaca() {
		return drzavaIzdavaca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((drzavaIzdavaca == null) ? 0 : drzavaIzdavaca.hashCode());
		result = prime * result
				+ ((nazivIzdavaca == null) ? 0 : nazivIzdavaca.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Izdavac))
			return false;
		Izdavac other = (Izdavac) obj;
		if (drzavaIzdavaca == null) {
			if (other.drzavaIzdavaca != null)
				return false;
		} else if (!drzavaIzdavaca.equals(other.drzavaIzdavaca))
			return false;
		if (nazivIzdavaca == null) {
			if (other.nazivIzdavaca != null)
				return false;
		} else if (!nazivIzdavaca.equals(other.nazivIzdavaca))
			return false;
		return true;
	}
		
}
