package saptechnoteaser2019.week4;

public class PythagoreanTripleUniqueGenerator {

	private static int LIMIT = 10000;
	
	public static void main(String[] args) {
		
		int count = 0;
		// k = a + b
		for(int k = 3; k <= LIMIT; k += 2) {
			int n = 1;
			int m = k - n;
			while (n < m) {
				if (gcd(m,n) == 1) {
					int a = m*m - n*n;
					int b = 2*m*n;
					if (a > b) {
						a = b;
						b = m*m - n*n;
					}
					//int c = m*m+n*n; //not needed for counting
					int multiplyBy = 1;
					while (a*multiplyBy<=LIMIT) {
						//(a*multiplyBy, b*multiplyBy, c*multiplyBy) is the next Pythagorean triple
						count++;
						multiplyBy++;
					}
				}
				n++;
				m--;
			}
		}
		
		System.out.println("Number of Pythagorean triples (a,b,c) for which a < b < c and a ≤ " + LIMIT + ": " + count);
	}
	
	private static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcd(b%a, a);
	}
}
