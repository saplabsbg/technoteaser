package saptechnoteaser2019.week6;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SAPTechnoTeaserWordsBruteForce {

	private static enum LetterType {
		VOWEL, CONSONANT, CONSECUTIVE_CONSONANT;	
	}

	private static final Comparator<Character> SAP_LETTER_COMPARATOR = (Character c1, Character c2) -> {
		if (c1 == 'S') {
			c1 = 'П'; //comparing САП with c2
		} else if (c2 == 'S') {
			c2 = 'С'; //comparing c1 with САП
		}
		return c1.compareTo(c2);
	};

	static private Map<Character, Integer> currentVowels = new HashMap<>(); 
	static private Map<Character, Integer> currentConsonants = new HashMap<>();

	public static void main(String[] args) {
		// initialize the vowels and the consonants
		currentVowels.put('А', 2);
		currentVowels.put('Е', 1);
		currentVowels.put('О', 1);
		currentVowels.put('И', 1);
		currentVowels.put('Ъ', 1);

		currentConsonants.put('Н', 2);
		currentConsonants.put('Т', 1);
		currentConsonants.put('Х', 1);
		currentConsonants.put('Б', 1);
		currentConsonants.put('Л', 1);
		currentConsonants.put('С', 1);
		currentConsonants.put('К', 1);
		currentConsonants.put('Ц', 1);
		currentConsonants.put('S', 1); //1 digit for САП

		long result = calculateNumberOfWords((char)0, null, 0);
		System.out.println("Number of words:" + result);		
	}

	private static long calculateNumberOfWords(char lastLetter, LetterType lastLetterType, int numberOfConsonantPairs) {

		Set<Character> availableVowels = new HashSet<>(currentVowels.keySet());
		Set<Character> availableConsonants = new HashSet<>(currentConsonants.keySet());

		if (availableVowels.isEmpty() && availableConsonants.isEmpty()) {
			// recursion base case
			return 1;		
		} 

		long result = 0; 

		if (lastLetterType != LetterType.VOWEL) {
			for(Character nextVowelChar : availableVowels) {
				int occurrencesOfNextVowel = currentVowels.get(nextVowelChar);
				if (occurrencesOfNextVowel == 1) {
					currentVowels.remove(nextVowelChar);
				} else {
					currentVowels.put(nextVowelChar, occurrencesOfNextVowel-1);
				}
				result += calculateNumberOfWords(nextVowelChar, LetterType.VOWEL, numberOfConsonantPairs);
				//revert the input before we continue 
				currentVowels.put(nextVowelChar, occurrencesOfNextVowel);
			}
		} 

		if (lastLetterType != LetterType.CONSECUTIVE_CONSONANT) {
			LetterType nextLetterType = lastLetterType==LetterType.CONSONANT ? LetterType.CONSECUTIVE_CONSONANT : LetterType.CONSONANT;

			for(Character nextConsonantChar : availableConsonants) {
				if (lastLetterType == LetterType.CONSONANT) {
					if (numberOfConsonantPairs%2 == 0 && SAP_LETTER_COMPARATOR.compare(lastLetter, nextConsonantChar) >= 0) {
						continue;
					}
					if (numberOfConsonantPairs%2 == 1 && SAP_LETTER_COMPARATOR.compare(lastLetter, nextConsonantChar) <= 0) {
						continue;
					}
				}

				int occurrencesOfNextConsonant = currentConsonants.get(nextConsonantChar);
				if (occurrencesOfNextConsonant == 1) {
					currentConsonants.remove(nextConsonantChar);
				} else {
					currentConsonants.put(nextConsonantChar, occurrencesOfNextConsonant-1);
				}

				int nextNumberOfConsonantPairs = lastLetterType==LetterType.CONSONANT ? numberOfConsonantPairs + 1 : numberOfConsonantPairs;
				if (nextConsonantChar == 'S') {
					//allow Consonant S Consonant triple
					result += calculateNumberOfWords(nextConsonantChar, LetterType.CONSONANT, nextNumberOfConsonantPairs);
				} else {
					result += calculateNumberOfWords(nextConsonantChar, nextLetterType, nextNumberOfConsonantPairs);
				}

				//revert the input before we continue 
				currentConsonants.put(nextConsonantChar, occurrencesOfNextConsonant);
			}
		}

		return result;
	}


}
