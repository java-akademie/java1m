package ch.jkurs.a09_muenzen;

import java.util.Date;

/**
 * 
 * @author andree grosse
 * 
 */
public class Main
{
	public static void main(String[] args)
	{
		printMaxCount(Cent.ONE);
		printMaxCount(Cent.TWO);
		printMaxCount(Cent.FIVE);
		printMaxCount(Cent.TEN);
		printMaxCount(Cent.FIFTY);
		printMaxCount(Cent.HUNDERT);

		System.out.println("\nStart: " + Constants.DF.format(new Date()));

		Calculator calculator = new Calculator();
		calculator.calculate();

		System.out.printf("\nGefundene Loesungen = %d%n",
				calculator.getSolutions());

		System.out.println("\nEnde:  " + Constants.DF.format(new Date()));
	}


	private static void printMaxCount(Cent cent)
	{
		System.out.println(cent.getAmount() + " Cent max count = "
				+ cent.getMaxCount());
	}
}
