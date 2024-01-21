package TicTacToe.display;

import javax.swing.*;

public class GameWindow {
	public GameWindow() {
		JFrame frame = new JFrame("TIC TAC TOE");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.add(new GamePanel());
	}
}