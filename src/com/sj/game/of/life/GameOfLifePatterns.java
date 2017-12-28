package com.sj.game.of.life;

import static com.sj.game.of.life.constants.LifeConstants.CROSS_IN_A_BOX;
import static com.sj.game.of.life.constants.LifeConstants.MATRIX_LENGTH;
import static com.sj.game.of.life.factory.InitialLifePattern.getMatrix;

import org.apache.log4j.Logger;

import com.sj.game.of.life.pojo.Cell;

/**
 * @author sachinjsunny
 *
 */
public class GameOfLifePatterns {

	private static Logger log = Logger.getLogger(GameOfLifePatterns.class);

	private static Cell[][] theMatrix;

	public static void main(String[] args) {
		theMatrix = getMatrix(CROSS_IN_A_BOX);
		for (int i = 0; i < MATRIX_LENGTH; i++) {
			printTheMatrix();
			runGameOfLifeRules();
			log.info("============================================================\n");
		}
	}

	private static void runGameOfLifeRules() {
		for (int rowIndex = 0; rowIndex < MATRIX_LENGTH; rowIndex++) {
			for (int columnIndex = 0; columnIndex < MATRIX_LENGTH; columnIndex++) {
				theMatrix[rowIndex][columnIndex].willIContinueToLiveInTheMatrix(theMatrix);
			}
		}
	}

	private static void printTheMatrix() {
		for (int rowIndex = 0; rowIndex < MATRIX_LENGTH; rowIndex++) {
			for (int columnIndex = 0; columnIndex < MATRIX_LENGTH; columnIndex++) {
				if (columnIndex > 0) {
					log.info(",");
				}
				log.info(theMatrix[rowIndex][columnIndex].isAlive());
			}
			log.info("\n");
		}
	}
}