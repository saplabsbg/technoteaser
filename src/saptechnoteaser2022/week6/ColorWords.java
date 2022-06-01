package saptechnoteaser2022.week6;

import java.util.Random;

/* 
 * <h1>Color words</h1>
 * SAPTechnoteaser 2022, Week6, Question1
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2022/#week6,question1">Description and explanation</a>
 */ 
public class ColorWords {

	private static final int WORD_LENGTH_LIMIT = 100;
	private static final int CHECKS_PER_WORD_LENGTH = 1000;
	
	public static void main(String[] args) {
		for (int i = 11; i < WORD_LENGTH_LIMIT; i++) {
			if (checkRuleForWordLength(i)) {
				System.out.println("Shortcut rule seems to work for words with length " + i);
			}
		}
	}
	
	private static boolean checkRuleForWordLength (int wordLength) {
		for (long i = 0; i < CHECKS_PER_WORD_LENGTH; i++) {
			int[] wordChars = new int[wordLength];			
			for (int j = 0; j < wordChars.length; j++) {
				wordChars[j] = new Random().nextInt(3);
			}
			
			if (!checkWord(wordChars)) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkWord(int[] word) {
		int expectedResult = applyRule (word[0], word[word.length-1]);
		int actualResult = reduceWord(word);
		return expectedResult == actualResult;
	}

	private static int applyRule (int c1, int c2) {
		return (6 - c1 - c2) % 3;
	}
	private static int reduceWord (int word[]) {
		if (word.length == 2) {
			return applyRule(word[0], word[1]);
		}
		int reducedWord[] = new int[word.length-1];
		for (int i=0; i<word.length-1; i++) {
			reducedWord[i] = applyRule(word[i], word[i+1]);
		}
		return reduceWord(reducedWord);
	}
}
