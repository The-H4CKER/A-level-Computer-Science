package textGames;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HiddenTreasure {

	private static Location[][] island = new Location[10][10];
	private static Scanner scan = new Scanner(System.in);
	private static Random rand = new Random();
	private static final int SIZE = 10;
	
	public static void main(String[] args) {
		generateIsland();
		System.out.println("Hidden Treasure\n"
				+ "Pirates have hidden treasure on an island which are split into a 10 by 10 grid. \n"
				+ "Your mission is to find a treasure by guessing where the treasure is by entering x and y coordinates.");
		
		boolean gameOver = false;
		while (!gameOver) {
			int x = getCoordinate("x");
			int y = getCoordinate("y");
			if (island[y][x] == Location.TREASURE) {
				island[y][x] = Location.FOUNDTREASURE;
				gameOver = true;
			} else if (island[y][x] == Location.UNCHECKED) {
				island[y][x] = Location.EMPTY;
			}
			System.out.println(getMap());		
		}
		System.out.println("Well done, you found the treasure!");
	}
	
	private static String getMap() {
		String map = "";
		for (Location[] line : island) {
			for (Location location : line) {
				switch (location) {
					case EMPTY:
						map += " Empty\t";
						break;
					case FOUNDTREASURE:
						map += " Found\t";
						break;
					default:
						map += "   ###\t";
				}
			}
			map += "\n";
		}
		return map;
	}
	
	private static void generateIsland() {
		for (int i = 0; i < SIZE; i++) Arrays.fill(island[i], Location.UNCHECKED);
		island[rand.nextInt(SIZE)][rand.nextInt(SIZE)] = Location.TREASURE;
	}
	
	private static int getCoordinate(String axis) {
		int coordinate;	
		while (true) {	
			System.out.println("Enter " + axis + " coordinate: ");
			if (scan.hasNextInt()) {
				coordinate = scan.nextInt() - 1;
				if (coordinate >= 0 && coordinate < SIZE) return coordinate;
			}
			System.out.println("Please enter a number between 1 and " + SIZE);
			scan.nextLine();
		}
	}
	
	enum Location {
		EMPTY,
		TREASURE,
		UNCHECKED,
		FOUNDTREASURE
	}
}
