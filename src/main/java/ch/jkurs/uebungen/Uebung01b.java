package ch.jkurs.uebungen;

import ch.jmildner.tools.MyTools;

/**
 * zwei Zahlen mittels MyTools.getInteger() einlesen und die
 * Grundrechnungsarten durchfuehren
 */
public class Uebung01b
{
	public static void main(String[] args)
	{
		int a = MyTools.getInteger("bitte erste  Zahl eingeben > ");
		int b = MyTools.getInteger("bitte zweite Zahl eingeben > ");

		System.out.println((a + b));
		System.out.println((a - b));
		System.out.println((a * b));
		System.out.println((a / b));
		System.out.println((a % b));
	}
}
