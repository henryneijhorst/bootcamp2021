package sr.bludots.memory;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Random;

import sr.bludots.memory.SportAtleet.Sport;

/*
 * Assignment:
 * 
 * 1) Zorg ervoor dat de geboortedatum willekeurig is tussen 2 data 
 * bijv atleten moeten geboren zijn tussen 1990 - 2003
 * 
 * 2) Zoek naar alle individuele sporters
 * 
 * 3) Druk af hoeveel teamsporters er in de lijst zitten
 * 
 * 4) Druk af hoeveel sporters er zijn die jarig zijn in Maart
 *
 * 5) Druk af hoeveel sporters er zijn die geboren zijn in 2000-2002
 * 
 * 6) Druk de geboortedatum af in de Europese notatie  1 January 2002  (en niet de Amerikaanse 2002-01-01)
 *
 * Wat verwachten wij van u?
 * - gebruik overall for loops zonder int i = 0; i<x; i++, gebruik nieuwe constructies
 * - gebruik LocalDateTime formatter
 * - minimaliseer het aantal regels code (geen duplicaat code)
 * - gebruik logische functie namen
 * - probeer in 1 functie dingen te combineren, dus als je een 
 *  functie A en B die ongeveer hetzelfde doen, kun je dan een functie C maken
 * - probeer logische taken te isoleren in aparte functie
 * - probeer waar mogelijk a?b:c
 * - probeer zoveel constanten/enumeraties te gebruiken dus
 *   liever Month.MARCH dan 3 of liever VOLWASSSEN dan 18
 */


public class AtleetManager {

	public static ArrayList<SportAtleet> atletenList = new ArrayList<>();

	// zoek naar alle atleten die zwemmen en druk deze dan af
	public static void search(Sport searchSportType) {
		search("", searchSportType);
	}

	// zoek naar alle atleten die jair heten en zwemmen en druk deze dan af. Als firstName null is (negeer deze) 
	public static void search(String firstName, Sport searchSportType) {

		for (int i = 0; i < atletenList.size(); i++) {
			SportAtleet atleet = atletenList.get(i);
			if (atleet.getSport().equals(searchSportType)) {
				String voornaam = atleet.getVoornaam();
				if (firstName.equals("") || firstName.equals(voornaam)) {	
					atleet.showAtleet();
				}
			}
		}
	}
	// byte -> 8 bits
	// 0000 0000 -> 1111 1111 -> 2^ 8 combinaties 0 -> 255 (256 mogelijkheden)
	// signed -128 t/m 127
	// unsigned 0 t/m 255
	// ASCII tabel 
	// 2 bytes -> 16 bits -> 2^16 combinaties 0 -> 65535 
	// UTF-16 
	// int -> 4 bytes -> 2^32 
	// long -> 8 bytes -> 2^64
	
	public static void searchIndividualOrTeam(boolean zoekIndividueel) {
		String title = zoekIndividueel?"Individuele sporters":"Teamsporters";
		if (zoekIndividueel) {
			title = "A";
		}
		else {
			title = "B";
		}
		int leeftijd = 18;
		String soort = (leeftijd < 18) ? "Kind": leeftijd > 60?"Senior":"Volwassen";
		
		if (leeftijd < 18) {
			soort = "Kind";
		}
		else {
			if (leeftijd > 60) {
				soort = "Senior";
			}
			else {
				soort = "Volwassen";
			}
		}
		System.out.println(title);
		for (int i = 0; i < atletenList.size(); i++) {
			Sport sport = atletenList.get(i).getSport();
			boolean sportIndividueel = sport.isIndividueel();
			if (zoekIndividueel == sportIndividueel) {
				System.out.println("Name: "+atletenList.get(i).getVoornaam()
						+" "+atletenList.get(i).getAchternaam()+ 
						" Sport: " + sport.toString());
			} 
		}
	}
	
	public void sportmenBornInMarch(ArrayList<Atleet> sporters) {
		int marchBornPlayers = 0;
		for (Atleet atleet: sporters) {
			if (atleet.getGeboortedatum().getMonth().equals(Month.MARCH)) {
				marchBornPlayers++;
			}
		}
		sporters.forEach(atleet -> {
			if (atleet.getGeboortedatum().getMonth().equals(Month.MARCH)) {
				System.out.println(" Atleet: "  + atleet.getVoornaam() +
						" geboren op "+ getEuroDate(atleet.getGeboortedatum()));
			}
		});
		System.out.println("Aantal spelers geboren in maart: " + marchBornPlayers);
		
	}
	
	// Return a string representation of a date
	public String getEuroDate(LocalDate date) {
		int year = date.getYear();
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();
		String s = day + "-" + month + "-" + year;
		
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd-MM-yyyy HH:mm ")
                .toFormatter();
		s = formatter.format(date);
		return s;
	}
	
	
	public static void main(String args[]) {

		fillAtletenArray();
		
			// zoek naar alle atleten die zwemmen en druk deze dan af
		search(Sport.ZWEMMEN);
		//of
		search("", Sport.ZWEMMEN);

		// zoek naar alle atleten die jair heten en zwemmen en druk deze dan af
		search("Jair", Sport.ZWEMMEN);

		LocalDate startDatum = LocalDate.of(1999, 1, 1);
		LocalDate endDatum = LocalDate.of(2005,12, 31);
		Duration duration = Duration.between(startDatum.atStartOfDay(), endDatum.atStartOfDay());
		System.err.println(" verschil is " + duration.toDays());
		LocalDate nextDate = startDatum.plusDays(1);
		System.err.println("D1=" + startDatum + ", D2=" + nextDate);
		System.err.println("Maand van D1=" + startDatum.getMonthValue() + ", maand=" + startDatum.getMonth());
		System.err.println("Jaar van D1=" + startDatum.getYear());
	}
	
	public static void fillAtletenArray() {
		for (int i = 0; i < 50; i++) {
			Random random = new Random();

			String[] voornamen = { "Jair", "Lisa", "Roy", "Bob", "Jenny" };
			int chooseVoornaam = random.nextInt(voornamen.length);

			String[] achternamen = { "ling", "Ben", "Bro", "Lenny", "Rob" };
			int chooseAchternaam = random.nextInt(achternamen.length);

			int chooseSport = random.nextInt(Sport.values().length);

			LocalDate[] geboorteDatum = { LocalDate.of(1999, 9, 1), LocalDate.of(2006, 9, 1), LocalDate.of(2004, 9, 1),
					LocalDate.of(2003, 9, 1), LocalDate.of(2004, 9, 1) };
			
			int choosegeboorteDatum = random.nextInt(geboorteDatum.length);

			SportAtleet atleet = new SportAtleet(voornamen[chooseVoornaam], achternamen[chooseAchternaam], 
					Sport.values()[chooseSport], geboorteDatum[choosegeboorteDatum]);

			atletenList.add(atleet);

		}
	
	}
}
