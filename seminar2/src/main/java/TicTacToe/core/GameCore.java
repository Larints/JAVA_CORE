package TicTacToe.core;

import TicTacToe.display.Cell;
import TicTacToe.display.CellState;

import java.util.ArrayList;
import java.util.Random;

public class GameCore {
	private Cell[] gameData;
	private boolean isPlayerChoice;
	private boolean firstChoice = true;
	ArrayList<Cell[]> cells = new ArrayList<Cell[]>();

	public GameCore() {
		gameData = new Cell[9];
		isPlayerChoice = true;
	}

	public void addCell(int index, Cell c) {
		gameData[index] = c;
	}

	public void printField() {
		int current = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(gameData[current++].getCellState() + "  ");
			}
			System.out.println();
		}
	}

	public void updateData(int lastIndex) {
		isPlayerChoice = false;
		firstChoice = false;
		robotChoice(lastIndex);
	}

	public void robotChoice(int lastIndex) {
		if (!isPlayerChoice) {
			for (Cell[] c : cells) {
				switch (sumCells(c)) {
				case 2 -> {
					for (Cell cell : c) {
						if (cell.getCellState() == CellState.EMPTY) {
							cell.machineChoiceRender();
							return;
						}
					}
				}
				case 3 -> victory();
				case 4 -> {
					for (Cell cell : c) {
						if (cell.getCellState() == CellState.EMPTY) {
							cell.machineChoiceRender();
							defeat();
							return;
						}
					}
				}
				case 6 -> defeat();
				}
			}
			Random rnd = new Random();
			int n = rnd.nextInt(9);
			for (int i = 0; i < 30; i++) {
				if (gameData[n].getCellState() == CellState.EMPTY) {
					gameData[n].machineChoiceRender();
					return;
				} else {
					n = rnd.nextInt(9);
				}
			}
		}
	}

	public void victory() {
		System.out.println("Victory");
	}

	public void defeat() {
		System.out.println("Defeat");
	}

	private int sumCells(Cell[] c) {
		int countCross = 0;
		int countZero = 0;
		for (Cell cell : c) {
			if (cell.getCellState() == CellState.CROSS) {
				countCross += cell.getCellState();
			} else if (cell.getCellState() == CellState.ZERO) {
				countZero += cell.getCellState();
			}
		}
		if (countCross == 2 | countCross == 3) {
			return countCross;
		}
		if (countZero == 4 | countZero == 6) {
			return countZero;
		}
		return countCross;
	}

	public void fillCells() {
		cells.add(new Cell[] { gameData[0], gameData[1], gameData[2] });
		cells.add(new Cell[] { gameData[3], gameData[4], gameData[5] });
		cells.add(new Cell[] { gameData[6], gameData[7], gameData[8] });
		cells.add(new Cell[] { gameData[0], gameData[3], gameData[6] });
		cells.add(new Cell[] { gameData[1], gameData[4], gameData[7] });
		cells.add(new Cell[] { gameData[2], gameData[5], gameData[8] });
		cells.add(new Cell[] { gameData[0], gameData[4], gameData[8] });
		cells.add(new Cell[] { gameData[2], gameData[4], gameData[6] });
	}
}