package sr.bludots.memory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;


// Assignment

// assignment 1:
// vul een array met 1 miljoen records (allemaal zelfde naam)
// wijzig steeds van 1 record (de laatste, de middelste en de eerste)  de naam
// zoek naar dit record en laat zien hoe lang dit duurt.


// assignments 2:
// vul een hashmap met 1 miljoen records, gebruik elke keer een unieke id, de naam mag steeds hetzelfde
// zijn of mag je veranderen als je dat voor elkaar krijgt
// meet hoe lang het duurt om een record op te vragen
// maak 1 record met een andere naam,
// meet ook hoe lang het duurt om dit record via zijn key op te vragen...






public class CollectionExample2 {

	
	public static class Person implements Comparable<Person> {
		
		private String voornaam;
		private String achternaam;
		private String adres;
		private int leeftijd;
		
			
		public Person(String voornaam, String achternaam) {
			this.voornaam = voornaam;
			this.achternaam = achternaam;
			this.adres = "";
			this.leeftijd = 18;
		}
		public Person(String voornaam, String achternaam, String adres, int leeftijd) {
			this.voornaam = voornaam;
			this.achternaam = achternaam;
			this.adres = adres;
			this.leeftijd = leeftijd;
		}
		
		public String getVoorNaam() {
			return voornaam;
		}
		
		public String getAchterNaam() {
			return achternaam;
		}
		
		public String getAdres() {
			return adres;
		}

		public void setAdres(String adres) {
			this.adres = adres;
		}

		public int getLeeftijd() {
			return leeftijd;
		}

		public void setLeeftijd(int leeftijd) {
			this.leeftijd = leeftijd;
		}

		@Override
		public String toString() {
			return "Ik heet "  + voornaam + " " + achternaam; 
		}
		
		@Override 
		public boolean equals(Object obj1) {
			Person p1 = (Person) obj1;
			if (p1.getVoorNaam().equalsIgnoreCase(voornaam) && p1.getAchterNaam().equalsIgnoreCase((achternaam)) ){
				return true;
			}
			else {
				return false;
			}
		}

		@Override
		public int compareTo(Person p1) {
			int c = achternaam.compareTo(p1.achternaam);
			if (c == 0) {
				c = voornaam.compareTo(p1.voornaam);
			}
			return c;
		}
	}
	
