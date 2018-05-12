package ch.jkurs.uebungen;

import ch.jmildner.tools.MyTools;

/**
 * wie Kreisprogramm Uebung04a <br/>
 * allerdings mit Wiederholungen
 */
public class Uebung04b
{
	public static void main(String[] args)
	{
		// erstlesen
		double r = holeRadius();

		while (r > 0)
		{
			double f = r * r * Math.PI;
			double u = 2 * r * Math.PI;

			System.out.println("flaeche = " + f);
			System.out.println("umfang  = " + u);

			// nachlesen
			r = holeRadius();
		}
	}


	private static double holeRadius()
	{
		return MyTools.getDouble("radius > ");
	}

}
