package saptechnoteaser2019.week6;

public class CollatzNumbersOnDistance {


	public static void main(String[] args) {
		int num = getCollatzNumbersCount(1, 61);
		System.out.println("Result: " + num);
	}

	private static int getCollatzNumbersCount(long fromNumber, int atDistance) {
		if (atDistance == 0) {
			// recursion base case
			return 1;
		}

		int res = getCollatzNumbersCount(fromNumber*2, atDistance-1);
		if (fromNumber > 4 && fromNumber%6 == 4) { 
			res += getCollatzNumbersCount((fromNumber-1)/3, atDistance-1);
		}
		return res;
	}

}
