package saptechnoteaser2022.week3;

/* 
 * <h1>The big pizza</h1>
 * SAPTechnoteaser 2022, Week3, Question2
 * @see <a href="https://saplabsbg.github.io/technoteaser/docs/technoteaser2022/#week3,question2">Description and explanation</a>
 * 
 */
public class TheBigPizza {

	public static final int NUMBER_OF_PEOPLE = 100;
	public static final int PIZZA_PIECES = 100;
	
	public static void main(String[] args) {
		double pizzaAmmountLeft = PIZZA_PIECES;
		double maxPizzaAmmountTaken = 0;
		int personWithMaxPizzaAmmount = 0;
		
		for (int i = 1; i <= NUMBER_OF_PEOPLE; i++) {
			double pizzaAmmountForCurrentPerson = pizzaAmmountLeft*i/100;
			if (pizzaAmmountForCurrentPerson > maxPizzaAmmountTaken) {
				maxPizzaAmmountTaken = pizzaAmmountForCurrentPerson;
				personWithMaxPizzaAmmount = i;
			}
			pizzaAmmountLeft -= pizzaAmmountForCurrentPerson;
		}
		
		System.out.println("The maximum pizza amount goes to person " + personWithMaxPizzaAmmount + " taking " + maxPizzaAmmountTaken + " out of " + NUMBER_OF_PEOPLE + " pieces");

	}

}
