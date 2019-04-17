package saptechnoteaser2019.week3;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ExpressionsWithoutBracketsIterative {

	private static final String[] OPERATIONS = {"*", "+", "-", "/", ""}; //allow lexicographical order
	private static final int[] INPUT = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};

	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager factory = new ScriptEngineManager();
		// create a JavaScript engine
		ScriptEngine engine = factory.getEngineByName("JavaScript");	    

		int count = 0;

		for(String operation1 : OPERATIONS)
		for(String operation2 : OPERATIONS)
		for(String operation3 : OPERATIONS)
		for(String operation4 : OPERATIONS)
		for(String operation5 : OPERATIONS)
		for(String operation6 : OPERATIONS)
		for(String operation7 : OPERATIONS)
		for(String operation8 : OPERATIONS) {
			String  expression = INPUT[0] + 
					operation1 + INPUT[1] +
					operation2 + INPUT[2] +
					operation3 + INPUT[3] +
					operation4 + INPUT[4] +
					operation5 + INPUT[5] +
					operation6 + INPUT[6] +
					operation7 + INPUT[7] +
					operation8 + INPUT[8];

			boolean expressionEvaluationResult = (boolean) engine.eval(expression + " === 465");
			if (expressionEvaluationResult) {
				count++;
				System.out.println(count + ": " + expression + " = " + 465);
			}	
		}
	}
}
