package sr.bludots.memory;

import java.util.HashSet;
import java.util.Scanner;


/** 
 * This is an example of a memory game.
 * The computer remembers which numbers you have entered.
 *
 */
public class Memory {

	// the HashSet (a collection which only contains unique) elements
	private HashSet<Integer> knownNumbers;
	
	// a counter to record how many times a user has entered a value
	private int numberOfTries;
	
	
	public static void main(String args[]) {
		Memory mem = new Memory();
		mem.runNumbers();
	}
	
	//Constructor, to create a Memory object
	public Memory () {
		
		// initialize the knownNumbers variable
		knownNumbers = new HashSet<Integer>();
		
		// initialize the counter variable
		numberOfTries = 0;
	}
	

	/**
	 * Keeps asking for numbers until the user provides quit input
	 */
	public void runNumbers() {
		boolean result;
		do {
			result = requestInput();
		}
		while (result);
		System.out.println("You have tried " + numberOfTries + "  times.");
		System.out.println("System remembered "  + knownNumbers.size() + " numbers");
	}
	
	/**
	 * Request input from the user and report back if it is a known number
	 * if the number is not known it is added to the memory
	 * 
	 * @return false if the user has enter quit (indicating he wants to leave)
	 */
	private boolean requestInput() {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		String providedText = input.next();
		
		if (providedText.equals("quit")) {
			// the user provided an empty text, so we exit with false
			return false;
		}
		
		// increase the try counter
		numberOfTries++;
		
		// now we check to see if the text reflect a number
		// in case parsing fails an exception will be thrown
		try {
			int providedNumber = Integer.parseInt(providedText);
			// since we are here, no exception has been thrown and there is a valid number
			
			// check if the 
			if (knownNumbers.contains(providedNumber)) {
				System.out.println("Old number, you already used this number");
			}
			else {
				// new number, add it too the set
				knownNumbers.add(providedNumber);
				System.out.println("New number!, we are remembering this");
			}
			return true;
		}
		catch (Exception e) {
			// look for exceptions, in this case a non valid number was entered
			System.err.println("You entered an invalid number");
		}
		return true;
	}
}
