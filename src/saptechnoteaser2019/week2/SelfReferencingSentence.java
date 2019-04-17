package saptechnoteaser2019.week2;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SelfReferencingSentence {

	public static void main(String[] args) {
		int count = 0;

		for (int i0 = 2; i0 <= 3; i0++)
		for (int i1 = 2; i1 <= 12; i1++)
		for (int i2 = 1; i2 <= 5; i2++)
		for (int i3 = 1; i3 <= 5; i3++)
		for (int i4 = 1; i4 <= 5; i4++)
		for (int i5 = 1; i5 <= 5; i5++)
		for (int i6 = 1; i6 <= 5; i6++)
		for (int i7 = 1; i7 <= 5; i7++)
		for (int i8 = 1; i8 <= 5; i8++)
		for (int i9 = 1; i9 <= 5; i9++)
		for (int i10 = 1; i10 <= 2; i10++) {

			int[] currentNumbers = new int[] {i0, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10};
			int[] actualCounts = new int[] {2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1};

			for (int i = 0; i <= 10; i++) {
				int num = currentNumbers[i];
				if (num < 10) { // a digit
					actualCounts[num]++;
				} else { // number 10
					int firstDigit = (num / 10);
					int secondDigit = (num % 10);
					actualCounts[firstDigit]++;
					actualCounts[secondDigit]++;
					if (num == 10) {
						actualCounts[10]++;
					}
				}
			}

			if (Arrays.equals(currentNumbers, actualCounts)) {
				count++;
				System.out.println(IntStream.range(0, 11)
						.mapToObj(n -> n + " → " + currentNumbers[n])
						.collect(Collectors.joining(", ",
								"Solution №" + count + ": [", "]")));
			}
		}
	}

}
