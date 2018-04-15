package ch.jkurs.uebungen;

import ch.jmb.tools.MyTools;

public class Uebung14FiktivesUngeheuer
{

	/*
	 * gibLaut verlangt einen Brueller (das Interface Uebung12Brueller)
	 */
	private static void gibLaut(Uebung12Brueller brueller)
	{
		System.out.println();
		System.out.println("brueller: " + brueller);
		brueller.bruellen();
	}


	private static void testMitInnererKlasse()
	{
		MyTools.uebOut("TestMitInnererKlasse", 3);


		/*
		 * da es kein Tier gibt, das den Brueller mit einem gruseligen
		 * Bruellen implementiert, und wir diese Ungeheuer nur einmal
		 * benoetigen, erzeugen wir uns ein GruseligesUngeheuer in einer
		 * inneren Klasse.
		 */
		class GruseligesUngeheuer implements Uebung12Brueller
		{
			@Override
			public void bruellen()
			{
				System.out.println("uuuuuaaaaaahhhhhhhhhhhhhhh");
			}
		}

		GruseligesUngeheuer gruseligesUngeheuer = new GruseligesUngeheuer();

		gibLaut(gruseligesUngeheuer);
	}


	private static void testMitAnonymerInnererKlasse()
	{
		MyTools.uebOut("TestMitAnonymerInnererKlasse", 3);

		/*
		 * anonyme innere Klasse benutzen.
		 */
		Uebung12Brueller gruseligesUngeheuer = new Uebung12Brueller()
		{
			@Override
			public void bruellen()
			{
				System.out.println("ich bin das gruseliges Ungeheuer");
				System.out.println(
						"iiiiiiiuuuuuaaaaaahhhhhhhhhhhhhhhooooooooo");
			}
		};

		gibLaut(gruseligesUngeheuer);
	}


	public static void main(String[] args)
	{
		testMitInnererKlasse();
		testMitAnonymerInnererKlasse();
	}



}
