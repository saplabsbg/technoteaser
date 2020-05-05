package saptechnoteaser2020.week3;

/* 
 * <h1>Recursion</h1>
 * SAPTechnoteaser 2020, Week3, Question2
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2020/#week3,question2">Description and explanation</a>
 * 
 */
public class Recursion {

	private static final int INITIAL_ARGUMENT = 1;
	
	public static void main(String[] args) {
		System.out.println(new Recursion().f(INITIAL_ARGUMENT));
	}

	private int f(int n) {
		if (n > 2020) {
			return n - 3;
		} else {
			int currentResult = f(4*n);
			for(int i = 1; i < n; i++) {
				currentResult = f(currentResult);
			}
			return currentResult;
		}
	}
}
