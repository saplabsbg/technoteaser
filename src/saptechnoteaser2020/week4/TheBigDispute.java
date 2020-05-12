package saptechnoteaser2020.week4;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.tuple.ImmutableTriple;
/* 
 * <h1>The Big Dispute</h1>
 * SAPTechnoteaser 2020, Week4, Question2
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2020/#week4,question2">Description and explanation</a>
 * 
 */
public class TheBigDispute {

	private int group1, group2, group3;
	
	public TheBigDispute(int group1, int group2, int group3) {
		this.group1 = group1;
		this.group2 = group2;
		this.group3 = group3;
	}
	
	public static void main(String[] args) {
		TheBigDispute dispute = new TheBigDispute(13, 15, 17);
		
		Set<ImmutableTriple<Integer, Integer, Integer>> arrangements = dispute.getAllPossibleArrangements();
		int allStudents = dispute.group1 + dispute.group2 + dispute.group3;
		
		for (ImmutableTriple<Integer, Integer, Integer> arrangement : arrangements) {
			if (arrangement.left == arrangement.right) {
				System.out.println("Equal number of students believe in answer 1 and 3: " + arrangement);
			}
			if (arrangement.left == allStudents || arrangement.middle == allStudents || arrangement.right == allStudents) {
				System.out.println("All Students believe in one answer: " + arrangement);
			}
		}
	}
	
	public Set<ImmutableTriple<Integer, Integer, Integer>> getAllPossibleArrangements() {
		Set<ImmutableTriple<Integer, Integer, Integer>> result = new HashSet<>();
		getPossibleArrangements(new ImmutableTriple<>(group1, group2, group3), result);
		return result;
	}
	
	private static void getPossibleArrangements(ImmutableTriple<Integer, Integer, Integer> currentArrangement, Set<ImmutableTriple<Integer, Integer, Integer>> result) {
		if (result.contains(currentArrangement)) {
			return;
		}
		result.add(currentArrangement);
		int currentGroup1 = currentArrangement.left;
		int currentGroup2 = currentArrangement.middle;
		int currentGroup3 = currentArrangement.right;
		if (currentGroup1 > 0 && currentGroup2 > 0) {
			getPossibleArrangements(new ImmutableTriple<>(currentGroup1 - 1, currentGroup2 - 1, currentGroup3 + 2), result);
		}
		if (currentGroup1 > 0 && currentGroup3 > 0) {
			getPossibleArrangements(new ImmutableTriple<>(currentGroup1 - 1, currentGroup2 + 2, currentGroup3 - 1), result);
		}
		if (currentGroup2 > 0 && currentGroup3 > 0) {
			getPossibleArrangements(new ImmutableTriple<>(currentGroup1 + 2, currentGroup2 - 1, currentGroup3 - 1), result);
		}
	}
}
