package hr.tvz.java.vjezbe.glavna;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import hr.tvz.java.vjezbe.entitet.Casopis;
import hr.tvz.java.vjezbe.entitet.Clan;
import hr.tvz.java.vjezbe.entitet.Izdavac;
import hr.tvz.java.vjezbe.entitet.Knjiga;
import hr.tvz.java.vjezbe.entitet.Posudba;
import hr.tvz.java.vjezbe.entitet.Publikacija;
import hr.tvz.java.vjezbe.enumeracija.Jezik;
import hr.tvz.java.vjezbe.enumeracija.VrstaPublikacije;
import hr.tvz.java.vjezbe.iznimke.DuplikatPublikacijeException;
import hr.tvz.java.vjezbe.iznimke.NeisplativoObjavljivanjeException;

public class Glavna {
	
	private static Knjiga unosKnjige(Scanner ulaz) throws NeisplativoObjavljivanjeException, DuplikatPublikacijeException {
		String tmpNazivKnjige;
		int tmpJezikKnjige, tmpGodinaIzdanja, tmpBrojStranica, tmpVrsta;

		System.out.println("Unesite naziv knjige:");
		tmpNazivKnjige = ulaz.nextLine();
		do {
			System.out.println("Unesite jezik knjige:");
			for(Jezik jezik : Jezik.values()) {
				System.out.println(jezik.getKod() + ") " + jezik.getOpis());
			}
			tmpJezikKnjige = ulaz.nextInt();
			ulaz.nextLine();
		}while(tmpJezikKnjige>Jezik.values().length || tmpJezikKnjige<1);
		Jezik tmpJezik = Jezik.values()[tmpJezikKnjige-1];
		System.out.println("Unesite godinu knjige:");
		tmpGodinaIzdanja = ulaz.nextInt();
		System.out.println("Unesite broj stranica knjige:");
		tmpBrojStranica = ulaz.nextInt();
		do {
			System.out.println("Unesite vrstu:");
			System.out.println("1. Elektronička publikacija");
			System.out.println("2. Papirnata publikacija");
			tmpVrsta = ulaz.nextInt();
			ulaz.nextLine();
		}while(tmpVrsta != 1 && tmpVrsta != 2);
		
		Izdavac izdavac = unosIzdavaca(ulaz);
		Knjiga tmp = null;
		if(tmpVrsta == 1 && tmpJezikKnjige == 1) {
			tmp = new Knjiga(tmpNazivKnjige, tmpJezik, tmpGodinaIzdanja, tmpBrojStranica, VrstaPublikacije.ELEKTRONICKA, izdavac, Knjiga.CIJENA_PO_STRANICI_HR);
		} else if(tmpVrsta == 1 && tmpJezikKnjige != 1) {
			tmp = new Knjiga(tmpNazivKnjige, tmpJezik, tmpGodinaIzdanja, tmpBrojStranica, VrstaPublikacije.ELEKTRONICKA, izdavac, Knjiga.CIJENA_PO_STRANICI_STRANO);
		} else if(tmpVrsta == 2 && tmpJezikKnjige == 1) {
			tmp = new Knjiga(tmpNazivKnjige, tmpJezik, tmpGodinaIzdanja, tmpBrojStranica, VrstaPublikacije.PAPIRNATA, izdavac, Knjiga.CIJENA_PO_STRANICI_HR);
		} else {
			tmp = new Knjiga(tmpNazivKnjige, tmpJezik, tmpGodinaIzdanja, tmpBrojStranica, VrstaPublikacije.PAPIRNATA, izdavac, Knjiga.CIJENA_PO_STRANICI_STRANO);
		}
		return tmp;
		
	}
	
	private static Izdavac unosIzdavaca(Scanner ulaz) {
		
		String tmpNazivIzdavaca, tmpDrzavaIzdavaca;
		System.out.println("Unesite izdavača:");
		tmpNazivIzdavaca = ulaz.nextLine();
		System.out.println("Unesite državu izdavača:");
		tmpDrzavaIzdavaca = ulaz.nextLine();
		return new Izdavac(tmpNazivIzdavaca, tmpDrzavaIzdavaca);
		
	}
	
	private static Casopis unosCasopisa(Scanner ulaz) throws NeisplativoObjavljivanjeException, DuplikatPublikacijeException {
		String tmpNazivCasopisa;
		int tmpGodinaCasopisa, tmpBrojStranica, tmpMjesec, tmpVrsta;
				
		System.out.println("Unesite naziv časopisa:");
		tmpNazivCasopisa = ulaz.nextLine();
		System.out.println("Unesite godinu časopisa:");
		tmpGodinaCasopisa = ulaz.nextInt();
		System.out.println("Unesite broj stranica časopisa:");
		tmpBrojStranica = ulaz.nextInt();
		System.out.println("Unesite mjesec časopisa:");
		tmpMjesec = ulaz.nextInt();
		do {
			System.out.println("Unesite vrstu:");
			System.out.println("1. Elektronička publikacija");
			System.out.println("2. Papirnata publikacija");
			tmpVrsta = ulaz.nextInt();
			ulaz.nextLine();
		}while(tmpVrsta != 1 && tmpVrsta != 2);
		
		Casopis tmp;
		
		if(tmpVrsta == 1) {
			tmp = new Casopis(tmpNazivCasopisa, tmpGodinaCasopisa, tmpBrojStranica, VrstaPublikacije.ELEKTRONICKA, tmpMjesec);
		} else {
			tmp = new Casopis(tmpNazivCasopisa, tmpGodinaCasopisa, tmpBrojStranica, VrstaPublikacije.PAPIRNATA, tmpMjesec);
		}
		return tmp;
		
	}
	
