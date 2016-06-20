package ch.jkurs.uebungen06;

import ch.java_akademie.tools.MyTools;

/**
 * Uebungen 6 - Algorithmen <br>
 * 6.1 int mult(int,int) - Multiplikation <br>
 * 6.2 int div (int,int) - Ganzzahldivision <br>
 * 6.3 int mod (int,int) - Modulo <br>
 * 6.4 int ggt (int,int) - groesster gemeinsamer Teiler <br>
 * 6.5 int kgv (int,int) - kleinstes gemeinsames Vielfache <br>
 * 6.6 int potenz (int,int) - Potenzieren <br>
 * 6.7 int wurzel (int,int) - Wurzelziehen <br>
 * 
 * @author Johann Mildner
 */
public class Uebung06
{

	public static void main(String[] args)
	{
		String nochmals;

		do
		{
			int a = MyTools.getInteger("bitte a eingeben > ");
			int b = MyTools.getInteger("bitte b eingeben > ");

			System.out.println("  mult = " + mult(a, b));
			System.out.println("   div = " + div(a, b));
			System.out.println("   mod = " + mod(a, b));
			System.out.println("   ggt = " + ggt(a, b));
			System.out.println("   kgv = " + kgv(a, b));

			double erg = potenz(a, b);
			System.out.println("pozenz = " + erg);
			System.out.println("wurzel = " + wurzel(erg, b));

			nochmals = MyTools.getString("\nnochmals j/n ? > ");
		}
		while (nochmals.equals("j") || nochmals.equals(""));

		System.out.println("\nProgrammende");
	}


	static int mult(int a, int b)
	{
		int erg = 0;

		while (b > 0)
		{
			erg += a;
			b--;
		}

		return erg;
	}


	static int div(int a, int b)
	{
		int erg = 0;

		while (a >= b)
		{
			erg++;
			a -= b;
		}

		return erg;
	}


	static int mod(int a, int b)
	{
		while (a >= b)
		{
			a -= b;
		}

		return a;
	}


	static int ggt(int a, int b)
	{
		do
		{
			if (a <= b)
			{
				int z = a;
				a = b;
				b = z;
			}

			a -= b;
		}
		while (a != b);

		return a;
	}


	static int kgv(int a, int b)
	{
		if (a <= b)
		{
			int z = a;
			a = b;
			b = z;
		}

		int m = a;

		while (mod(a, b) != 0)
		{
			a += m;
		}

		return a;
	}



	static double potenz(double a, int b)
	{
		double erg = 1;

		while (b > 0)
		{
			erg *= a;
			b--;
		}
		return erg;
	}


	static double wurzel(double a, int b)
	{
		double genauigkeit = 0.00001;
		double erg = 0;

		while (true)
		{
			erg += genauigkeit;
			if (a <= potenz(erg, b))
			{
				return erg;
			}
		}
	}
}
