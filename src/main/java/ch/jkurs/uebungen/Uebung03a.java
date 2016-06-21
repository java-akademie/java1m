package ch.jkurs.uebungen;

/**
 * alle geraden Zahlen zwischen 12 und 88 ausgeben
 */
public class Uebung03a
{
	public static void main(String[] args)
	{
		for (int i = 12; i <= 88; i++)
		{
			if (i % 2 == 0)
			{
				System.out.println(i);
			}
		}
	}
}
