package ch.jkurs.a03_primzahl;

public class PrimzahlB
{
	public static boolean isPrim(int x)
	{
		if (x == 0 || x == 1)
		{
			return false;
		}

		if (x == 2)
		{
			return true;
		}

		int grenze = 1 + (int) Math.pow(x, 0.5);

		for (int i = 2; i < grenze; i++)
		{
			if (x % i == 0)
			{
				return false;
			}
		}

		return true;
	}


	public static void main(String[] args)
	{
		final int MIN = 100000000;
		final int MAX = MIN + 100000;
		@SuppressWarnings("unused")
		final int stellen = 5;

		int z1 = 0, z2 = 0;

		System.out.println("Primzahlpaare");

		int lastPrim = -1;

		for (int x = MIN; x < MAX; x++)
		{
			if (isPrim(x))
			{
				if (lastPrim + 2 == x)
				{
					z1++;

				//	String fd = "%" + stellen + "d";
					// System.out.printf(fd + "/" + fd + "\t",
					// lastPrim, x);
					//
					// if (z1 % 4 == 0)
					// System.out.println();
				}

				z2++;

				lastPrim = x;
			}
		}

		System.out
				.printf("zwischen %d und %d gibt es %d Primzahlen und %d Primzahlpaare.\n",
						MIN, MAX, z2, z1);
	}
}
