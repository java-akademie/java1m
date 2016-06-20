package ch.jkurs.uebungen08;


/**
 * Uebung08b.
 * 
 * 10 Namen in ein Array speichern und an der Konsole wieder ausgeben
 */
public class Uebung08b
{

	public static void main(String[] args)
	{
		String[] namen = { "hans", "franz", "urs", "moritz", "fritz",
				"max", "gerd", "anna", "ida", "leo" };

		for (int i = 0; i < namen.length; i++)
		{
			System.out.println(namen[i]);
		}

		System.out.println("----");

		for (String n : namen)
		{
			System.out.println(n);
		}
	}
}
