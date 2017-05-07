package ch.java_akademie.sonstiges;

import ch.java_akademie.tools.MyTools;

public class Limes
{


	public static void main(String[] args)
	{
		limes();
		limesA();
		limesB();
		limesC();
		limesD();
		limesE();
		limesF();
		limesG();
		limesH();
		limes5();
	}


	private static void limes5()
	{
		double x = 1;
		x -= 0.000_000_000_001;
		double z = 1 - x;
		double n = 1 - Math.pow(x, 0.5);
		double erg = z / n;
		System.out.printf("%f / %f = %f %n", z, n, erg);
	}


	private static void limesH()
	{
		double x = 1;
		x -= 0.000_000_000_001;
		double z = (Math.pow(x, 4) - 1);
		double n = x - 1;
		double erg = z / n;
		System.out.printf("%f / %f = %f %n", z, n, erg);
	}


	private static void limesG()
	{
		double x = Math.pow(10, 100);
		double z = (Math.pow(x, 2));
		double n = (Math.pow(x, 2) - 4 * x + 1);
		double erg = z / n;
		System.out.printf("%e / %e = %f %n", z, n, erg);
	}


	private static void limesF()
	{
		double x = 0;
		x -= 0.000_000_000_001;
		double z = (Math.pow(1 + x, 0.5) - 1);
		double n = x;
		double erg = z / n;
		System.out.printf("%f / %f = %f %n", z, n, erg);
	}


	private static void limesE()
	{
		double x = Math.pow(10, 100);
		// x-= 0.000_000_000_001;
		double z = (Math.pow(x, 3) - 2 * x + 3);
		double n = (4 * x - 8);
		double erg = z / n;
		System.out.printf("%e / %e = %e %n", z, n, erg);
	}


	private static void limesD()
	{
		double x = 2;
		x -= 0.000_000_000_001;
		double z = (x - 2) * (3 * x + 1);
		double n = (4 * x - 8);
		double erg = z / n;
		System.out.printf("%f / %f = %f %n", z, n, erg);
	}


	private static void limesC()
	{
		double x = 0;
		x -= 0.000_000_000_001;
		double z = Math.sin(2 * x);
		double n = Math.sin(x);
		double erg = z / n;
		System.out.printf("%f / %f = %f %n", z, n, erg);
	}


	private static void limesB()
	{
		double x = -3;
		x -= 0.000_000_000_001;
		double z = (pow(x, 2) - x - 12);
		double n = x + 3;
		double erg = z / n;
		System.out.println(erg);
	}


	private static void limesA()
	{
		double x = 1;
		double z = (pow(x, 2) - 1);
		double n = (pow(x, 2) + 1);
		double erg = z / n;
		System.out.println(erg);
	}


	private static double pow(double x, double ex)
	{
		return Math.pow(x, ex);
	}


	static void limes()
	{
		MyTools.uebOut("Limes1", 3);


		// x2 - 4
		// ------ Lim x->2
		// x - 2

		for (int i = 1; i <= 100; i++)
			limes(i);


		System.out.println("");
	}


	private static void limes(double x)
	{
		System.out.println(x);
		limes(x - 0.000_000_000_001, x);
		limes(x + 0.000_000_000_001, x);
		limes(x - 0.000_001, x);
		limes(x + 0.000_001, x);
	}


	private static void limes(double a, double x)
	{
		double z = a * a - x * x;
		double n = a - x;
		double erg = z / n;

		System.out.printf("-  %+12f / %+12f = %+14.8f  %n", z, n, erg);
	}



}
