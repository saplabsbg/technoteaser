package saptechnoteaser2020.week4;

import java.security.InvalidParameterException;
import java.util.HashSet;
/* 
 * <h1>Necklace</h1>
 * SAPTechnoteaser 2020, Week4, Question3
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2020/#week4,question3">Description and explanation</a>
 * 
 */
public class Necklace {
	
	private int yellow, blue, red;
	private int numberOfBeads;
	private long base=1;
	
	private int numberOfDistinctNecklaces = 0;
	private HashSet<Long> arrangements = new HashSet<>();
	
	public static void main(String[] args) {
		Necklace necklace = new Necklace(4, 6, 8);
		System.out.println(necklace.getNumberOfDistinctNecklaces());
	}

	public Necklace(int yellow, int blue, int red) {
		this.numberOfBeads = yellow + blue + red;
		if (numberOfBeads > 18) throw new InvalidParameterException("Unsupported number of beads:" + numberOfBeads);
		this.yellow = yellow;
		this.blue = blue;
		this.red = red;
		for(int i = 1; i < numberOfBeads; i++) {
			base *= 10;
		}
	}

	public int getNumberOfDistinctNecklaces() {
		buildAllNecklaces(yellow, blue, red, 0);
		return numberOfDistinctNecklaces;
	}
	
	private void buildAllNecklaces(int currentYellowBeads, int currentBlueBeads, int currentRedBeads, long result) {
		if (currentYellowBeads + currentBlueBeads + currentRedBeads == 0) {
			// recursion base case
			addNewArrangement(result);
			return;
		}
		if (currentYellowBeads > 0) {
			buildAllNecklaces(currentYellowBeads - 1, currentBlueBeads, currentRedBeads, result*10 + 1);
		}
		if (currentBlueBeads > 0) {
			buildAllNecklaces(currentYellowBeads, currentBlueBeads - 1, currentRedBeads, result*10 + 2);
		}
		if (currentRedBeads > 0) {
			buildAllNecklaces(currentYellowBeads, currentBlueBeads, currentRedBeads - 1, result*10 + 3);
		}
	}
	private void addNewArrangement(long necklaceAsLong) {			
		if (!arrangements.add(necklaceAsLong)) {
			return;
		}
		numberOfDistinctNecklaces++;		
		
		long reversedNecklace = Long.valueOf(new StringBuilder(Long.toString(necklaceAsLong)).reverse().toString());
		arrangements.add(reversedNecklace);
		
		for(int i=1; i<numberOfBeads; i++) {
			necklaceAsLong = (necklaceAsLong%10)*base + (necklaceAsLong/10);
			arrangements.add(necklaceAsLong);
			
			reversedNecklace = (reversedNecklace%10)*base + (reversedNecklace/10);			
			arrangements.add(reversedNecklace);
		}
	}
}

