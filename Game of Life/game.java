import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class game {

	public static int x = 2560;
	public static int y = 1440;		
	public static int resolution = 20;
	
	public static JFrame frame = new JFrame("test");
	public static JPanel[][] cells = new JPanel[x/resolution][y/resolution];
	
	public static boolean[][] futureState = new boolean[x/resolution][y/resolution];
	
	public static void main(String[] args) {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(x,y);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.BLACK);
		
		for (int i = 0; i < x/resolution; i++) {
			for (int j = 0; j < y/resolution; j++) {
				cells[i][j] = new JPanel();
				Random option = new Random();
				cells[i][j].setVisible(option.nextBoolean()) ;
				frame.add(cells[i][j]);
				cells[i][j].setBackground(Color.WHITE);
				cells[i][j].setBounds(resolution*i+1, resolution*j+1, resolution-2, resolution-2);
			}	
		}
			
		while (true) {
			update();
			//sleep();
		}
	}
	
	public static int countNeighbours(int pos_x, int pos_y) {
		int total = 0;
		
		for (int i = pos_x-1; i < pos_x+2; i++) {
			for (int j = pos_y-1; j < pos_y+2; j++) {
				if (cells[(i + x/resolution) % (x/resolution)][(j + y/resolution) % (y/resolution)].isShowing()) total++;
			}
		}
		return cells[pos_x][pos_y].isShowing() ? --total : total;
	}
	
	public static void update() {
		for (int i = 0; i < x/resolution; i++) {
			for (int j = 0; j < y/resolution; j++) {
				futureState[i][j] = ((cells[i][j].isShowing() && countNeighbours(i,j) == 2) || (countNeighbours(i,j) == 3));
			}
		}
		
		for (int i = 0; i < x/resolution; i++) {
			for (int j = 0; j < y/resolution; j++) {
				cells[i][j].setVisible(futureState[i][j]);
			}
		}
	}
	
	public static void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
