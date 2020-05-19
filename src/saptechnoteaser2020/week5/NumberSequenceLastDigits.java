package saptechnoteaser2020.week5;
/* 
 * <h1>Number Sequence</h1>
 * SAPTechnoteaser 2020, Week5, Question2
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2020/#week5,question2">Description and explanation</a>
 * 
 */
public class NumberSequenceLastDigits {

	private static final int А1 = 5;
	private static final int WANTED_INDEX = 2020;
	
	private int currentNumberLastDigit;
	
	public static void main(String[] args) {
		int result = new NumberSequenceLastDigits().calculateLastDigitOfElement(WANTED_INDEX);
		System.out.println("Last digit of a_" + WANTED_INDEX + " is " + result);
	}

	public int calculateLastDigitOfElement (int index) {
		int previousNumberLastDigit = А1 % 10;
		currentNumberLastDigit = (previousNumberLastDigit*previousNumberLastDigit - 2 + 10)%10;
		
		for (int i=3; i<=index; i++) {
			// a_n+1 = a_n*a_1 - a_n-1
			int nextNumberLastDigit = (А1*currentNumberLastDigit - previousNumberLastDigit + 10)%10;
			previousNumberLastDigit = currentNumberLastDigit;
			currentNumberLastDigit = nextNumberLastDigit;
		}
		
		return currentNumberLastDigit;		
	}
}
