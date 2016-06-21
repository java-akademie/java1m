package ch.jkurs.uebungen;

import ch.java_akademie.tools.MyTools;

/**
 * Rechner
 * 
 * Eingabe: Operator, zwei Operanden
 * 
 * Ausgabe: berechneter Wert
 * 
 * mit Wiederholung
 */
public class Uebung05
{
	public static void main(String[] args)
	{
		startMeldung();
		haupverarbeitung();
		stoppMeldung();
	}


	private static void startMeldung()
	{
		System.out.println("Rechner");
		System.out.println("-------");
		System.out.println("dieses Programm ermoeglicht ");
		System.out.println("eine Berechnung mit 2 Zahlen ");
		System.out.println("durchzufuehren");
	}


	private static void haupverarbeitung()
	{
		int op = MyTools.getInteger(
				"1=add, 2=sub, 3=mult, 4=div, 0=ende > ", 0, 4);

		while (op != 0)
		{
			int a = MyTools.getInteger("a eingeben > ");
			int b = MyTools.getInteger("b eingeben > ");

			double erg = 0;

			if (op == 1)
				erg = a + b;
			if (op == 2)
				erg = a - b;
			if (op == 3)
				erg = a * b;
			if (op == 4)
				erg = (double) a / (double) b;

			System.out.println(erg);
			op = MyTools.getInteger(
					"1=add, 2=sub, 3=mult, 4=div, 0=ende > ", 0, 4);
		}
	}


	private static void stoppMeldung()
	{
		System.out.println("Programmende");
	}
}
