package ch.jkurs.uebungen;

import ch.jmb.tools.MyTools;

/**
 * Alle durch 'teiler' teilbaren Zahlen zwischen 'start' und 'stopp' and
 * der Konsole ausgeben
 * 
 * teiler, start und stopp sollen ueber die Tastatur eingegeben werden
 */
public class Uebung03c
{

	public static void main(String[] args)
	{
		int start = MyTools.getInteger("startwert > ");
		int stopp = MyTools.getInteger("stoppwert > ");
		int teiler = MyTools.getInteger("teiler    > ");

		for (int i = start; i <= stopp; i++)
		{
			if (i % teiler == 0)
			{
				System.out.println(i + " ");
			}
		}
	}

}
