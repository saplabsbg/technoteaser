package saptechnoteaser2020.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.IntStream;
/* 
 * <h1>Little Mary</h1>
 * SAPTechnoteaser 2020, Week5, Question3
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2020/#week5,question3">Description and explanation</a>
 * 
 */
public class MaryPurchases {

	private final Banknotes initialMoney;
	private List<List<Purchase>> longestPurchases = new ArrayList<>();
	private int biggestNumberOfPurchases = 0;
	
	private static final Map<Integer, Banknotes> BANKNOTES_FOR_CHANGE;
	static {
		Map<Integer, Banknotes> minimalNumberOfBanknotes = new HashMap<>();
		minimalNumberOfBanknotes.put(1, new Banknotes(1));
		minimalNumberOfBanknotes.put(2, new Banknotes(2));
		minimalNumberOfBanknotes.put(3, new Banknotes(1, 2));
		minimalNumberOfBanknotes.put(4, new Banknotes(2, 2));
		minimalNumberOfBanknotes.put(5, new Banknotes(5));
		for (int i=6; i<10; i++) {
			minimalNumberOfBanknotes.put(i, new Banknotes(minimalNumberOfBanknotes.get(i - 5), 5));
		}
		minimalNumberOfBanknotes.put(10, new Banknotes(10));
		for (int i = 11; i < 20; i++) {
			minimalNumberOfBanknotes.put(i, new Banknotes(minimalNumberOfBanknotes.get(i - 10), 10));
		}
		minimalNumberOfBanknotes.put(20, new Banknotes(20));
		for (int i = 21; i < 50; i++) {
			minimalNumberOfBanknotes.put(i, new Banknotes(minimalNumberOfBanknotes.get(i - 20), 20));
		}
		minimalNumberOfBanknotes.put(50, new Banknotes(50));
		for (int i = 51; i < 100; i++) {
			minimalNumberOfBanknotes.put(i, new Banknotes(minimalNumberOfBanknotes.get(i - 50), 50));
		}
		BANKNOTES_FOR_CHANGE = Collections.unmodifiableMap(minimalNumberOfBanknotes);
	}
	
	public MaryPurchases (Integer... initialBanknotes) {
		this.initialMoney = new Banknotes(initialBanknotes);
	}
	
	public static void main(String[] args) {
		
		MaryPurchases purchasesWith100lv = new MaryPurchases(100);
		
		List<List<Purchase>> maxPossiblePurchases = purchasesWith100lv.getMaxPossiblePurchases();
		System.out.println("Number of solutions: " + maxPossiblePurchases.size());
		IntStream.range(0, maxPossiblePurchases.size()).forEach(index -> {
			System.out.println("Solution " + (index + 1) + ":");
			purchasesWith100lv.printResult(maxPossiblePurchases.get(index));
		}); 
	}
	
	public List<List<Purchase>> getMaxPossiblePurchases() {
		simulateAllPossiblePurchases(initialMoney, new ArrayList<>());
		return longestPurchases;
	}

    private void simulateAllPossiblePurchases(Banknotes currentMoney, List<Purchase> madePurchases) {
    	List<Purchase> possiblePurchases = getPossiblePurchases(currentMoney);
    	if (possiblePurchases.size() == 0) {
    		int numberOfPurchases = madePurchases.size();
    		if (biggestNumberOfPurchases < numberOfPurchases) {
    			biggestNumberOfPurchases = numberOfPurchases;
    			longestPurchases.clear();
    			longestPurchases.add(new ArrayList<>(madePurchases));
    		} else if (biggestNumberOfPurchases == numberOfPurchases) {
    			longestPurchases.add(new ArrayList<>(madePurchases));
    		}
    		
    	} else {
    		for(Purchase nextPurchase:possiblePurchases) {
    			madePurchases.add(nextPurchase);
    			
    			Banknotes moneyAfterPurchase = new Banknotes(currentMoney, nextPurchase);
    			simulateAllPossiblePurchases(moneyAfterPurchase, madePurchases);
    			
    			madePurchases.remove(madePurchases.size()-1);
    		}
    	}
    	
    }
    
    private void printResult(List<Purchase> purchases) {
		Banknotes currentBanknotes = initialMoney;
		for(int i=1; i<=purchases.size(); i++) {
			Purchase nextPurchase = purchases.get(i-1);
			currentBanknotes = new Banknotes(currentBanknotes, nextPurchase);
		    System.out.println(i + ":" + nextPurchase + " leaving with banknotes " + currentBanknotes + " with total amount of " + currentBanknotes.getAmmount());
		}
		System.out.println();
	}


