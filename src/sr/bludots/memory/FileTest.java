package sr.bludots.memory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


/**
 *  Schrijf een programma
 *  
 *  - Dat een serie van willekeurige namen maakt en deze naar een file write.
 *  - een functie waarbij u directory listing opvraagt nadat u zelf de gebruiker om een specifieke
 *    directory naam vraagt
 *  - een functie waarbij u een file delete als deze groter is geworden dan 1000 bytes. (file.size of lenght)
 *  
 */
public class FileTest {

	
	public static void main(String args[]) {
		
		createTextFile();
	}
	
	
	public static void createTextFile() {
		
		File testFile = new File("mijntest.txt");
		File dir = new File(".");
		String[] files = dir.list();
		for (String name: files) {
			System.err.println(name);
		}
		
		try {
			FileWriter writer = new FileWriter(testFile, true);
			writer.write("Dit is een test van wat informatie\n");
			writer.close();
		}
		catch (IOException io) {
			System.err.println("Something went wrong:" + io.getMessage());
		}
	}
}
