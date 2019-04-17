package saptechnoteaser2019.week6;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SAPTechnoTeaserWords {

	private static final Comparator<Character> SAP_LETTER_COMPARATOR = (Character c1, Character c2) -> {
		if (c1 == 'S') {
			c1 = 'П'; //comparing САП with c2
		} else if (c2 == 'S') {
			c2 = 'С'; //comparing c1 with САП
		}
		return c1.compareTo(c2);
	};

	static private Map<Character, Integer> inputOfConsonants = new HashMap<Character, Integer>();

	public static void main(String[] args) {

		inputOfConsonants.put('Н', 2);
		inputOfConsonants.put('Т', 1);
		inputOfConsonants.put('Х', 1);
		inputOfConsonants.put('Б', 1);
		inputOfConsonants.put('Л', 1);
		inputOfConsonants.put('С', 1);
		inputOfConsonants.put('К', 1);
		inputOfConsonants.put('Ц', 1);
		inputOfConsonants.put('S', 1);

		long result = buildResult(3, true, 7);
		System.out.println("Options for the consonants with 3 pairs:" + result);
		long resultFor4Pairs =  buildResult(4, true, 6);
		System.out.println("Options for the consonants with 4 pairs:" + resultFor4Pairs);
		result += 2*resultFor4Pairs;
		long resultFor5Pairs =  buildResult(5, true, 5);
		System.out.println("Options for the consonants with 5 pairs:" + resultFor5Pairs);
		result += resultFor5Pairs;
		System.out.println("Options for the consonants:" + result);
		//result = result*6!/2!
		result *= 3*4*5*6;
		System.out.println("Result:" + result);

	}

	private static long buildResult(int numberOfConsonantPairsInResult, boolean nextPairIsInAscOrder, int numberOfPositions) {
		if (numberOfPositions == 0 && inputOfConsonants.size() == 0) {
			// recursion base case
			return 1;
		}

		if (inputOfConsonants.size() > numberOfPositions*2 + 1) {
			// recursion base case
			return 0;
		}  

		long result = 0;

		Set<Character> availableConsonants = new HashSet<>(inputOfConsonants.keySet());
		for(Character nextConsonantChar : availableConsonants) {
			int occurrencesOfNextConsonant = inputOfConsonants.get(nextConsonantChar);
			if (occurrencesOfNextConsonant == 1) {
				inputOfConsonants.remove(nextConsonantChar);
			} else {
				inputOfConsonants.put(nextConsonantChar, occurrencesOfNextConsonant-1);
			}		

			result += buildResult(numberOfConsonantPairsInResult, nextPairIsInAscOrder, numberOfPositions-1);

			if (numberOfConsonantPairsInResult > 0) {
				Set<Character> availableConsonantsForPair = new HashSet<>(inputOfConsonants.keySet());
				for (Character nextConsonantCharForPair : availableConsonantsForPair) {
					if (nextPairIsInAscOrder && SAP_LETTER_COMPARATOR.compare(nextConsonantChar, nextConsonantCharForPair) >= 0) {
						continue;
					}
					if (!nextPairIsInAscOrder && SAP_LETTER_COMPARATOR.compare(nextConsonantChar, nextConsonantCharForPair) <= 0) {
						continue;
					}

					int occurrencesOfNextCharForPair = inputOfConsonants.get(nextConsonantCharForPair);
					if (occurrencesOfNextCharForPair == 1) {
						inputOfConsonants.remove(nextConsonantCharForPair);
					} else {
						inputOfConsonants.put(nextConsonantCharForPair, occurrencesOfNextCharForPair-1);
					}

					result += buildResult(numberOfConsonantPairsInResult-1, !nextPairIsInAscOrder, numberOfPositions-1);

					// case Consonant S Consonant 
					if (nextConsonantCharForPair == 'S' && numberOfConsonantPairsInResult > 1) {
						Set<Character> availableConsonantsForSecondPair = new HashSet<>(inputOfConsonants.keySet());
						for (Character nextConsonantCharForSecondPair : availableConsonantsForSecondPair) {
							if (!nextPairIsInAscOrder && SAP_LETTER_COMPARATOR.compare(nextConsonantCharForPair, nextConsonantCharForSecondPair) >= 0) {
								continue;
							}
							if (nextPairIsInAscOrder && SAP_LETTER_COMPARATOR.compare(nextConsonantCharForPair, nextConsonantCharForSecondPair) <= 0) {
								continue;
							}
							int occurrencesOfNextCharForSecondPair = inputOfConsonants.get(nextConsonantCharForSecondPair);

							if (occurrencesOfNextCharForSecondPair == 1) {
								inputOfConsonants.remove(nextConsonantCharForSecondPair);
							} else {
								inputOfConsonants.put(nextConsonantCharForSecondPair, occurrencesOfNextCharForSecondPair-1);
							}
							result += buildResult(numberOfConsonantPairsInResult-2, nextPairIsInAscOrder, numberOfPositions-1);

							//revert the input before we continue - case Consonant S Consonant
							inputOfConsonants.put(nextConsonantCharForSecondPair, occurrencesOfNextCharForSecondPair);
						}
					}

					//revert the input before we continue - Consonant Pair
					inputOfConsonants.put(nextConsonantCharForPair, occurrencesOfNextCharForPair);
				}
			}
			//revert the input before we continue - Consonant
			inputOfConsonants.put(nextConsonantChar, occurrencesOfNextConsonant);
		}

		return result;
	}
}

