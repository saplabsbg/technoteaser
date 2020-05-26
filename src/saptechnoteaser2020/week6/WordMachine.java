package saptechnoteaser2020.week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
/* 
 * <h1>Word Machine</h1>
 * SAPTechnoteaser 2020, Week6, Question3
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2020/#week6,question3">Description and explanation</a>
 * 
 */
public class WordMachine {

	private static enum Alphabet {А, Б, В, Г, Д, Е, Ж, З, И ,Й ,К, Л, М, Н, О, П ,Р, С, Т ,У, Ф, Х, Ц, Ч, Ш, Щ, Ъ, Ь, Ю ,Я};
	private static enum PrintMode {STRAIGHT, REVERSED};
	
	private static final String TARGET_WORD = "САПТЕХНОБЛЪСКАНИЦА";
	private static final PrintMode PRINT_MODE = PrintMode.STRAIGHT;
	private static final int DECREMENT_OPERATION_PRICE = 2;
	private static final int SWAP_LETTERS_OPERATION_PRICE = 1;
	

	
	private Queue<Word> currentWords = new PriorityQueue<>();
	private Word currentBestResult = new Word("", Integer.MAX_VALUE); 
	
	
	public static void main(String[] args) {
		WordMachine wordMachine = new WordMachine(TARGET_WORD);
		wordMachine.constructWord();
	}
	
	public WordMachine (String targetWord) {
		currentWords.add(new Word(targetWord, 0));
	}
	
	public void constructWord() {
		while(!currentWords.isEmpty()) {
			Word current = currentWords.poll();
			if (current.price > currentBestResult.price) {
				break;
			}
			processWord (current);
        }
		System.out.println(currentBestResult);
	}
	
	private void processWord(Word word) {	
		List<Alphabet> currentWord = word.word;
		int lastIndexOfA = currentWord.lastIndexOf(Alphabet.А);
		
		if (lastIndexOfA == -1 && currentWord.size() > 2) {
			addNewWord(word.decrementLetters());
		} else {
			addNewWord(word.removeLastLetter());	
			if (lastIndexOfA >= 0 && lastIndexOfA < currentWord.size() - 1) {
				addNewWord(word.swapLastAToTheEndAndRemoveIt());
			}
		}	
	}
	
	private void addNewWord(Word newWord) {
		if (newWord.word.size() == 0) {
			if (newWord.price < currentBestResult.price) {
				currentBestResult = newWord;
			}
		} else {
			currentWords.add(newWord);
		}
	}
	
	private static class Word implements Comparable<Word>{
		private List<Alphabet> word;
		private int price;
		private String operationsLog;
		
		public Word(String wordAsString, int price) {
			this.word = new ArrayList<Alphabet>(wordAsString.length());
			for (char letter : wordAsString.toCharArray()) {
				word.add(Alphabet.valueOf(Character.toString(letter)));
			}
			this.price = price;
			this.operationsLog = "";
		}
		
		public Word(List<Alphabet> word, int price, String operationsLog) {
			this.word = word;
			this.price = price;
			this.operationsLog = operationsLog;
		}

		@Override
		public int compareTo(Word arg) {
			return Integer.compare(price, arg.price);
		}
		
		public Word removeLastLetter () {
			Alphabet lastLetter = word.get(word.size()-1);
			int operationPrice = lastLetter.ordinal() + 1;
			List<Alphabet> newWord = word.subList(0, word.size()-1);
			String newWordOperationList;
			if (PRINT_MODE == PrintMode.STRAIGHT) { 
				newWordOperationList = "\n+" + operationPrice + " " + newWord + " -> " +  word  + " (add letter:" + lastLetter + ")" + operationsLog;
			} else {
				newWordOperationList = operationsLog + "\n+" + operationPrice + " " + word + " -> " +  newWord + " (remove last letter:" + lastLetter + ")";
			}
			return new Word (newWord, price + operationPrice, newWordOperationList); 
		}
		
		public Word decrementLetters() {
			List<Alphabet> newWord = new ArrayList<>(word);
			
			int numberOfDecrementations = Collections.min(newWord).ordinal() - Alphabet.А.ordinal();
			for(int i=0; i< newWord.size(); i++) {
				newWord.set(i,  Alphabet.values()[newWord.get(i).ordinal() - numberOfDecrementations]);
			}
			
			int operationPrice = DECREMENT_OPERATION_PRICE * numberOfDecrementations; 
			int newPrice = operationPrice + price;
			String newWordOperationList;
			if (PRINT_MODE == PrintMode.STRAIGHT) {
				newWordOperationList = "\n+" + operationPrice + " " + newWord + " -> " + word + " (increment letters " + numberOfDecrementations + " times)" + operationsLog;
			} else {
				newWordOperationList = operationsLog + "\n+" + operationPrice + " " + word + " -> " + newWord + " (decrement letters " + numberOfDecrementations + " times)";
			}
			
			return new Word(newWord, newPrice, newWordOperationList );
		}
		
		public Word swapLastAToTheEndAndRemoveIt() {
			int lastIndexOfA = word.lastIndexOf(Alphabet.А);
			if (lastIndexOfA == -1) throw new RuntimeException("incorrect usage of swap");
			int numberOfSwpas = word.size() - lastIndexOfA - 1;
			if (numberOfSwpas < 1) throw new RuntimeException("incorrect usage of swap");
			List<Alphabet> newWord = new ArrayList<>(word);
			newWord.remove(lastIndexOfA);
			int operationPrice = numberOfSwpas*SWAP_LETTERS_OPERATION_PRICE + 1; 
			int newPrice =  operationPrice + price;
			
			String newWordOperationsLog;
			if (PRINT_MODE == PrintMode.STRAIGHT) {
				newWordOperationsLog = "\n+" + operationPrice + " " + newWord + " -> " + word + " (add letter A and swap it to the left " + numberOfSwpas + " times)" + operationsLog;
			} else {
				newWordOperationsLog = operationsLog + "\n+" + operationPrice + " " + word + " -> " + newWord + " (swap last A " + numberOfSwpas + " times and remove it)";
			}
			
			return new Word(newWord, newPrice, newWordOperationsLog);
		}

		@Override
		public String toString() {
			return  TARGET_WORD + " word construction for " + price + " lv." +  operationsLog ;
		}
	}
}