	public static void main(String args[]) {
		
		long t0 = System.currentTimeMillis();
		
		ArrayList <Person> arrayList1 = new ArrayList<Person>();
		long t2= System.currentTimeMillis();
		arrayList1.add(new Person("Justin", "Douglas", "Markoesastraat", 30));
		arrayList1.add(new Person("Everny", "Iengibe", "Coppenamestraat", 15));
		arrayList1.add(new Person("Kirsten", "Mentopawiro", "Wanicastrat", 22));
		arrayList1.add(new Person("Boris", "Douglas", "Markoesastraat", 30));
		
		Collections.sort(arrayList1);
		
		Person checkPerson = new Person("Justin", "Douglas");
		
		//System.err.println("check= " + arrayList1.contains(checkPerson));
		
		
		///  A      B    C    D    E   F  G  H -> 2 log(8) = 3
		
		// Binary search
		// reeks moet gesorteerd zijn (voor uw zoekterm)
		// n records -> 2 log
		
		
		// Linear
		// aantal records: alle records doorlopen (worst case) of 1 (best case)
		
		
		// ArrayList
		// - lineair 
		// - record kan meerdere keren voorkomen (niet uniek)
		// - elke element kan via index worden aangesproken. (eerste =0, tweede=1, etc etc)
		
		// Map 
		// kent een key en een value 
		// key moet uniek zijn
		// opvragen altijd via key (sleutel)
		// map is ongesorteerd, de volgorde is niet voorspelbaar
		
		HashMap <Integer, Person> personMap = new HashMap<Integer, Person>();
		personMap.put(111, new Person("Justin", "Douglas", "Markoesastraat", 30));
		personMap.put(112, new Person("Everny", "Iengibe", "Coppenamestraat", 15));
		personMap.put(113, new Person("Kirsten", "Mentopawiro", "Wanicastraat", 22));
		personMap.put(114, new Person("Boris", "Douglas", "Markoesastraat", 30));
		personMap.put(111, new Person("Boris", "Douglas", "Markoesastraat", 30));
		
		Person p = personMap.get(113);
		//System.err.println(p);
		
		// (linear) list
		Collection <Person> persons = personMap.values();
		for (Person person: persons) {
			if (person.voornaam.equals("Boris" )) {
				//System.err.println("Found!! " + person);
			}
		}
		
		// (linear) list
		int size = persons.size();
		ArrayList <Person> arrayOfPersons = new ArrayList<Person>(persons);
		for (int i=0; i<size; i++) {
			Person p1 = arrayOfPersons.get(i);
			if (p1.voornaam.equals("Boris" )) {
				System.err.println("Found!! " + p1);
			}
		}
		
		// show all keys
		Collection <Integer> keys = personMap.keySet();
		for (Integer key: keys) {
			Person p2 = personMap.get(key);
			if (p2.voornaam.equals("Boris")) {
				System.err.println("Key=" + key + ", person=" + p2);
			}
		}
		
		//System.err.println(personMap);
		
		//epoch time. time elapsed since specific point in time (1970, 0:00 uur in Greenwich) 
		
		// current time ->
		long t1 = System.currentTimeMillis();
		long duration = t1-t0;
		System.err.println(" it took " + duration + "  ms");
		
	}
	
	
	
	
	public static void main2(String args[]) {
		
		// Collections
		
		// Array: 
		// grootte van te voren bekend
		// lijst van elementen
		// waarde hoeft niet uniek
		// 
		// array vaste grootte, ArrayList heeft dynamisch grootte.
		// Array -> elk element kunt u direct aanroepen met zijn index, startend met index 0
		// dus array met 10 elementen, eerste heeft index 0 en laatste index 9
		// elementen zijn van gelijksoortig type (bepaald door definitie)
		
		ArrayList <String> arrayList = new ArrayList<String>();
		arrayList.add("brian");
		arrayList.add("kirsten");
		arrayList.add("kirsten");
		//System.err.println("Dit array heeft " + arrayList.size() + " elementen");
		
		//System.err.println("Array contains brian =" + arrayList.contains("kirsten"));
		
		
		// collection -> List -> ArrayList [0] [1] [2] 
		// collection -> List -> LinkedList
		// collection -> List -> Stack
		// 
		
		
		
		ArrayList <Person> arrayList1 = new ArrayList<Person>();
		
		Person p1 = new Person("Justin", "Douglas");
		arrayList1.add(p1);
		arrayList1.add(new Person("Everny", "Iengibe"));
			
		System.err.println("Dit array heeft " + arrayList1.size() + " elementen");
		
		System.err.println(arrayList1.get(0));

		Person check = new Person("Justin", "Douglas");
		
		System.err.println("check= " + arrayList1.contains(check));

		
	}
	
	
	
	public static void main1(String args[]) {
		
		int a = 1; // dit is de scalaire variant
		
		a = a + 10;
		a = a * 5;
		// a = null;
		
		Integer b = 1; // dit is de object variant, dus een class Integer
		b = null;
		// je mag ook allerlei
		
		Integer c = new Integer(10);
		String s = c.toString();
		
		Long bankreknr = 3456124455L;
		
		System.err.println(" bankrek=" + bankreknr);
		
		String bank = "0000123445123";
		
		String banhaa = "ABNA121311821";
		
		double getal = 10;
		
		//System.err.println(" getal=" + getal);
		
		DecimalFormat formatter = new DecimalFormat("#.00");
		System.err.println("getal=" + formatter.format(getal));
		
		BigDecimal getal1 = new BigDecimal(101221124256464876609486.399501).setScale(2, RoundingMode.HALF_UP);
		System.err.println("big getal=" + getal1);
		
		double a1 = 8;
		double b1 = 9;
		
		double c1 = b1/a1;
		System.err.println(c1);
		
		double omzetbelastingperc  = 0.07;
		double bedrag_totaal  = 12.5d ;
		double omzet_belasting = omzetbelastingperc * bedrag_totaal;
		double netto_bedrag = (1-omzetbelastingperc) * bedrag_totaal;
		
		System.err.println("omzet_belas=" + omzet_belasting + ", netto= "+ netto_bedrag);
		
		
		
	}
}
