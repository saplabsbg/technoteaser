package saptechnoteaser2022.week3;

/* 
 * <h1>Inequalities</h1>
 * SAPTechnoteaser 2022, Week3, Question3
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2022/#week3,question3">Description and explanation</a>
 * 
 */
public class LowestDenominatorInequality {

	private static final int N1 = 2021;
	private static final int D1 = 2022;
	private static final int N2 = 2022;
	private static final int D2 = 2023;
	// N1/D1 < a/b < N2/D2
	
	public static void main(String[] args) {
		
		int b = 0;
		int lowerBandForA = 0;
		int upperBoundForA = -1;
		
		while (lowerBandForA > upperBoundForA) {
			b++;
			lowerBandForA = getLowerBound(N1*b, D1);
			upperBoundForA = getUpperBound(N2*b, D2);
		} 

		int a = N2*b/D2;
		System.out.println(N1 + "/" + D1 + " < " + a + "/" + b + " < " + N2 + "/" + D2);
	}
	
	public static int getLowerBound (int numerator, int denominator) {
    	return numerator / denominator + 1;
    }
    
    public static int getUpperBound (int numerator, int denominator) {
    	if (numerator % denominator == 0) {
    		return numerator / denominator - 1;
    	} else {
    		return numerator / denominator;
    	}
    }
}
