package textGames;

class Land {
	private Chest burriedTreasure;
	private boolean state;
	
	public Land() {
		state = false;
	}
	
	public void buryTreasure (Chest treasure) {
		burriedTreasure = treasure;
	}
	
	public Chest dig() {
		state = true;
		return burriedTreasure;
	}
	
	public String toString() {
		if (state) {
			if (burriedTreasure != null) {
				return "~<#>~";
			}
			return "~   ~";
		}
		return "~~~~~";
	}
}