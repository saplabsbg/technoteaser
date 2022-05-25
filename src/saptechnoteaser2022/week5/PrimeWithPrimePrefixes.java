package saptechnoteaser2022.week5;

/* 
 * <h1>Inequalities</h1>
 * SAPTechnoteaser 2022, Week5, Question1
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2022/#week5,question1">Description and explanation</a>
 * @author Добромир Кралчев
 */ 
public class PrimeWithPrimePrefixes {

	private static final int[] SINGLE_DIGIT_PRIMES = {2, 3, 5, 7};
	private static final int[] POSSIBLE_LAST_DIGITS = {1, 3, 7, 9};
	private static final String IDENTATION = "    "; 
	
	private static boolean isPrime(int num) {
		
		for (int i = 2; i * i <= num; ++i) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static void printPrimeWithIdent(int n) {
		
		int ident = Integer.toString(n).length();
		for (int i = 1; i < ident; i++) {
			System.out.print(IDENTATION);
		}
		System.out.println(n);
	}


	private static int findPrimes(int currentNumber) {

		if (isPrime(currentNumber)) {
			
			printPrimeWithIdent(currentNumber);
			int primesCount = 1;
			
			for (int nextDigit : POSSIBLE_LAST_DIGITS) {
				int nextNumberToCheck = currentNumber*10 + nextDigit;
				primesCount += findPrimes(nextNumberToCheck);
			}
			
			return primesCount;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		
		int primesCount = 0;
		System.out.println("The tree of prime numbers:");
		
		for (int singleDigitPrime:SINGLE_DIGIT_PRIMES) {
			primesCount += findPrimes(singleDigitPrime);
		}
		
		System.out.println("===============================================");
		System.out.print("Total count of prime numbers in the tree: ");
		System.out.print(primesCount);
		System.out.println(".");
	}
}