	private static Clan unosClana(Scanner ulaz) {
		String tmpIme, tmpPrezime, tmpOibOsobe;
		System.out.println("Unesite OIB člana:");
		tmpOibOsobe = ulaz.nextLine();
		System.out.println("Unesite ime člana:");
		tmpIme = ulaz.nextLine();
		System.out.println("Unesite prezime člana:");
		tmpPrezime = ulaz.nextLine();
		
		return new Clan(tmpIme, tmpPrezime, tmpOibOsobe);
		
	}
	
	public static void main(String[] args) throws NeisplativoObjavljivanjeException, DuplikatPublikacijeException {
		
		Scanner ulaz = new Scanner(System.in);
		List<Publikacija> publikacija = new ArrayList<>();
		Publikacija publikacije;
		Clan clan = null;
		boolean nastavi = true;
		while(nastavi) {
			System.out.println("Unos 1. knjige:");
			try {
				publikacije = unosKnjige(ulaz);
				publikacija.add(publikacije);
				nastavi = false;
			} catch (NeisplativoObjavljivanjeException noe) {
				nastavi = true;
				System.out.println(noe.getMessage());
			} catch (DuplikatPublikacijeException dpe) {
				nastavi = true;
				System.out.println(dpe.getMessage());
			}
		}
		
		nastavi = true;
		while(nastavi) {
			System.out.println("Unos 2. knjige:");
			try {
				publikacije = unosKnjige(ulaz);
				publikacija.add(publikacije);
				if(publikacija.get(0).equals(publikacija.get(1))) {
					throw new DuplikatPublikacijeException("Duplikat knjige!");
				}
				nastavi = false;
			} catch (NeisplativoObjavljivanjeException noe) {
				nastavi = true;
				System.out.println(noe.getMessage());
			} catch (DuplikatPublikacijeException dpe) {
				nastavi = true;
				System.out.println(dpe.getMessage());
			}
		}
		
		nastavi = true;
		while(nastavi) {
			System.out.println("Unos 1. časopisa:");
			try {
				publikacije = unosCasopisa(ulaz);
				publikacija.add(publikacije);
				nastavi = false;
			} catch (NeisplativoObjavljivanjeException noe) {
				nastavi = true;
				System.out.println(noe.getMessage());
			} catch (DuplikatPublikacijeException dpe) {
				nastavi = true;
				System.out.println(dpe.getMessage());
			}
		}
		
		nastavi = true;
		while(nastavi) {
			System.out.println("Unos 2. časopisa:");
			try {
				publikacije = unosCasopisa(ulaz);
				publikacija.add(publikacije);
				if(publikacija.get(2).equals(publikacija.get(3))) {
					throw new DuplikatPublikacijeException("Duplikat časopisa!");
				}
				nastavi = false;
			} catch (NeisplativoObjavljivanjeException noe) {
				nastavi = true;
				System.out.println(noe.getMessage());
			} catch (DuplikatPublikacijeException dpe) {
				nastavi = true;
				System.out.println(dpe.getMessage());
			}
		}
		
		publikacija.sort((p1, p2) -> p1.getCijena().compareTo(p2.getCijena()));
		
		Publikacija najveca = publikacija.get(3);
		Publikacija najmanja = publikacija.get(0);
		
		if(najveca instanceof Knjiga) {
			System.out.println("Najskuplja publikacija:");
			System.out.println("Naziv publikacije: " + najveca.getNazivPublikacije());
			System.out.println("Vrsta: " + najveca.getVrstaPublikacije());
			System.out.println("Broj stranica: "  + najveca.getBrojStranicaPublikacije());
			System.out.println("Cijena: "  + najveca.getCijena());
			System.out.println("Jezik: "  + ((Knjiga) najveca).getJezikKnjige());
			System.out.println("Izdavač: " + ((Knjiga) najveca).getIzdavac().getNazivIzdavaca());
			System.out.println("Država izdavača: " + ((Knjiga) najveca).getIzdavac().getDrzavaIzdavaca());
			System.out.print("Raspoloživo za posudbu: ");
			if( (((Knjiga) najveca).provjeriRaspolozivost()) == true) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		} else {
			System.out.println("Najskuplja publikacija:");
			System.out.println("Naziv publikacije: " + najveca.getNazivPublikacije());
			System.out.println("Vrsta: " + najveca.getVrstaPublikacije());
			System.out.println("Broj stranica: " + najveca.getBrojStranicaPublikacije());
			System.out.println("Cijena: " + najveca.getCijena());
			System.out.println("Mjesec: " + (((Casopis) najveca).getMjesecIzdavanja()));
		}
		
		if(najmanja instanceof Knjiga) {
			System.out.println("Najjeftinija publikacija:");
			System.out.println("Naziv publikacije: " + najmanja.getNazivPublikacije());
			System.out.println("Vrsta: " + najmanja.getVrstaPublikacije());
			System.out.println("Broj stranica: "  + najmanja.getBrojStranicaPublikacije());
			System.out.println("Cijena: "  + najmanja.getCijena());
			System.out.println("Jezik: "  + ((Knjiga) najmanja).getJezikKnjige());
			System.out.println("Izdavač: " + ((Knjiga) najmanja).getIzdavac().getNazivIzdavaca());
			System.out.println("Država izdavača: " + ((Knjiga) najmanja).getIzdavac().getDrzavaIzdavaca());
			System.out.print("Raspoloživo za posudbu: ");
			if( (((Knjiga) najmanja).provjeriRaspolozivost()) == true) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		} else {
			System.out.println("Najjeftinija publikacija:");
			System.out.println("Naziv publikacije: " + najmanja.getNazivPublikacije());
			System.out.println("Vrsta: " + najmanja.getVrstaPublikacije());
			System.out.println("Broj stranica: " + najmanja.getBrojStranicaPublikacije());
			System.out.println("Cijena: " + najmanja.getCijena());
			System.out.println("Mjesec: " + (((Casopis) najmanja).getMjesecIzdavanja()));
		}
			
		System.out.println("Unos Člana:");
		clan = unosClana(ulaz);
		
		System.out.println("Odaberite publikaciju:");
		String naziv = ulaz.nextLine();
		
		Publikacija odabrana = publikacija.stream().filter(p -> p.getNazivPublikacije().equals(naziv)).findFirst().get();
		
		Posudba posudba = new Posudba(clan, odabrana, LocalDateTime.now());
		
		System.out.println("Stanje posudbe:");
		System.out.println("Naziv publikacije: " + odabrana.getNazivPublikacije());
		System.out.println("Vrsta: " + odabrana.getVrstaPublikacije());
		System.out.println("Broj stranica: " + odabrana.getBrojStranicaPublikacije());
		System.out.println("Cijena: " + odabrana.getCijena());
		if(odabrana instanceof Knjiga) {
			System.out.println("Jezik: " + ((Knjiga) odabrana).getJezikKnjige());
			System.out.println("Izdavač:" + ((Knjiga) odabrana).getIzdavac().getNazivIzdavaca());
			System.out.println("Država izdavača: " + ((Knjiga) odabrana).getIzdavac().getDrzavaIzdavaca());
			System.out.print("Raspoloživo za posudbu: ");
			if( (((Knjiga) odabrana).provjeriRaspolozivost()) == true) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		} else {
			System.out.println("Mjesec: " + (((Casopis) odabrana).getMjesecIzdavanja()));
		}
		System.out.println("Podaci korisnika: ");
		System.out.println("Prezime: " + clan.getPrezime());
		System.out.println("Ime: " + clan.getIme());
		System.out.println("OIB: " + clan.getOibOsobe());
		System.out.println("Datum posudbe: " + posudba.getLocalDateTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss")));
	
		System.out.println("Pretražite publikacije:");
		String naziv2 = ulaz.nextLine();
		System.out.println("Pronađene publikacije:");
		
		List<Publikacija> pretraga = publikacija.stream().filter(p -> p.getNazivPublikacije().contains(naziv2)).collect(Collectors.toList());
		for(Publikacija trazi : pretraga) {
			System.out.println("Naziv publikacije: " + trazi.getNazivPublikacije());
			System.out.println("Vrsta: " + trazi.getVrstaPublikacije());
			System.out.println("Broj stranica: " + trazi.getBrojStranicaPublikacije());
			System.out.println("Cijena: " + trazi.getCijena());
			if(trazi instanceof Knjiga) {
				System.out.println("Jezik: " + ((Knjiga) trazi).getJezikKnjige());
				System.out.println("Izdavač:" + ((Knjiga) trazi).getIzdavac().getNazivIzdavaca());
				System.out.println("Država izdavača: " + ((Knjiga) trazi).getIzdavac().getDrzavaIzdavaca());
				System.out.print("Raspoloživo za posudbu: ");
				if( (((Knjiga) trazi).provjeriRaspolozivost()) == true) {
					System.out.println("DA");
				} else {
					System.out.println("NE");
				}
			} else {
				System.out.println("Mjesec: " + (((Casopis) trazi).getMjesecIzdavanja()));
			}
			System.out.println();
		}
	
	}

}
