package textGames;

public class Island {
	private Land[][] island;
	private int size;
	
	public Island(int size) {
		this.size = size;
		island = new Land[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				island[i][j] = new Land();
			}
		}
	}
	
	public Chest dig(int x, int y) {
		return island[x - 1][y - 1].dig();
	}
	
	public void buryTreasure(Chest chest, int x, int y) {
		System.out.println("Burying treasure at: " + x + ", " + y);
		island[x][y].buryTreasure(chest);
	}
	
	public String toString() {
		String map = "";
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map += island[i][j].toString();
			}
			map += "\n";
		}
		return map;
	}
}
