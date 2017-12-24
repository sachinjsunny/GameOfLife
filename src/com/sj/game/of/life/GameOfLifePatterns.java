package com.sj.game.of.life;

import static com.sj.game.of.life.factory.InitialLifePattern.getLifePattern;
import static constants.LifeConstants.*;
import static constants.LifeConstants.matrixLength;

import org.apache.log4j.Logger;

public class GameOfLifePatterns {
	
	private static Logger log = Logger.getLogger(GameOfLifePatterns.class);

	private static boolean[][] lifePattern;

	private static boolean[][] oldPattern;

	public static void main(String[] args) {
		lifePattern = getLifePattern(cross);
		oldPattern = getLifePattern(cross);
		for (int i = 0; i < 10; i++) {
			printLifeArray();
			runGameOfLifeRules();
			log.info("========================\n");
			replaceOldPattern();
		}
	}

	private static void replaceOldPattern() {
		for (int i = 0; i < matrixLength; i++) {
			for (int j = 0; j < matrixLength; j++) {
				oldPattern[i][j] = lifePattern[i][j];
			}
		}
	}

	private static void runGameOfLifeRules() {
		for (int i = 0; i < matrixLength; i++) {
			for (int j = 0; j < matrixLength; j++) {
				lifePattern[i][j] = isCellAlive(i, j);
			}
		}
	}

	private static boolean isCellAlive(int i, int j) {
		int numberOfAliveCellsAroundMe = getAliveCellsAroundMe(i, j);
		if(numberOfAliveCellsAroundMe>8){
			log.info(i + ","+ j);
		}
		if (lifePattern[i][j]
				&& (numberOfAliveCellsAroundMe == 2 || numberOfAliveCellsAroundMe == 3)) {
			return true;
		} else if (lifePattern[i][j]
				&& (numberOfAliveCellsAroundMe < 2 || numberOfAliveCellsAroundMe > 3)) {
			return false;
		} else if (!lifePattern[i][j] && numberOfAliveCellsAroundMe == 3) {
			return true;
		} else {
			return false;
		}
	}

	private static int getAliveCellsAroundMe(int i, int j) {
		int numberOfAliveCellsAroundMe = 0;

		for (int row = i - 1; row <= i + 1; row++) {
			for (int column = j - 1; column <= j + 1; column++) {
				if (row >= 0 && column >= 0 && row < matrixLength
						&& column < matrixLength && lifePattern[row][column]
						&& !(row == i && column == j)) {
					numberOfAliveCellsAroundMe++;
				}
			}
		}

		return numberOfAliveCellsAroundMe;
	}

	private static void printLifeArray() {
		for (int i = 0; i < matrixLength; i++) {
			for (int j = 0; j < lifePattern[i].length; j++) {
				if (j > 0) {
					log.info(",");
				}
				log.info(lifePattern[i][j]);
			}
			log.info("\n");
		}
	}
}