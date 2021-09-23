package sr.bludots.memory;


/* 
 * Deze class defineert een game
 * 
 */

public class Game {

	public static enum Category {
		SPORT, ADVENTURE, ACTION, BOARD
	}
	public static enum Level {
		EASY, MODERATE, DIFFICULT
	}
	
	
	protected String title;
	protected Category category;
	protected Level level;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public Game(String title, Category category, Level level) {
		super();
		this.title = title;
		this.category = category;
		this.level = level;
	}
	
	public String toString() {
		return "Dit is game " + title;
	}
}
