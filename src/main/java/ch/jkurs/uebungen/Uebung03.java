package ch.jkurs.uebungen;

import ch.java_akademie.tools.MyTools;

/**
 * Uebung 3a, 3b und 3c unter Zuhilfenahme von Methoden
 */
public class Uebung03
{

	public static void main(String[] args)
	{
		test1();
		test2();
		test3();
	}


	private static void test1()
	{
		for (int i = 12; i <= 88; i++)
		{
			if (i % 2 == 0)
			{
				System.out.println(i + " ");
			}
		}
	}


	private static void test2()
	{
		for (int i = 312; i <= 637; i++)
		{
			if (i % 17 == 0)
			{
				System.out.println(i + " ");
			}
		}
	}


	private static void test3()
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
