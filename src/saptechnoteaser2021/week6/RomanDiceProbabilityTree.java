package saptechnoteaser2021.week6;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class RomanDiceProbabilityTree {
	
    public static enum RomanDiceSide { I, V, X, L, C, D, M, NUMBER_END }
    
	private static final String[] THOUSANDS = new String[] {"", "M", "MM", "MMM"};
	private static final String[] HUNDREDS = new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	private static final String[] TENS = new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	private static final String[] UNITS = new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	
	private static final int BIGGEST_VALID_ROMAN_NUMBER = 3999;
	
	private RootNode root = new RootNode();
	
	public static void main(String[] args) {
		
		RomanDiceProbabilityTree tree = new RomanDiceProbabilityTree();
		
		//initialize the probability tree for all valid numbers 
		IntStream.range(0, BIGGEST_VALID_ROMAN_NUMBER + 1).forEachOrdered(i -> tree.addRomanNumber(i, getInRomanNumberals(i)));
		
		RationalNumber overalProbability = new RationalNumber(0,1);
		for (int i = 0; i < 2021; i++) {
			overalProbability = overalProbability.add(tree.getProbabilityForNumber(i));
		}
		
		System.out.println(overalProbability);
	}
	
	public static List<RomanDiceSide> getInRomanNumberals(int number) {
		
		if (number < 0 || number > BIGGEST_VALID_ROMAN_NUMBER) {
			throw new IllegalArgumentException("Unsupported number: " + number);
		}
		
		String inRomanNumerals = THOUSANDS[number/1000] + HUNDREDS[number%1000/100] + TENS[number%100/10] + UNITS[number%10];
		List<RomanDiceSide> result = new ArrayList<>(inRomanNumerals.length());
		for(char c : inRomanNumerals.toCharArray()) {
			result.add(RomanDiceSide.valueOf(Character.toString(c)));
		}
		
		return result;
	}
	
	public void addRomanNumber(int number, List<RomanDiceSide> romanNumerals) {
		
		Node currentNode = this.root;
		for(RomanDiceSide diceSice: romanNumerals) {
			currentNode = currentNode.addChildNode(diceSice);
		}
		currentNode.addLeafNode(number);
	}
	
	public RationalNumber getProbabilityForNumber(int number) {
		return root.getProbabilityForNumber(number, getInRomanNumberals(number));
	}
	
	private static class Node {
		
		protected RomanDiceSide nodeRomanSymbol;
		protected Node parent;
		protected Map<RomanDiceSide, Node> children;
		
		protected  Node (Node parent, RomanDiceSide romanNumberSymbol) {
			this.parent = parent;
			this.nodeRomanSymbol = romanNumberSymbol;
			children = new HashMap<>();
		}
		
		protected Node getChildNode(RomanDiceSide romanNumberSymbol) {
			return children.get(romanNumberSymbol);
		}
		
		protected Node addChildNode(RomanDiceSide romanNumberSymbol) {
			
			if (romanNumberSymbol == RomanDiceSide.NUMBER_END) {
				throw new IllegalArgumentException("IllegalArgument " + RomanDiceSide.NUMBER_END); 
			}
			
			Node childNode = getChildNode(romanNumberSymbol);
			if (childNode == null) {
				childNode = new Node(this, romanNumberSymbol);
				children.put(romanNumberSymbol, childNode);
			}
			
			return childNode;
		}
		
		protected LeafNode getLeafChildNode() {
			return (LeafNode) children.get(RomanDiceSide.NUMBER_END);
		}
		
		protected Node addLeafNode(int value) {
			
			LeafNode leafChildNode = getLeafChildNode();
			if (leafChildNode == null) {
				leafChildNode = new LeafNode(this, value);
				children.put(RomanDiceSide.NUMBER_END, leafChildNode);
			}
			
			return leafChildNode;
		}
		
		protected int getNumberOfValidOutcomesFromNextRoll() {
			return this.children.size();
		}
		
		protected boolean isRoot() {
			return false;
		}
		
		@Override
		public String toString() {
			return parent.toString() + nodeRomanSymbol.name();
		}
	}
	
	private static class RootNode extends RomanDiceProbabilityTree.Node {
		
		protected RootNode () {
			super(null,null);
		}
		
		@Override
		protected boolean isRoot() {
			return true;
		}
		
		@Override
		public String toString() {
			return "";
		}
		
		protected RationalNumber getProbabilityForNumber(int number, List<RomanDiceSide> inRomanNumberals) {
			
			Node currentNode = this;
			for(RomanDiceSide diceSide : inRomanNumberals) {
				currentNode = currentNode.getChildNode(diceSide);
			}
			LeafNode leafNode = currentNode.getLeafChildNode();
			
			return leafNode.getProbability();
		}
	}
	
	private static class LeafNode extends RomanDiceProbabilityTree.Node {
		
		protected int number;
		
		protected LeafNode (Node parent, int value) {
			super(parent, RomanDiceSide.NUMBER_END);
			this.number = value;
		}
		
		@Override
		public String toString() {
			return number + ":" + parent.toString();
		}
		
		protected RationalNumber getProbability () {
			
			long denominator = 1;
			Node currentNode = this;
			while (!currentNode.isRoot()) {
				currentNode = currentNode.parent;
				denominator *= currentNode.getNumberOfValidOutcomesFromNextRoll();
			}
			
			return new RationalNumber(1, denominator);
		}
	}
	
	private static class RationalNumber {
		private BigInteger numerator;
	    private BigInteger denominator;

	    public RationalNumber(long numerator, long denominator) {
	    	
	        this.numerator = BigInteger.valueOf(numerator);
	        this.denominator = BigInteger.valueOf(denominator);
	    }
	    
	    public RationalNumber(BigInteger numerator, BigInteger denominator) {
	    	
	        this.numerator = numerator;
	        this.denominator = denominator;
	    }
	    
	    public RationalNumber add(RationalNumber r2) {
	    	
	    	BigInteger newNumerator = this.numerator.multiply(r2.denominator).add(r2.numerator.multiply(this.denominator));
	    	BigInteger newDenominator = this.denominator.multiply(r2.denominator);
	    	return new RationalNumber(newNumerator, newDenominator).normalize();
	    }
	    
	    public RationalNumber normalize() {
	    	
	    	BigInteger gcd = this.numerator.gcd(this.denominator);
	    	if (gcd.compareTo(BigInteger.ONE) > 0) {
	    		this.numerator = this.numerator.divide(gcd);
	    		this.denominator = this.denominator.divide(gcd);
	    	}
	    	return this;
	    }
	    
	    @Override
	    public String toString()
	    {
	        return numerator + "/" + denominator; 
	    }
	}
}
