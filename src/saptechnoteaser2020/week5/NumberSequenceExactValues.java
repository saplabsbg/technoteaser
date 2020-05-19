package saptechnoteaser2020.week5;

import java.math.BigInteger;
/* 
 * <h1>Number Sequence</h1>
 * SAPTechnoteaser 2020, Week5, Question2
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2020/#week5,question2">Description and explanation</a>
 * 
 */
public class NumberSequenceExactValues {

	private static final BigInteger A1 = new BigInteger("5");
	private static final int WANTED_INDEX = 2020;	
	
	public static void main(String[] args) {
		BigInteger result = new NumberSequenceExactValues().calculateSequenceElement(WANTED_INDEX);
		System.out.println(result);
	}

	public BigInteger calculateSequenceElement (int index) {
		BigInteger previousNumber = A1;
		BigInteger currentNumber = A1.pow(2).subtract(new BigInteger("2"));
		
		for (int i=3; i<=index; i++) {
			// a_n+1 = a_n*a_1 - a_n-1
			BigInteger nextNumber =  A1.multiply(currentNumber).subtract(previousNumber);
			previousNumber = currentNumber;
			currentNumber = nextNumber;
		}		
		
		return currentNumber;
	}
}
