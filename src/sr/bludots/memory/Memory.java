package sr.bludots.memory;

import java.util.HashSet;
import java.util.Scanner;

/**
 * This is an example of a memory game. The computer remembers which numbers you
 * have entered.
 * 
 * Assignment #1 (Easy): 
 * Make sure that the user cannot enter more than "10" valid, unique numbers, after that stop
 * 
 * Assignment #2 (Easy)::
 * The user can exit by entering quit or exit or stop
 * 
 * Assignment #3 (Hard)
 * Instead of entering numbers the user can enter unique words (String)
 * 
 * Assignment #4 (Hard)
 * Before starting, the users selects if he wants to use numbers or words
 */
public class Memory {

	// the HashSet (a collection which only contains unique) elements
	private HashSet<Integer> knownNumbers;

	// a counter to record how many times a user has entered a value
	private int numberOfTries;
	
	// Max number of allowed tries
	final int MAX_ALLOWED_tries = 5;


	// Constructor, to create a Memory object
	public Memory() {

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
		} while (result);
		System.out.println("You have tried " + numberOfTries + "  times.");
		System.out.println("System remembered " + knownNumbers.size() + " numbers");
	}

	/**
	 * Request input from the user and report back if it is a known number if the
	 * number is not known it is added to the memory
	 * 
	 * @return false if the user has enter quit (indicating he wants to leave)
	 */
	private boolean requestInput() {

		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		String providedText = input.next();

		boolean result;
		
			
		if (providedText.equals("quit")) {
			// the user provided an empty text, so we exit with false
			result = false;
		}
		else {
			// increase the try counter
			numberOfTries++;
			if (numberOfTries > MAX_ALLOWED_tries) {
				return false;
			}

			// now we check to see if the text reflect a number
			// in case parsing fails an exception will be thrown
			try {
				int providedNumber = Integer.parseInt(providedText);
				// since we are here, no exception has been thrown and there is a valid number

				// check if the
				if (knownNumbers.contains(providedNumber)) {
					System.out.println("Old number, you already used this number");
				} else {
					// new number, add it too the set
					knownNumbers.add(providedNumber);
					System.out.println("New number!, we are remembering this");
				}
			} catch (Exception e) {
				// look for exceptions, in this case a non valid number was entered
				System.err.println("You entered an invalid number");
			}
			result = true;
		}
		input.close();

		return result;
	}
}
