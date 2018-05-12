package ch.jkurs.a16_lotto;

import java.util.Set;
import java.util.TreeSet;

import ch.jmildner.tools.MyTools;

public class Lottomat
{
	static final int MAX_TIPPS =6;
	static final int MAX_GEWINNZAHL = 45;


	public static void main(String[] args)
	{
		String uberschrift = String.format(
				"Lotto %d aus %d (MAX_GEWINNZAHL sollte auf 45 oder 42 gesetzt werden)",
				MAX_TIPPS, MAX_GEWINNZAHL);

		MyTools.uebOut(uberschrift, 2);

		System.out.println();

		int[] tipp = getZiehung();

		System.out.printf("getippte Zahlen [%s] %n", zeige(tipp));

		//MyTools.pause("\nHit Enter to Start\n");

		int ziehungen = 0;
		while (true)
		{
			ziehungen++;
			int[] ziehung = getZiehung();

			int rang = getRang(tipp, ziehung);

			if (rang > 5)
			{
				System.out.printf(
						"%,11d. ziehung - rang %d - Gewinnzahlen [%s] %n",
						ziehungen, rang, zeige(ziehung));
				zeige(ziehung);
			}

			if (rang == 6)
				 break;
		}
	}


	private static String zeige(int[] ia)
	{
		String z = "";
		for (int i = 0; i < ia.length; i++)
		{
			z += String.format(" %2d ", ia[i] + 1);
		}


		return z;
	}


	private static int getRang(int[] tipp, int[] ziehung)
	{
		int[] gesZiehung = new int[MAX_GEWINNZAHL];
		int[] gesTipp = new int[MAX_GEWINNZAHL];

		for (int i = 0; i < MAX_TIPPS; i++)
		{
			gesZiehung[ziehung[i]]++;
			gesTipp[tipp[i]]++;
		}

		int rang = 0;

		for (int i = 0; i < MAX_GEWINNZAHL; i++)
		{
			if (gesTipp[i] + gesZiehung[i] == 2)
				rang++;
		}
		// System.out.println(Arrays.toString(gesZiehung));
		// System.out.println(Arrays.toString(gesTipp));

		return rang;
	}


	@SuppressWarnings("unused")
	private static int[] getTipp()
	{
		int[] tipp = new int[MAX_TIPPS];

		for (int i = 0; i < MAX_TIPPS; i++)
		{
			tipp[i] = -1;
		}

		for (int i = 0; i < MAX_TIPPS; i++)
		{
			while (true)
			{
				int zahl = 0;

				zahl = MyTools.getInteger("bitte einen Tipp abgeben > ",
						1, MAX_GEWINNZAHL) - 1;

				boolean zahlVorhanden = false;

				for (int j = 0; j < MAX_TIPPS; j++)
				{
					if (tipp[j] == zahl)
					{
						zahlVorhanden = true;
						System.out
								.println("doppelte sind nicht erlaubt");
						break;
					}
				}

				if (!zahlVorhanden)
				{
					tipp[i] = zahl;
					break;
				}
			}
		}

		return tipp;
	}


	private static int[] getZiehung()
	{

		Set<Integer> set = new TreeSet<Integer>();

		while (set.size() < MAX_TIPPS)
		{
			set.add(MyTools.getRandom(1, MAX_GEWINNZAHL)-1);
		}

		int[] ziehung = new int[MAX_TIPPS];
		int index = 0;
		for (Integer i : set)
			ziehung[index++] = i;
		
		return ziehung;
	}


	 static int[] getZiehung_old()
	{
		int[] ziehung = new int[MAX_TIPPS];

		for (int i = 0; i < MAX_TIPPS; i++)
		{
			ziehung[i] = -1;
		}

		for (int i = 0; i < MAX_TIPPS; i++)
		{
			while (true)
			{
				int zahl = 0;

				zahl = MyTools.getRandom(1, MAX_GEWINNZAHL) - 1;

				boolean zahlVorhanden = false;

				for (int j = 0; j < MAX_TIPPS; j++)
				{
					if (ziehung[j] == zahl)
					{
						zahlVorhanden = true;
						break;
					}
				}

				if (!zahlVorhanden)
				{
					ziehung[i] = zahl;
					break;
				}
			}
		}
		return ziehung;
	}
}
