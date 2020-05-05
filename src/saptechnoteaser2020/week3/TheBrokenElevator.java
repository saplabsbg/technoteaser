package saptechnoteaser2020.week3;

import java.util.stream.IntStream;

/* <h1>The Broken Elevator</h1>
 * SAPTechnoteaser 2020, Week3, Question1
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2020/#week3,question1">Description and explanation</a>
 * 
 */
public class TheBrokenElevator {

	public static void main(String[] args) {
		
		IntStream.iterate(0, i -> ++i).filter(sum -> {
			return IntStream.rangeClosed(0, sum).filter(x -> {
				int y = sum - x;
				if (1 + 7*x - 9*y == 72) {
					System.out.println(sum + 
							": push blue button " + x + 
							" times, push yellow button " + y +
							" times");
					return true;
				} else {
					return false;
				}
			}).findFirst().isPresent();
		}).findFirst();
	}
}
