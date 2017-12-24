package com.sj.game.of.life;

import static com.sj.game.of.life.factory.InitialLifePattern.getMatrix;
import static constants.LifeConstants.CROSS;
import static constants.LifeConstants.MATRIX_LENGTH;

import org.apache.log4j.Logger;

import com.sj.game.of.life.pojo.Cell;

/**
 * @author sachinjsunny
 *
 */
public class GameOfLifePatterns {

	private static Logger log = Logger.getLogger(GameOfLifePatterns.class);

	private static Cell[][] theMatrix;

	private static Cell[][] theMatrixReturns;

	public static void main(String[] args) {
		theMatrix = getMatrix(CROSS);
		theMatrixReturns = getMatrix(CROSS);
		for (int i = 0; i < 10; i++) {
			printLifeArray();
			runGameOfLifeRules();
			log.info("============================================================\n");
			replaceOldPattern();
		}
	}

	private static void replaceOldPattern() {
		for (int i = 0; i < MATRIX_LENGTH; i++) {
			for (int j = 0; j < MATRIX_LENGTH; j++) {
				theMatrixReturns[i][j] = theMatrix[i][j];
			}
		}
	}

	private static void runGameOfLifeRules() {
		for (int i = 0; i < MATRIX_LENGTH; i++) {
			for (int j = 0; j < MATRIX_LENGTH; j++) {
				Cell currentCell = theMatrix[i][j];
				currentCell.setAlive(currentCell.willIContinueToLive(theMatrix));
			}
		}
	}

	private static void printLifeArray() {
		for (int i = 0; i < MATRIX_LENGTH; i++) {
			for (int j = 0; j < theMatrix[i].length; j++) {
				if (j > 0) {
					log.info(",");
				}
				log.info(theMatrix[i][j].isAlive());
			}
			log.info("\n");
		}
	}
}