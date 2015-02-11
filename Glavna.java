package hr.tvz.java.vjezbe.glavna;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import hr.tvz.java.vjezbe.entitet.Casopis;
import hr.tvz.java.vjezbe.entitet.Clan;
import hr.tvz.java.vjezbe.entitet.Izdavac;
import hr.tvz.java.vjezbe.entitet.Knjiga;
import hr.tvz.java.vjezbe.entitet.Posudba;
import hr.tvz.java.vjezbe.entitet.Publikacija;
import hr.tvz.java.vjezbe.iznimke.DuplikatPublikacijeException;
import hr.tvz.java.vjezbe.iznimke.NeisplativoObjavljivanjeException;

public class Glavna {
	
	private static Knjiga unosKnjige(Scanner ulaz) throws NeisplativoObjavljivanjeException, DuplikatPublikacijeException {
		String tmpNazivKnjige, tmpJezikKnjige;
		int tmpGodinaIzdanja, tmpBrojStranica, tmpVrsta;
				
		System.out.println("Unesite naziv knjige:");
		tmpNazivKnjige = ulaz.nextLine();
		System.out.println("Unesite jezik knjige:");
		tmpJezikKnjige = ulaz.nextLine();
		char c = tmpJezikKnjige.charAt(0);
		System.out.println("Unesite godinu knjige:");
		tmpGodinaIzdanja = ulaz.nextInt();
		System.out.println("Unesite broj stranica knjige:");
		tmpBrojStranica = ulaz.nextInt();
		System.out.println("Unesite vrstu:");
		System.out.println("1. Elektronička publikacija");
		System.out.println("2. Papirnata publikacija");
		tmpVrsta = ulaz.nextInt();
		ulaz.nextLine();
		
		Izdavac izdavac = unosIzdavaca(ulaz);
		Knjiga tmp = null;
		if(tmpVrsta == 1 && (c == 'h' || c == 'H')) {
			tmp = new Knjiga(tmpNazivKnjige, tmpJezikKnjige, tmpGodinaIzdanja, tmpBrojStranica, Publikacija.VRSTA_PUBLIKACIJE_ELEKTRONICKA, izdavac, Knjiga.CIJENA_PO_STRANICI_HR);
		} else if(tmpVrsta == 1 && (c != 'h' || c != 'H')) {
			tmp = new Knjiga(tmpNazivKnjige, tmpJezikKnjige, tmpGodinaIzdanja, tmpBrojStranica, Publikacija.VRSTA_PUBLIKACIJE_ELEKTRONICKA, izdavac, Knjiga.CIJENA_PO_STRANICI_STRANO);
		} else if(tmpVrsta == 2 && (c == 'h' || c == 'H')) {
			tmp = new Knjiga(tmpNazivKnjige, tmpJezikKnjige, tmpGodinaIzdanja, tmpBrojStranica, Publikacija.VRSTA_PUBLIKACIJE_PAPIRNATA, izdavac, Knjiga.CIJENA_PO_STRANICI_HR);
		} else {
			tmp = new Knjiga(tmpNazivKnjige, tmpJezikKnjige, tmpGodinaIzdanja, tmpBrojStranica, Publikacija.VRSTA_PUBLIKACIJE_PAPIRNATA, izdavac, Knjiga.CIJENA_PO_STRANICI_STRANO);
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
		System.out.println("Unesite vrstu:");
		System.out.println("1. Elektronička publikacija");
		System.out.println("2. Papirnata publikacija");
		tmpVrsta = ulaz.nextInt();
		ulaz.nextLine();
		
		Casopis tmp;
		
		if(tmpVrsta == 1) {
			tmp = new Casopis(tmpNazivCasopisa, tmpGodinaCasopisa, tmpBrojStranica, Publikacija.VRSTA_PUBLIKACIJE_ELEKTRONICKA, tmpMjesec);
		} else {
			tmp = new Casopis(tmpNazivCasopisa, tmpGodinaCasopisa, tmpBrojStranica, Publikacija.VRSTA_PUBLIKACIJE_PAPIRNATA, tmpMjesec);
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
		Publikacija[] publikacije = new Publikacija[4];
		Clan clan = null;
		boolean nastavi = true;
		while(nastavi) {
			System.out.println("Unos 1. knjige:");
			try {
				publikacije[0] = unosKnjige(ulaz);
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
				publikacije[1] = unosKnjige(ulaz);
				if(publikacije[0].equals(publikacije[1])) {
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
				publikacije[2] = unosCasopisa(ulaz);
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
				publikacije[3] = unosCasopisa(ulaz);
				if(publikacije[0].equals(publikacije[1])) {
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
				
		Arrays.sort(publikacije, (Publikacija p1, Publikacija p2) -> (p1.getCijena().compareTo(p2.getCijena())));
		Publikacija najveca = publikacije[3];
		Publikacija najmanja = publikacije[0];
		
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
		int n = publikacije.length;
		for(int i=0; i<n; i++) {
			System.out.println((i+1) + ") " + publikacije[i].getNazivPublikacije());
		}
		
		int odabir = ulaz.nextInt();
		ulaz.nextLine();
		while(odabir != 1 && odabir != 2 && odabir != 3 && odabir != 4) {
			odabir = ulaz.nextInt();
			ulaz.nextLine();
		}
		odabir -= 1;
		
		Posudba posudba = new Posudba(clan, publikacije[odabir], LocalDateTime.now());
		
				
		System.out.println("Stanje posudbe:");
		System.out.println("Naziv publikacije: " + publikacije[odabir].getNazivPublikacije());
		System.out.println("Vrsta: " + publikacije[odabir].getVrstaPublikacije());
		System.out.println("Broj stranica: " + publikacije[odabir].getBrojStranicaPublikacije());
		System.out.println("Cijena: " + publikacije[odabir].getCijena());
		if(publikacije[odabir] instanceof Knjiga) {
			System.out.println("Jezik: " + ((Knjiga) publikacije[odabir]).getJezikKnjige());
			System.out.println("Izdavač:" + ((Knjiga) publikacije[odabir]).getIzdavac().getNazivIzdavaca());
			System.out.println("Država izdavača: " + ((Knjiga) publikacije[odabir]).getIzdavac().getDrzavaIzdavaca());
			System.out.print("Raspoloživo za posudbu: ");
			if( (((Knjiga) publikacije[odabir]).provjeriRaspolozivost()) == true) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		} else {
			System.out.println("Mjesec: " + (((Casopis) publikacije[odabir]).getMjesecIzdavanja()));
		}
		
		System.out.println("Podaci korisnika: ");
		System.out.println("Prezime: " + clan.getPrezime());
		System.out.println("Ime: " + clan.getIme());
		System.out.println("OIB: " + clan.getOibOsobe());
		System.out.println("Datum posudbe: " + posudba.getLocalDateTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss")));
		
	}

}
