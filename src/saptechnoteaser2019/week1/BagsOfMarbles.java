package saptechnoteaser2019.week1;
import java.util.Random;

public class BagsOfMarbles {

	private static enum MarbleType {VALUABLE, NOT_VALUABLE}; 

	private static final int NUMBER_OF_EXPERIMENTS = 10000; 

	public static void main(String[] args) {
		MarbleType[][] boxesExperiment1 = {
				{MarbleType.VALUABLE, MarbleType.VALUABLE},
				{MarbleType.VALUABLE, MarbleType.VALUABLE},
				{MarbleType.VALUABLE, MarbleType.NOT_VALUABLE},
				{MarbleType.VALUABLE, MarbleType.NOT_VALUABLE},
				{MarbleType.VALUABLE, MarbleType.NOT_VALUABLE},
				{MarbleType.VALUABLE, MarbleType.NOT_VALUABLE},
				{MarbleType.NOT_VALUABLE, MarbleType.NOT_VALUABLE},
				{MarbleType.NOT_VALUABLE, MarbleType.NOT_VALUABLE}
		};
		performExperiment("2 boxes with 2 valuable marbles, 4 boxes with 1 valuable marble", boxesExperiment1);

		MarbleType[][] boxesExperiment2 = {
				{MarbleType.VALUABLE, MarbleType.VALUABLE},
				{MarbleType.VALUABLE, MarbleType.VALUABLE},
				{MarbleType.VALUABLE, MarbleType.VALUABLE},
				{MarbleType.VALUABLE, MarbleType.VALUABLE},
				{MarbleType.VALUABLE, MarbleType.NOT_VALUABLE},
				{MarbleType.VALUABLE, MarbleType.NOT_VALUABLE},
				{MarbleType.VALUABLE, MarbleType.NOT_VALUABLE},
				{MarbleType.VALUABLE, MarbleType.NOT_VALUABLE}
		};
		performExperiment("4 boxes with 2 valuable marbles, 4 boxes with 1 valuable marble", boxesExperiment2);
	}


	private static void performExperiment(String experimentName, MarbleType[][] boxes) {
		Random randomGenerator = new Random();

		int winningPositionCount = 0;
		int notWinningPositionCount = 0;
		int experiment = 0;		
		while (experiment < NUMBER_OF_EXPERIMENTS) {
			int boxIndex = randomGenerator.nextInt(boxes.length);
			MarbleType[] box = boxes[boxIndex];
			int firstMarbleIndex = randomGenerator.nextInt(2); 
			MarbleType marble = box[firstMarbleIndex];
			if (marble != MarbleType.VALUABLE) {
				continue;
			}

			int secondMarbleIndex = firstMarbleIndex == 0 ? 1 : 0;
			if (box[secondMarbleIndex] == MarbleType.VALUABLE) {
				winningPositionCount++;
			} else {
				notWinningPositionCount++;
			}
			experiment++;
		}

		System.out.println(experimentName + ":");
		System.out.println("\t Winning: " + winningPositionCount + "; ");
		System.out.println("\t Not winning: " + notWinningPositionCount + "; ");
		float percentOfWinningPositions = (float)winningPositionCount / NUMBER_OF_EXPERIMENTS * 100;
		System.out.println(String.format("\t ~ %.2f%% of the positions are winning", percentOfWinningPositions));
	}

}
