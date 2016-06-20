package ch.jkurs.uebungen08;

import ch.java_akademie.tools.MyTools;

/**
 * Uebung08c.
 * 
 * Erfassen von Messwerten <br>
 * unsortiert ausgeben <br>
 * sortieren (Bubblesort) <br>
 * sortiert ausgeben
 * 
 * @author johann
 */
public class Uebung08c
{

	static int[] messwerte = new int[5];


	public static void main(String[] args)
	{
		messwerteEingeben();
		messwerteAusgeben("unsortiert");
		sortieren();
		messwerteAusgeben("sortiert");
	}


	static void messwerteAusgeben(String text)
	{
		System.out.println(text);

		for (int i = 0; i < messwerte.length; i++)
		{
			System.out.println(messwerte[i]);
		}
	}


	static void messwerteEingeben()
	{
		for (int i = 0; i < messwerte.length; i++)
		{
			messwerte[i] = MyTools. // getRandom(1, 2500);
					getInteger("bitte messwert eingben > ");
		}
	}


	static void sortieren()
	{
		for (int i = 0; i < messwerte.length - 1; i++)
		{
			for (int j = i + 1; j < messwerte.length; j++)
			{
				if (messwerte[i] > messwerte[j])
				{
					// vertauschen
					int zw = messwerte[i];
					messwerte[i] = messwerte[j];
					messwerte[j] = zw;
				}
			}
		}
	}
}
