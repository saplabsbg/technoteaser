package saptechnoteaser2020.week3;

/* 
 * <h1>Recursion</h1>
 * Iterative solution
 * SAPTechnoteaser 2020, Week3, Question2
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2020/#week3,question2">Description and explanation</a>
 * 
 */
public class RecursionAsIteration {

	private static final int INITIAL_ARGUMENT = 1;
	
	public static void main(String[] args) {

		int n = INITIAL_ARGUMENT;
		int timesToApply = 1;
		while(timesToApply > 0) {
			timesToApply--;
			if (n > 2020) {
				n -= 3;
			} else {
				timesToApply += n;
				n *= 4;
			}
		}
		System.out.println(n);
	}
}
