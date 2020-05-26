package saptechnoteaser2020.week6;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/* 
 * <h1>Weird Numbers</h1>
 * SAPTechnoteaser 2020, Week6, Question2
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2020/#week6,question2">Description and explanation</a>
 * 
 */
public class WeirdNumberGenerator {

	private static final int WANTED_INDEX = 15000;
	
	private Hashtable<Integer, List<Integer>> numberDivisors = new Hashtable<>();
	private int currentWeirdNumber = 1;
	
	public static void main(String[] args) {
		
		WeirdNumberGenerator weirdNumberGenerator = new WeirdNumberGenerator();
		int currentIndex; 
		for (currentIndex=1; currentIndex<WANTED_INDEX; currentIndex++) {
			weirdNumberGenerator.getNextWeirdNumber();
		}
		System.out.println(currentIndex + ": " + weirdNumberGenerator.getNextWeirdNumber());

	}

	public int getNextWeirdNumber() {
		boolean isCurrentNumberWeird = false; 
		while (!isCurrentNumberWeird) {
			currentWeirdNumber++;
			int currentNumberSumOfDivisors = 1;
			List<Integer> divisors = numberDivisors.remove(currentWeirdNumber);
			
			if (divisors != null) {			
				for (int i : divisors) {
					currentNumberSumOfDivisors += i;
					addDivisorForNumber(currentWeirdNumber + i , i);
				} 
				if (currentNumberSumOfDivisors > currentWeirdNumber) {
					divisors.add(1);
					isCurrentNumberWeird =  isWeird(currentWeirdNumber, divisors, currentNumberSumOfDivisors); // isPalindrome(currentWeirdNumber) &&
				}
			}
			if (2*currentWeirdNumber < 0) {
				System.out.println("integer overflow");
				System.exit(0);
			}
			addDivisorForNumber(2*currentWeirdNumber, currentWeirdNumber);
		}
		return currentWeirdNumber;
	}
	
	private boolean isWeird(int number, List<Integer> divisors, int divisorsSum) {
		int biggestDivisor = divisors.get(0);
		if (biggestDivisor == number) {
			return false;
		} else if (biggestDivisor > number) {			
			if (divisorsSum - biggestDivisor < number) {
				//biggestDivisor > number but without it the sum of all other divisors is < number
				return true;
			}
			divisors.remove(0);
			return isWeird(number, divisors, divisorsSum - biggestDivisor);
		} else if (divisorsSum - biggestDivisor == number) {
			return false;
		} else if (divisorsSum - biggestDivisor < number) { 
			//the sum of all dividers without the biggest one is less than the number -> the biggest divider must be part of the sum
			divisors.remove(0);
			return isWeird(number - biggestDivisor, divisors, divisorsSum - biggestDivisor);
			
		} 
		// without optimization: PT29.955S
		
		return !canFindExactSum(number, divisors, 0);
	}
	
	private boolean canFindExactSum(int sum, List<Integer> numbers, int fromIndex) {
		Integer firstNumber = numbers.get(fromIndex);
		if (firstNumber == sum) {
			return true;
		} else if (fromIndex == numbers.size() - 1) {
			return false;
		}
		
		if (sum - firstNumber > 0) {
			// either use or skip the first divisor
			return canFindExactSum(sum - firstNumber, numbers, fromIndex+1) || canFindExactSum(sum, numbers, fromIndex+1);
		} else {
			return canFindExactSum(sum, numbers, fromIndex+1);
		}
	}
	
	private void addDivisorForNumber (int number, int divisor) {
		if (numberDivisors.containsKey(number)) {
			numberDivisors.get(number).add(divisor);
		} else {
			List<Integer> divisors = new ArrayList<>();
			divisors.add(divisor);
			numberDivisors.put(number, divisors);
		}
	}


}
