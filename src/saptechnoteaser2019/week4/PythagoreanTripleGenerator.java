package saptechnoteaser2019.week4;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.tuple.ImmutableTriple;

public class PythagoreanTripleGenerator {

	private static final int LIMIT = 10000;

	public static void main(String[] args) {

		Set<ImmutableTriple<Integer,Integer,Integer>> result = new HashSet<>();
		buildResult(result, LIMIT);
		System.out.println("Number of Pythagorean triples (a,b,c) for which a < b < c and a ≤ " + LIMIT + ": " + result.size());

	}

	private static void buildResult(Set<ImmutableTriple<Integer,Integer,Integer>> result, final int limit) {

		for(int m=2; m<limit; m++) {
			for (int n = 1; n < m && n + m <= limit; n++) {

				int a = m*m - n*n;
				int b = 2*m*n;
				int c = m*m + n*n;
				if (a > b) {
					int tmp = a;
					a = b;
					b = tmp;
				}

				int multiplyBy = 1;
				while (a*multiplyBy <= limit) {
					result.add(new ImmutableTriple<>(a*multiplyBy, b*multiplyBy, c*multiplyBy));
					multiplyBy++;
				}
			}
		}
	}

}
