package textGames;

import java.util.Random;
import java.util.Scanner;

public class HiddenTreasureOO {

	private static Random rand = new Random();
	private static Scanner scan = new Scanner(System.in);
	
	private static Island island;
	private static final int SIZE = 10;
	
	public static void main(String[] args) {
		island = new Island(SIZE);
		Chest chest = new Chest(rand.nextInt(1000));
		island.buryTreasure(chest, rand.nextInt(SIZE), rand.nextInt(SIZE));
		
		System.out.println("Hidden Treasure\n"
				+ "Pirates have hidden treasure on an island, the island is split evenly into a " 
				+ SIZE + " by " + SIZE + "grid.\n"
				+ "Your mission is to find the treasure, each turn will enter x and y coordinates identifying where you plan to dig.\n"
				+ "After each turn a map will be displayed showing your progress.");
		Chest found;
		while (true) {
			int x = getInput("X coordinate");
			int y = getInput("Y coordinate");
			found = island.dig(x, y);
			System.out.println(island.toString());
			if (found != null) {
				System.out.println("You found the treasure chest!");
				System.out.println("Inside you found " + chest.getContents() + " gold coins!");
				break;
			}
		}
		scan.close();
	}
	
	private static int getInput(String label) {
		while (true) {
			System.out.println("Please enter " + label);
			if (scan.hasNextInt()) {
				return scan.nextInt();
			} else {
				scan.nextLine();
			}
		}
	}
}
