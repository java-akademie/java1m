package ch.jkurs.a01_kryptarithmus;

import java.util.Arrays;

//---------------------------------------------
// programmname: Kryptarithmus
//
// autor: johann mildner, basel
//
// eve/div=.talktalktalk... periodisch
//
// Treffer: 242 / 303 = .7986798679867987
//---------------------------------------------

public class Kryptarithmus
{

	static boolean alleUnterschiedlich(int[] arr)
	{
		Arrays.sort(arr);

		int z = -1;

		for (int x : arr)
		{
			if (x == z)
			{
				return false;
			}
			else
			{
				z = x;
			}
		}
		return true;
	}


	static void berechnen(int e, int v, int d, int i)
	{
		int eve = e * 100 + v * 10 + e * 1;
		int did = d * 100 + i * 10 + d * 1;

		double ergebnis;

		if (eve > 0 && did > eve)// && teilerfremd(eve, did))
		{
			ergebnis = (double) eve / (double) did;

			ergebnis = ergebnis * 10000;
			int p1 = (int) ergebnis;
			ergebnis = ergebnis - p1;

			ergebnis = ergebnis * 10000;
			int p2 = (int) ergebnis;
			ergebnis = ergebnis - p2;

			ergebnis = ergebnis * 10000;
			int p3 = (int) ergebnis;
			ergebnis = ergebnis - p3;

			if (p1 == p2 & p2 == p3) // periodisch
			{
				int t, a, l, k;

				t = p1 / 1000;
				p1 = p1 - t * 1000;

				a = p1 / 100;
				p1 = p1 - a * 100;

				l = p1 / 10;
				p1 = p1 - l * 10;

				k = p1 / 1;
				p1 = p1 - k * 1;

				int x[] = { e, v, d, i, t, a, l, k };
				if (alleUnterschiedlich(x))
				{
					System.out.println("Treffer:");
					System.out.println(eve + "/" + did + "=." + p2);
				}
			}
		}
	}


	public static void main(String[] args)
	{
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println("Kryptarithmus:");
		System.out.println("eve/did=.talktalktalk...  periodisch");
		System.out.println();

		for (int e = 0; e <= 9; e++)
		{
			for (int v = 0; v <= 9; v++)
			{
				for (int d = 0; d <= 9; d++)
				{
					for (int i = 0; i <= 9; i++)
					{
						berechnen(e, v, d, i);
					}
				}
			}
		}

		System.out.println("-----------------------------------------");
		System.out.println();
	}


	static boolean teilerfremd(int eve, int did)
	{
		int g = eve, k = did;

		while (true)
		{
			if (g < k)
			{
				int zg = k, zk = g;
				g = zg;
				k = zk;
			}

			g = g - k;

			if (g == k) // groesster gemeinsamer teiler
			{
				if (g == 1)
					return true;
				else
					return false;
			}
		}
	}
}
