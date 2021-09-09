package sr.bludots.memory;

import java.util.Random;


public class Persoon {

	// defineer de variable. Is een class  variable dus er is maar 1 examplaar
	
	private static int personCount = 1000;
	
	// deze initializer wordt bij aanmaken class als eerst aangeroepen na bovenstaande
	
	static {
		personCount = 20;
	}
	// deze initializer wordt bij aanmaken class als tweede aangeroepen na bovenstaande
	static {
		personCount = 40;
	}

	// deze initializer wordt aangeroepen als er een nieuwe Persoon wordt aangemaakt
	
	{
		personCount = 10;
	}
	// deze initializer wordt aangeroepen als er een nieuwe Persoon wordt aangemaakt,
	// maar wel na eerst bovenstaande
	{
		//personCount = 30;
	}
	
	public static enum Sport {
		BASKETBAL(false), ZWEMMEN(true), VOLLEYBAL(false), KOGELSTOTEN(true), WIELRENNEN(true), BOKSEN(true),
		JUDO(true), CROSSFIT(true), MMA(true);
		private boolean individueel;

		private Sport(boolean individueel) {
			this.individueel = individueel;
		}

		public boolean isIndividueel() {
			return individueel;
		}
	};

	//FIXME: dit moet anderes
	
	 //boolean kan eigen in 1 bit, maar java gebruikt toch een byte (8 bits)
	
	
	// byte is de kleinste geheugeneenheid binnen moderne computers
	
	
	// 0000000
	// 0000001
	// 0000010
	// 0000011
	// 0000100
	// 0000101
	// byte = 8 bits, mogelijk combinaties 2^8 = 256
	// 2 bytes = 16 bits , mogelijke combinaties 2^16 = 65536
	// 4 bytes = 32 bits, mogelijke combinaties 2^32= 4294967296
	// char = 2 bytes dus 2^16 verschillende karakters (UTF-16)
	// vroeger char 1 byte dus 2^8 characters (ASCII)
	
	
	// bit is 0 of 1
	// 0 & 0 -> 0
	// 0 & 1 -> 0
	// 1 & 0 -> 0
	// 1 & 1 -> 1
	
	// 0 | 0 -> 0
	// 0 | 1 -> 1
	// 1 | 0 -> 1
	// 1 | 1 -> 1
	
	// !1 -> 0
	// !0 -> 1
	
	
	// 0 ^ 0 -> 0
	// 1 ^ 0 -> 1
	// 0 ^ 1 -> 1
	// 1 ^ 1 -> 0
	public static void main(String[] args) {
		
		int nrElements = Sport.values().length;
		// 0, 1, 2, ... , 8
		Random random = new Random();
		int index = random.nextInt(nrElements);
		Sport s = Sport.values()[index];
		System.err.println("Sport=" + s);
		
		int a = 8;
		int b = 5;
		int c = a%b;
		int d = a/b;
		System.err.println("a=" + a++); // a=8
		
		System.err.println("a=" + a);
		System.err.println("a=" + ++a); // a=10
		
		boolean res1 = a != b; // true als a not  -> 1 operatie
		
		boolean res2 = ! (a == b);
		
		boolean result1 = a > b || c>d; // && - > only true if both are true
		// || true if one is true
		
		
		boolean result2 = a < b;
		
		
		int t = 10;
		t += -1; // t = t + -1
		t++; 
		++t;
		t = t + 1;
		
		int q = 2^8;
		
		System.err.print(1^0);
		
		
		
		
		
	}
	

}
