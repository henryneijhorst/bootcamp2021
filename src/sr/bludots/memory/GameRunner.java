package sr.bludots.memory;

import java.util.ArrayList;
import java.util.List;

import sr.bludots.memory.Game.Category;
import sr.bludots.memory.Game.Level;

public class GameRunner  {
	
	
	
	public static void main(String args[]) throws Exception {
		
		List <Game> games = new ArrayList<Game>();
		games.add(new Game("Grand Theft", Category.ADVENTURE, Level.MODERATE));
		games.add(new Game("FIFA 2020", Category.SPORT, Level.MODERATE));
		games.add(new OnlineGame("World of warcraft", Category.ADVENTURE, Level.DIFFICULT, "http://www.worldcraft.com"));

		for (Game game : games) {
			//System.out.println(game);
		}
		
		OnlineGame a = new OnlineGame("Tetris", Category.ADVENTURE, Level.DIFFICULT, "http://www.tetris.com");
		Game b = new Game("Just dance", Category.SPORT, Level.MODERATE);
		
		
		Game c = a;
		
		Animal animal = new Animal();
		Paard paard = new Paard();
		Koe koe  = new Koe();
		
		Animal a2 = paard;
		Animal a3 = koe;
		
		test(0);
		
	}

	
	public static void test(int a)   {
		
		try {
			int b = 10/a;
			System.out.println("hallo hier zijn we " + b);

		}
		catch (Exception e) {
			System.err.println("Sorry dit doen we niet");
		}
		
	}
}
