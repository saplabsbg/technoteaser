package saptechnoteaser2020.week3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/* 
 * The Four 4s
 * SAPTechnoteaser 2020, Week3, Question3
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2020/#week3,question3">Description and explanation</a>
 * 
 */
public class TheFour4s {
	
    private static final String[] OPERATIONS = { "+", "-", "*", "/"}; 
	private static final String DIGIT = Integer.toString(4);
	
	public static void main(String[] args) throws ScriptException {
		
	    Map<Integer, String> sampleExpressionPerInteger = new TheFour4s().getExpressionPerInteger();
	    
		int i = 0;
		while (sampleExpressionPerInteger.containsKey(++i)) {
			System.out.println(i + ": " + sampleExpressionPerInteger.get(i) + " = " + i);
		}
		System.out.println(i + ": " + "There is no expression equal to " + i + " ");
	}
	
	private Collection<String> expressionsWith1Digit;
	
	private Collection<String> buildExpressionsWith1Digit() {
		
		if (expressionsWith1Digit != null) {
			return expressionsWith1Digit;
		}
		
		// expr1 ::= d || sqrt(d) || sqrt(sqrt(d))
		expressionsWith1Digit = new ArrayList<String>(3);
		expressionsWith1Digit.add(DIGIT);
		expressionsWith1Digit.add(sqrt(DIGIT));
		expressionsWith1Digit.add(sqrt(sqrt(DIGIT)));		

		return expressionsWith1Digit;
	}
	
	private Collection<String> expressionsWith2Digits;
	
	private Collection<String> buildExpressionsWith2Digits() {
		
		if (expressionsWith2Digits != null) {
			return expressionsWith2Digits;
		}
		
		// expr2 ::= dd || sqrt(dd) || sqrt(sqrt(dd)) || expr1 op expr1 || sqrt(expr1 op expr1)
		expressionsWith2Digits = new HashSet<String>();
		expressionsWith2Digits.add(DIGIT+DIGIT);
		expressionsWith2Digits.add(sqrt(DIGIT+DIGIT));
		expressionsWith2Digits.add(sqrt(sqrt(DIGIT+DIGIT)));
		for (String expr1 : buildExpressionsWith1Digit()) {
			for (String expr2 : buildExpressionsWith1Digit()) {
				for (String operation : OPERATIONS) {
					expressionsWith2Digits.add(expr1 + operation + expr2);
					expressionsWith2Digits.add(sqrt(expr1 + operation + expr2));
				}
			}
		}
		
		return expressionsWith2Digits;
	}
	
	private Collection<String> expressionsWith3Digits;
	
	private Collection<String> buildExpressionsWith3Digits() {
		
		if (expressionsWith3Digits != null) {
			return expressionsWith3Digits;
		}
		
		// expr3 := ddd || sqrt(ddd) || expr1 op expr2 || sqrt(expr1 op expr2) || expr2 op expr1 || sqrt(expr2 op expr1) 
		expressionsWith3Digits = new HashSet<String>();
		expressionsWith3Digits.add(DIGIT+DIGIT+DIGIT);
		expressionsWith3Digits.add(sqrt(DIGIT+DIGIT+DIGIT));
		for (String expr1 : buildExpressionsWith1Digit()) {
			for (String expr2 : buildExpressionsWith2Digits()) {
				for (String operation : OPERATIONS) {
					expressionsWith3Digits.add(expr1 + operation + expr2);
					expressionsWith3Digits.add(sqrt(expr1 + operation + expr2));
					
					expressionsWith3Digits.add(expr2 + operation + expr1);
					expressionsWith3Digits.add(sqrt(expr2 + operation + expr1));
				}
			}
		}	

		return expressionsWith3Digits;
	}
	
	private Collection<String> expressionsWith4Digits;
	
	private Collection<String> buildExpressionsWith4Digits() {
		
		if (expressionsWith4Digits != null) {
			return expressionsWith4Digits;
		}
		
		// expr4 := dddd || sqrt(dddd) || expr2 op expr2 || sqrt(expr2 op expr2) || expr3 op expr1 || sqrt(expr3 op expr1) || expr1 op expr3 || sqrt(expr1 op expr3) 
		expressionsWith4Digits = new HashSet<String>();
		expressionsWith4Digits.add(DIGIT+DIGIT+DIGIT+DIGIT);
		expressionsWith4Digits.add(sqrt(DIGIT+DIGIT+DIGIT+DIGIT));
		
		for(String expr2Arg1 : buildExpressionsWith2Digits()) {
			for(String expr2Arg2 : buildExpressionsWith2Digits()) {
				for (String operation : OPERATIONS) {
					expressionsWith4Digits.add(expr2Arg1 + operation + expr2Arg2);
					expressionsWith4Digits.add(sqrt(expr2Arg1 + operation + expr2Arg2));	
				}
			}
		}
		
		for (String expr3 : buildExpressionsWith3Digits()) {
			for (String expr1 : buildExpressionsWith1Digit()) {
				for (String operation : OPERATIONS) {
					expressionsWith4Digits.add(expr1 + operation + expr3);
					expressionsWith4Digits.add(sqrt(expr1 + operation + expr3));
					
					expressionsWith4Digits.add(expr3 + operation + expr1);
					expressionsWith4Digits.add(sqrt(expr3 + operation + expr1));
				}
			}
		}	

		return expressionsWith4Digits;
	}
	
	public Map<Integer, String> getExpressionPerInteger() throws ScriptException {
		
		ScriptEngineManager factory = new ScriptEngineManager();
	    ScriptEngine engine = factory.getEngineByName("JavaScript");
	    
	    Map<Integer, String> sampleExpressionPerInteger = new HashMap<>();
		Collection <String> expressions = buildExpressionsWith4Digits();
		
		for(String expr : expressions) {	 
			Integer resultFromCurrentExpression = 0;
			Object res = engine.eval(expr);
			if (res instanceof Integer) {
				resultFromCurrentExpression = (Integer) res;
			} else if (res instanceof Double) {
				Double dRes = (Double) res;
				if (dRes > 0 && Math.floor(dRes) == dRes) {
					resultFromCurrentExpression = dRes.intValue();
				}
			}		
			if (resultFromCurrentExpression > 0 && !sampleExpressionPerInteger.containsKey(resultFromCurrentExpression)) {
				sampleExpressionPerInteger.put(resultFromCurrentExpression, expr);
			}
		}
		
		return sampleExpressionPerInteger;
	}
	
	private String sqrt(String arg) {
		return "Math.sqrt(" + arg + ")";
	}

}
