package ch.java_akademie.sonstiges;

import java.util.Arrays;

public class Limes
{
	private static void dreiecke()
	{
		System.out.printf("\n");
		System.out.printf("\nDREIECKE");
		System.out.printf("\n========");

		for (int a = 1; a <= 9; a++)
		{
			for (int b = 1; b <= 9; b++)
			{
				for (int c = 1; c <= 9; c++)
				{
					double s = (a + b + c) / 2.0;
					double flaeche = Math.sqrt(s * (s - a) * (s - b)
							* (s - c));
					if (!Double.isNaN(flaeche) && flaeche > 0.0)
					{
						double hc = (2 * flaeche) / c;
						double ha = (2 * flaeche) / a;
						double hb = (2 * flaeche) / b;
						String form = "\na=%d b=%d c=%d, flaeche=%7.3f ha=%7.4f hb=%7.4f hb=%7.4f";
						System.out.printf(form, a, b, c, flaeche, ha,
								hb, hc);
					}
				}
			}
		}

	}


	private static boolean isPrim(int z)
	{
		if (z == 1)
			return false;
		if (z == 2)
			return true;

		for (int i = 2; i < z; i++)
		{
			if (z % i == 0)
				return false;
		}

		return true;
	}


	public static void main(String[] args)
	{
		primzahlen();
		quadrate();
		rechtwinkeligeDreiecke();
		dreiecke();
		pythagoraeischeZahlen();
	}


	private static void pythagoraeischeZahlen() {
		System.out.println();
		for (int i = 1; i<=20; i++)
			for (int j=1; j<=20; j++)
			{
				if (i==j) break;
				int[] a={Math.abs(i*i - j*j),(i*i + j*j),2*i*j};
				Arrays.sort(a);
				System.out.print(Arrays.toString(a));
				System.out.println(a[0]*a[0]+a[1]*a[1]+"=="+(a[2]*a[2]));
			}
		
	}


	static void primzahlen()
	{
		System.out.printf("\n");
		System.out.printf("\nPRIMZAHLEN 2151-6400");
		System.out.printf("\n====================");

		int z = 0;

		for (int i = 2151; i < 6400; i++)
		{
			if (isPrim(i))
			{
				if (z++ % 10 == 0)
					System.out.println();
				System.out.printf("%7d ", i);
			}
		}
		System.out.println("");
	}


	private static void quadrate()
	{
		System.out.printf("\n");
		System.out.printf("\nQUADRATE 1-300");
		System.out.printf("\n==============");

		int z = 0;

		for (int i = 1; i <= 300; i++)
		{
			if (z++ % 6 == 0)
				System.out.println();
			System.out.printf("%4d=%,6d", i, i * i);
		}

		System.out.println("");
	}


	private static void rechtwinkeligeDreiecke()
	{
		System.out.printf("\n");
		System.out.printf("\nRECHTWINKELIGE DREIECKE");
		System.out.printf("\n=======================");

		int z = 0;

		for (int a = 1; a <= 100; a++)
		{
			for (int b = a + 1; b <= 100; b++)
			{
				int cq = a * a + b * b;
				double cd = Math.pow(cq, .5);
				int c = (int) cd;
				if (cd == c)
				{
					if (z++ % 3 == 0)
						System.out.println();

					System.out
							.printf("%3d + %3d = %3d       ", a, b, c);
				}
			}
		}

	}
}
