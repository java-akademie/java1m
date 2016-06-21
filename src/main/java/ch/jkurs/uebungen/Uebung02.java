package ch.jkurs.uebungen;

/**
 * Uebung 2a, 2b, 2c, 2d unter Zuhilfenahme von Methoden
 */
public class Uebung02
{

	public static void main(String[] args)
	{
		test1();
		test2();
		test3();
		test4();
	}


	private static void test1()
	{
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
	}


	private static void test2()
	{
		System.out.println(5);
		System.out.println(4);
		System.out.println(3);
		System.out.println(2);
		System.out.println(1);
	}


	private static void test3()
	{
		for (int i = 1; i <= 100; i++)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}


	private static void test4()
	{
		for (int i = 100; i >= 1; i--)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
