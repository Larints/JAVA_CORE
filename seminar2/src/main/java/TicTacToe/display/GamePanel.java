package TicTacToe.display;

import TicTacToe.core.GameCore;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
	private GameCore core;

	public GamePanel() {
		core = new GameCore();
		GridLayout grid = new GridLayout(3, 3, 2, 2);
		setLayout(grid);
		for (int i = 0; i < 9; i++) {
			Cell currentCell = new Cell(i, core);
			add(currentCell);
			core.addCell(i, currentCell);
		}
		core.fillCells();
		core.printField();
	}
}