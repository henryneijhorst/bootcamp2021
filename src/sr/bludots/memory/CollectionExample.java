package sr.bludots.memory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class CollectionExample {

	
	public static class Person implements Comparable<Person> {
		
		private String voornaam;
		private String achternaam;
		
		public Person(String voornaam, String achternaam) {
			this.voornaam = voornaam;
			this.achternaam = achternaam;
		}
		
		public String getVoorNaam() {
			return voornaam;
		}
		
		public String getAchterNaam() {
			return achternaam;
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
			return achternaam.compareTo(p1.getAchterNaam());
		}
	}
	
	public static void main(String args[]) {
		ArrayList <Person> arrayList1 = new ArrayList<Person>();
		arrayList1.add(new Person("Justin", "Douglas"));
		arrayList1.add(new Person("Everny", "Iengibe"));
		arrayList1.add(new Person("Kirsten", "Mentopawiro"));
		
		Collections.sort(arrayList1);
		
		Person checkPerson = new Person("JUstin", "Douglas");
		//System.err.println("check= " + arrayList1.contains(checkPerson));
		
		
		System.err.println(arrayList1);
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
