package sr.bludots.memory;

public class Launcher {
	
	public static void main(String args[]) {
		String a8 = "abcdefgh";
		String a9 = "abcdefGh";
		int nrTries = 0;
		
		
		int a1= 1;
		int a2 = 2;
		
		//a8 = a8 + "gh";
		
		System.err.println("A8=" + a8 + "   en A9=" + a9);
		
		String a9lower = a9.toLowerCase();
		
		if (a8.equalsIgnoreCase(a9)) {
			System.err.println("gelijk");
		}
		else {
			System.err.println("ongelijk " );
		}
		Memory mem = new Memory();
		//mem.runNumbers();
		
		if (nrTries  > 10) {
			//stop
		}
	}

	
}
