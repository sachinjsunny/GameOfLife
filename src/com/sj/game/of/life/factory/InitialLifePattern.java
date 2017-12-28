package com.sj.game.of.life.factory;

import static com.sj.game.of.life.constants.LifeConstants.ALL_FILLED;
import static com.sj.game.of.life.constants.LifeConstants.BOX;
import static com.sj.game.of.life.constants.LifeConstants.CROSS;
import static com.sj.game.of.life.constants.LifeConstants.CROSS_IN_A_BOX;
import static com.sj.game.of.life.constants.LifeConstants.MATRIX_LENGTH;

import com.sj.game.of.life.pojo.Cell;

/**
 * @author sachinjsunny
 *
 */
public final class InitialLifePattern {

	private InitialLifePattern() {

	}

	private static Cell[][] createAllFilledPattern() {
		Cell[][] allFilled = new Cell[MATRIX_LENGTH][MATRIX_LENGTH];

		for (int rowIndex = 0; rowIndex < MATRIX_LENGTH; rowIndex++) {
			for (int columnIndex = 0; columnIndex < MATRIX_LENGTH; columnIndex++) {
				allFilled[rowIndex][columnIndex] = new Cell(true, rowIndex, columnIndex);
			}
		}
		return allFilled;
	}

	private static Cell[][] createBoxPattern() {
		Cell[][] box = new Cell[MATRIX_LENGTH][MATRIX_LENGTH];

		for (int rowIndex = 0; rowIndex < MATRIX_LENGTH; rowIndex++) {
			for (int columnIndex = 0; columnIndex < MATRIX_LENGTH; columnIndex++) {
				if (rowIndex - 1 < 0 || columnIndex - 1 < 0 || rowIndex + 1 > 9 || columnIndex + 1 > 9) {
					box[rowIndex][columnIndex] = new Cell(true, rowIndex, columnIndex);
				} else {
					box[rowIndex][columnIndex] = new Cell(false, rowIndex, columnIndex);
				}
			}
		}
		return box;
	}

	private static Cell[][] createCrossPattern() {
		Cell[][] cross = new Cell[MATRIX_LENGTH][MATRIX_LENGTH];

		for (int rowIndex = 0; rowIndex < MATRIX_LENGTH; rowIndex++) {
			for (int columnIndex = 0; columnIndex < MATRIX_LENGTH; columnIndex++) {
				if (rowIndex == columnIndex || (rowIndex + columnIndex) == 9) {
					cross[rowIndex][columnIndex] = new Cell(true, rowIndex, columnIndex);
				} else {
					cross[rowIndex][columnIndex] = new Cell(false, rowIndex, columnIndex);
				}
			}
		}
		return cross;
	}

	private static Cell[][] createCrossInABoxPattern() {
		Cell[][] crossInABoxPattern = new Cell[MATRIX_LENGTH][MATRIX_LENGTH];

		for (int rowIndex = 0; rowIndex < MATRIX_LENGTH; rowIndex++) {
			for (int columnIndex = 0; columnIndex < MATRIX_LENGTH; columnIndex++) {
				if (rowIndex == columnIndex || (rowIndex + columnIndex) == 9
						|| (rowIndex - 1 < 0 || columnIndex - 1 < 0 || rowIndex + 1 > 9 || columnIndex + 1 > 9)) {
					crossInABoxPattern[rowIndex][columnIndex] = new Cell(true, rowIndex, columnIndex);
				} else {
					crossInABoxPattern[rowIndex][columnIndex] = new Cell(false, rowIndex, columnIndex);
				}
			}
		}
		return crossInABoxPattern;
	}

	public static Cell[][] getMatrix(String lifePatternName) {
		switch (lifePatternName) {
		case CROSS_IN_A_BOX:
			return createCrossInABoxPattern();
		case BOX:
			return createBoxPattern();
		case CROSS:
			return createCrossPattern();
		case ALL_FILLED:
		default:
			return createAllFilledPattern();
		}

	}
}
