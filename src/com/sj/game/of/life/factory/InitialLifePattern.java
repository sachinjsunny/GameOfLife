package com.sj.game.of.life.factory;

import static constants.LifeConstants.allFilled;
import static constants.LifeConstants.box;
import static constants.LifeConstants.cross;
import static constants.LifeConstants.matrixLength;
import static constants.LifeConstants.star;

public class InitialLifePattern {

	private static boolean[][] createAllFilledPattern() {
		boolean[][] allFilled = new boolean[matrixLength][matrixLength];

		for (int i = 0; i < matrixLength; i++) {
			for (int j = 0; j < matrixLength; j++) {
				allFilled[i][j] = true;
			}
		}
		return allFilled;
	}

	private static boolean[][] createBoxPattern() {
		boolean[][] box = new boolean[matrixLength][matrixLength];

		for (int i = 0; i < matrixLength; i++) {
			for (int j = 0; j < matrixLength; j++) {
				if (i - 1 < 0 || j - 1 < 0 || i + 1 > 9 || j + 1 > 9) {
					box[i][j] = true;
				}
			}
		}
		return box;
	}

	private static boolean[][] createCrossPattern() {
		boolean[][] cross = createBoxPattern();

		for (int i = 0; i < matrixLength; i++) {
			for (int j = 0; j < matrixLength; j++) {
				if (i == j || (i + j) == 9) {
					cross[i][j] = true;
				}
			}
		}
		return cross;
	}

	private static boolean[][] createStarPattern() {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean[][] getLifePattern(String lifePatternName) {
		switch (lifePatternName) {
		case star:
			return createStarPattern();
		case box:
			return createBoxPattern();
		case cross:
			return createCrossPattern();
		case allFilled:
		default:
			return createAllFilledPattern();
		}

	}
}
