/**
 * 
 */
package com.sj.game.of.life.pojo;

import static com.sj.game.of.life.constants.LifeConstants.MATRIX_LENGTH;

import org.apache.log4j.Logger;

/**
 * @author sachinjsunny
 *
 */
public class Cell {

	private static Logger log = Logger.getLogger(Cell.class);

	private boolean alive;

	private int rowIndex;

	private int columnIndex;

	/**
	 * @param alive
	 * @param rowIndex
	 * @param columnIndex
	 */
	public Cell(boolean alive, int rowIndex, int columnIndex) {
		super();
		this.alive = alive;
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}

	/**
	 * @return the alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * @param alive
	 *            the alive to set
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * @return the rowIndex
	 */
	public int getRowIndex() {
		return rowIndex;
	}

	/**
	 * @param rowIndex
	 *            the rowIndex to set
	 */
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	/**
	 * @return the columnIndex
	 */
	public int getColumnIndex() {
		return columnIndex;
	}

	/**
	 * @param columnIndex
	 *            the columnIndex to set
	 */
	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}

	public int countLiveCellsAroundMe(Cell[][] theMatrix) {
		int numberOfAliveCellsAroundMe = 0;

		for (int row = rowIndex - 1; row <= rowIndex + 1; row++) {
			for (int column = columnIndex - 1; column <= columnIndex + 1; column++) {
				if (row >= 0 && column >= 0 && row < MATRIX_LENGTH && column < MATRIX_LENGTH
						&& theMatrix[row][column].isAlive() && !(row == rowIndex && column == columnIndex)) {
					numberOfAliveCellsAroundMe++;
				}
			}
		}

		return numberOfAliveCellsAroundMe;
	}

	public void willIContinueToLiveInTheMatrix(Cell[][] theMatrix) {
		int numberOfAliveCellsAroundMe = this.countLiveCellsAroundMe(theMatrix);
		if (numberOfAliveCellsAroundMe > 8) {
			log.debug(this.getRowIndex() + "," + this.getColumnIndex());
		}
		if (this.isAlive() && (numberOfAliveCellsAroundMe == 2 || numberOfAliveCellsAroundMe == 3)) {
			this.alive = true;
		} else if (this.isAlive() && (numberOfAliveCellsAroundMe < 2 || numberOfAliveCellsAroundMe > 3)) {
			this.alive = false;
		} else {
			this.alive = !this.isAlive() && numberOfAliveCellsAroundMe == 3;
		}
	}
}
