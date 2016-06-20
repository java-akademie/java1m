package ch.jkurs.a03_primzahl;

public class PrimzahlA
{
	public static boolean isPrim(int x)
	{
		if (x < 2)
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
		final int MIN = 1;
		final int MAX = 1000;
		int z1 = 0;

		System.out.println("Primzahlen");

		for (int x = MIN; x < MAX; x++)
		{
			if (isPrim(x))
			{
				// System.out.println(x + "  ");
				z1++;
			}
		}

		System.out.printf(
				"zwischen %d und %d gibt es %d Primzahlen. \n",
				MIN, MAX, z1);
	}
}
