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
	
	private static Cell[][] oldMatrix;

	public static void main(String[] args) {
		theMatrix = getMatrix(CROSS_IN_A_BOX);
		populateOldMatrix();
		for (int i = 0; i < MATRIX_LENGTH; i++) {
			printTheMatrix();
			runGameOfLifeRules();
			log.info("============================================================\n");
		}
	}

	private static void runGameOfLifeRules() {
		for (int rowIndex = 0; rowIndex < MATRIX_LENGTH; rowIndex++) {
			for (int columnIndex = 0; columnIndex < MATRIX_LENGTH; columnIndex++) {
				theMatrix[rowIndex][columnIndex].willIContinueToLiveInTheMatrix(oldMatrix);
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
	
	private static void populateOldMatrix() {
		if (oldMatrix == null) {
			oldMatrix = new Cell[theMatrix.length][theMatrix.length];
		}
		for (int rowIndex = 0; rowIndex < theMatrix.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex < theMatrix.length; columnIndex++) {
				oldMatrix[rowIndex][columnIndex] = new Cell(theMatrix[rowIndex][columnIndex]);
			}
		}
	}
}