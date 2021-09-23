package sr.bludots.memory;

public class OnlineGame extends Game {

	protected String website;
	
	public OnlineGame(String title, Category category, Level level, String website) {
		super(title, category, level);
		this.website = website;
	}
	
	public String toString() {
		return "ik doe wat ik wil, ga naar website " + website + ", titel=" + title;
	}

}
