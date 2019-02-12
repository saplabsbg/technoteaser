package saptechnoteaser2019.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ExpressionsWithoutBracketsRecursive {
    private static final String[] OPERATIONS = {"", "+", "-", "*", "/"}; 
	private static final int[] INPUT = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager factory = new ScriptEngineManager();
	    // create a JavaScript engine
	    ScriptEngine engine = factory.getEngineByName("JavaScript");
	    
		Collection<String> initialResult = Arrays.asList("1");
		Collection <String> allExpressions = buildExpressions(1, initialResult);
	
		int count = 0;    
		for(String expression : allExpressions) {
			// evaluate JavaScript code from String
			boolean expressionEvaluationResult = (boolean) engine.eval(expression + " === 465");
			if (expressionEvaluationResult) {
				count++;
				System.out.println(count + ": " + expression + " = " + 465);
			}			
		}
	}
	
	private static Collection<String> buildExpressions(int pos, Collection<String> intermediateResult) {
		if (pos == INPUT.length) {
			return intermediateResult;
		} 
		
		Collection<String> result = new ArrayList<String>(intermediateResult.size() * 5);

		for (String expr : intermediateResult) {
			for (String operation: OPERATIONS) {
				result.add(expr + operation + INPUT[pos]);
			}
		}

		return buildExpressions(pos+1, result);		
	}

}
