package TicTacToe.display;

import TicTacToe.core.GameCore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cell extends JPanel {
	private GameCore gc; // TODO Ссылка для отладки, потом удалить
	private int cellIndex;
	private int cellState = 0;

	public Cell(int cellIndex, GameCore gc) {
		this.gc = gc;
		this.cellIndex = cellIndex;
		setSize(200, 200);
		cellState = CellState.EMPTY;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mouseClicked(e);
				if (isEmpty()) {
					playerChoiceRender();
					gc.updateData(cellIndex); // TODO потом удалить
				}
			}
		});
		setBorder(BorderFactory.createLineBorder(getForeground()));
	}

	public void playerChoiceRender() {
		Graphics g = getGraphics();
		g.drawLine(0, 0, getWidth(), getHeight());
		g.drawLine(0, getHeight(), getWidth(), 0);
		cellState = CellState.CROSS;
	}
	public void machineChoiceRender() {
		int scale = 15; // TODO потом удалить
		Graphics g = getGraphics();
		g.drawOval(0+scale, 0+scale, getWidth()-scale*2, getHeight()-scale*2);
		cellState = CellState.ZERO;
	}

	public int getCellState() {
		return cellState;
	}

	public void setCellState(int cellState) {
		this.cellState = cellState;
	}

	public boolean isEmpty() {
		return cellState == CellState.EMPTY;
	}
}