package textGames;

public class Chest {
	private int gold;
	
	public Chest(int gold) {
		this.gold = gold;
	}
	
	public int getContents() {
		int contents = gold;
		gold = 0;
		return contents;
	}
}
