package ch.jkurs.uebungen;

import ch.jmb.tools.MyTools;

/**
 * Kreisprogramm: <br>
 * 
 * Eingabe: radius <br>
 * Ausgabe: umfang,flaeche <br>
 */
public class Uebung04a
{
	public static void main(String[] args)
	{
		int radius = MyTools.getInteger("bitte Radius eingeben > ");

		double umfang = 2 * radius * 3.14159;
		double flaeche = radius * radius * 3.14159;
		System.out.println("umfang:  " + umfang);
		System.out.println("flaeche: " + flaeche);
	}
}
