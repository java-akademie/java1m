package ch.jkurs.uebungen;

import ch.jmb.tools.MyTools;

/**
 * zwei Zahlen mittels MyTools.getInteger() einlesen und an der Konsole
 * wieder ausgeben
 */
public class Uebung01a
{
	public static void main(String[] args)
	{
		int a = MyTools.getInteger("bitte erste  Zahl eingeben > ");
		int b = MyTools.getInteger("bitte zweite Zahl eingeben > ");

		System.out.println(a);
		System.out.println(b);
	}
}
