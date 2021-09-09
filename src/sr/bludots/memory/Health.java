package sr.bludots.memory;

import java.util.Random;
import java.util.Scanner;

public class Health {

	public static enum sport {
		weightlifting, swimming, jogging, cycling;
	}

	public static void main(String[] args) {
		double height = 0;
		double weight = 0;
		double bmi = 0;

		String[] duur = new String[] { "15", "20", "30", "45", "60" };

		Scanner input = new Scanner(System.in);

		System.out.println("Enter your height(cm): ");
		height = input.nextDouble();

		System.out.println("Enter your weight(kg): ");
		weight = input.nextDouble();
		input.close();
		
		if (height == 0) {
			System.err.println("Sorry verkeerd");
			return;
		}
		bmi = height == 0? 0 : weight / (height * height);

		// CHOOSE RANDOM SPORT
		Random random = new Random();
		int chooseSport = random.nextInt(sport.values().length);
		int chooseSport2 = random.nextInt(sport.values().length);

		// CHOOSE DURATION OF SPORT
		int duration = random.nextInt(duur.length);
		int duration2 = random.nextInt(duur.length);

		if (bmi < 18.5) {
			System.out.println("You are underweight");
			System.out.println("Advised activity: ");
			System.out.println(sport.values()[chooseSport] + " for " + duur[duration] + " minutes per day");

		} else if ((bmi >= 18.5) & (bmi < 25)) {
			System.out.println("You are very healthy");
			System.out.println("Advised activity: ");
			System.out.println(sport.values()[chooseSport] + " for " + duur[duration] + " minutes per day");

		} else if ((bmi >= 25) & (bmi < 30)) {
			System.out.println("You are very overweight");
			System.out.println("Advised activity: ");
			System.out.println(sport.values()[chooseSport] + " for " + duur[duration] + " minutes per day");
			System.out.println(sport.values()[chooseSport2] + " for " + duur[duration2] + " minutes per day");

		} 
		else if (bmi >= 30) {
			System.out.println("You are obese");
			System.out.println("Advised activity: ");
			System.out.println(sport.values()[chooseSport] + " for " + duur[duration] + " minutes per day");
			System.out.println(sport.values()[chooseSport2] + " for " + duur[duration2] + " minutes per day");

		}
		else {
			/// ???
			System.err.println("Vreemd dit mag niet");
			
		}
		
	}

}