	public NavigableMap<Integer, Banknotes> getPossibleExactPayments(Banknotes banknotes) {
		return new TreeMap<>(getPossibleExactPayments(banknotes, 0));
	}

	private HashMap<Integer, Banknotes> getPossibleExactPayments(Banknotes banknotes, int fromIndex) {
		HashMap<Integer, Banknotes> result = new HashMap<>();

		for (int i = fromIndex; i < banknotes.size(); i++) {
			Integer currentBanknote = banknotes.getBanknote(i);
			
			result.put(currentBanknote, new Banknotes(currentBanknote));
			
			HashMap<Integer, Banknotes> resultWithoutCurrentBanknote = getPossibleExactPayments(banknotes, i + 1);
			result.putAll(resultWithoutCurrentBanknote);
			for (Integer tmpPayment : resultWithoutCurrentBanknote.keySet()) {
				int newAmount = tmpPayment + currentBanknote;
				if (!resultWithoutCurrentBanknote.containsKey(newAmount)) {
					Banknotes newBanknotes = new Banknotes(resultWithoutCurrentBanknote.get(tmpPayment), currentBanknote);
					result.put(newAmount, newBanknotes);
				}
			}

		}
		return result;
	}

	public List<Purchase> getPossiblePurchases(Banknotes banknotes) {
		ArrayList<Purchase> result = new ArrayList<>();
		NavigableMap<Integer, Banknotes> exactPayments = getPossibleExactPayments(banknotes);
		int moneyAmmount = banknotes.getAmmount();
		for (int i = 1; i < moneyAmmount; i++) {
			if (exactPayments.containsKey(i)) {
				continue; // we cannot pay exact value as we will not have change
			}
			int ammountToGive = exactPayments.ceilingKey(i);
			
			Banknotes change = BANKNOTES_FOR_CHANGE.get(ammountToGive-i);
			if (change.size() < 2 ) continue;
			result.add(new Purchase(exactPayments.get(ammountToGive), change));
		}
		return result;
	}
	
	private static class Banknotes {
		private List<Integer> banknotes;
		
		public Banknotes(Integer... banknotes) {
			this.banknotes = Arrays.asList(banknotes);
		}
		public Banknotes (Banknotes fromBanknotes, Integer... additionalBanknotes) {
			List<Integer> newBanknotes = new ArrayList<>(fromBanknotes.getBanknotes().size() + additionalBanknotes.length);
			newBanknotes.addAll(fromBanknotes.getBanknotes());
			newBanknotes.addAll(Arrays.asList(additionalBanknotes));
			this.banknotes = Collections.unmodifiableList(newBanknotes); 
		}
		public Banknotes(Banknotes fromBanknotes, Purchase afterPurchase) {
			List<Integer> newBanknotes = new ArrayList<>(fromBanknotes.getBanknotes());
			for (Integer nextGivenBanknote: afterPurchase.givenBanknotes.getBanknotes()) {
				newBanknotes.remove(nextGivenBanknote);
			}
			newBanknotes.addAll(afterPurchase.change.getBanknotes());	
			newBanknotes.sort(Integer::compare);
			this.banknotes = Collections.unmodifiableList(newBanknotes); 
		}
		
		private List<Integer> getBanknotes() {
			return this.banknotes;
		}
		
		public int getAmmount() {
			return this.banknotes.stream().mapToInt(Integer::intValue).sum();
		}
		
		public int getBanknote(int index) {
			return this.banknotes.get(index);
		}
		public int size() {
			return banknotes.size();
		}
		
		@Override
		public String toString() {
			return banknotes.toString();
		}
		
	}
	
	private static class Purchase {
		private Banknotes givenBanknotes;
		private Banknotes change;
		
		public Purchase(Banknotes givenBanknotes, Banknotes change) {
			this.givenBanknotes = givenBanknotes;
			this.change = change;
		}
		
		@Override
		public String toString() {
			int maymentAmmount = givenBanknotes.getAmmount() - change.getAmmount();
			return "Pay " + maymentAmmount + ": Give " + givenBanknotes.toString() + " with change " + change.toString();
		}
	}

	
}
