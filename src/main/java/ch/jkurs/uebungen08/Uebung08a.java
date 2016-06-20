package ch.jkurs.uebungen08;


/**
 * Uebung08a.
 * 
 * Lottozahlen 1,2,3,4,5,6 in ein Array speichern und an der Konsole
 * wieder ausgeben
 */
public class Uebung08a
{

	public static void main(String[] args)
	{
		int[] lottozahlen = { 1, 2, 3, 4, 5, 6 };

		for (int i = 0; i < lottozahlen.length; i++)
		{
			System.out.println(lottozahlen[i]);
		}
		
		System.out.println("----");

		for (int i : lottozahlen)
		{
			System.out.println(i);
		}
	}
}
