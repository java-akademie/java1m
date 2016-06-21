package ch.jkurs.uebungen;

/**
 * alle durch 17 teilbaren Zahlen zwischen 312 und 637 ausgeben
 */
public class Uebung03b
{
	public static void main(String[] args)
	{
		for (int i = 312; i <= 637; i++)
		{
			if (i % 17 == 0)
			{
				System.out.println(i);
			}
		}
	}
}
