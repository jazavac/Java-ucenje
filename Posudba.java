package hr.tvz.java.vjezbe.entitet;

import java.time.LocalDateTime;

public class Posudba {
	
	private Clan clan;
	private Publikacija publikacija;
	private LocalDateTime localDateTime;
	
	public Posudba(Clan clan, Publikacija publikacija, LocalDateTime localDateTime) {
		this.clan = clan;
		this.publikacija = publikacija;
		this.localDateTime = localDateTime;
	}

	public Clan getClan() {
		return clan;
	}

	public Publikacija getPublikacija() {
		return publikacija;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	
}
