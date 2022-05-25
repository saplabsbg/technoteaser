package saptechnoteaser2022.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/* 
 * <h1>Unit fraction</h1>
 * SAPTechnoteaser 2022, Week5, Question3
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2022/#week5,question3">Description and explanation</a>
 */ 
public class UnitFraction_EulerTotientFunction {

	private final static int LIMIT = 1000000;
	private final static int WANTED_PERIOD = 2022;

	private static List<Integer> primes;
	
	
	static {
		//init primes
		primes = new ArrayList<>();
		int[] isPrime = new int[LIMIT + 1];

		for (int i = 2; i <= LIMIT; i++) {
			if (isPrime[i] == 0) {
				primes.add(i);
				for (int j = 2; i * j <= LIMIT; j++) {
					isPrime[i * j] = 1;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {

		OptionalInt result = IntStream.range(2, LIMIT + 1)
			.filter( n -> phi(n) % WANTED_PERIOD == 0)
			.filter( n -> getUnitFractionDecimalPeriod(n) == WANTED_PERIOD)
			.findFirst();
		if (result.isPresent()) {
			System.out.println("1/" + result.getAsInt() + " as a decimal fraction has a period of " + WANTED_PERIOD + " digits");
		} else {
			System.out.println("Solution not found for numbers up to " + LIMIT);
		}
	}
	
	public static int phi(int n) {
		int result = n;

		// this loop runs sqrt(n / ln(n)) times
		for (int i = 0; true; i++) {
			int ithPrime = primes.get(i);
			if (ithPrime*ithPrime > n) {
				break;
			}
			if (n % ithPrime == 0) {
				// subtract multiples of p[i] from r
				result -= result / ithPrime;

				// Remove all occurrences of p[i] in n
				while (n % ithPrime == 0) {
					n /= ithPrime;
				}
			}
		}

		// when n has prime factor greater than sqrt(n)
		if (n > 1) {
			result -= result/n;
		}

		return result;
	}

	public static int getUnitFractionDecimalPeriod(int denominator) {
			
			int currentRemainder = 1;
			Map<Integer, Integer> remaindersCache = new HashMap<>();
			
			while (!remaindersCache.containsKey(currentRemainder)) { 
				remaindersCache.put(currentRemainder, remaindersCache.size());
				currentRemainder = currentRemainder * 10 % denominator;
				if (currentRemainder == 0) {
					return 0;
				}
			}
	
			return remaindersCache.size() - remaindersCache.get(currentRemainder);
		}
	}
