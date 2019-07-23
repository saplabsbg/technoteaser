package saptechnoteaser2019.specialedition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class MaxSumOfProducts {

	private static final int SUM = 2019;
	
	public static void main(String[] args) {
		int maxSumOfProducts = 0;
		Integer[] result = null;
		
		for(ImmutablePair<Integer, Integer> pair1 : generatePairs(SUM)) {
			Integer a = pair1.left;
			for(ImmutablePair<Integer, Integer> pair2 : generatePairs(SUM - a)) {
				Integer b = pair2.left;
				for(ImmutablePair<Integer, Integer> pair3 : generatePairs(SUM - a - b)) {
					Integer c = pair3.left;
					Integer d = pair3.right;
					int product = a*b + b*c + c*d;
					if (product > maxSumOfProducts) {
						maxSumOfProducts = product;
						result = new Integer[] {a, b, c, d};
					}
				}
			}
		}
		System.out.print("max value of ab + bc + cd is " + maxSumOfProducts);
		System.out.println(" when [a, b, c, d] = " + Arrays.asList(result));
		
	}

	
private static List <ImmutablePair<Integer,Integer>> generatePairs(int withSum) {
		ArrayList<ImmutablePair<Integer,Integer>> result = new ArrayList<>();
		for(int i=1; i<withSum; i++) {
			result.add(new ImmutablePair<>(i, withSum - i));
		}	
		return result;		
	}
}
