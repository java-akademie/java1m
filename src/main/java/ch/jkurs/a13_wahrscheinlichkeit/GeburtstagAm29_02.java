package ch.jkurs.a13_wahrscheinlichkeit;



import java.util.Date;

import ch.jmb.tools.DateTimeTools;
import ch.jmb.tools.MyTools;

public class GeburtstagAm29_02
{
	final static int MAX_PERSONEN = 1000000;
	final static int JAHR = 2001;
	final static int TAGE = 365;


	public static void main(String[] args) throws Exception
	{
		empirisch();
		mathematisch();
	}


	private static void mathematisch() throws Exception
	{
		MyTools.uebOut("Mathematisch", 2);
		double guenstig = 1, moeglich = TAGE;
		double w = guenstig / moeglich;

		System.out.printf(
				"Wahrscheinlichkeit dass der Geburtstag an einem bestimmten Tag ist: %f %n", w);
	}


	private static void empirisch() throws Exception
	{
		MyTools.uebOut("Empirisch", 2);

		Date bestimmterTag = DateTimeTools.makeRandomDate(JAHR);

		int anzahl = 0;

		for (int i = 1; i <= MAX_PERSONEN; i++)
		{
			Date d = DateTimeTools.makeRandomDate(JAHR);
			if (d.equals(bestimmterTag))
				anzahl++;
		}

		System.out.printf("Anzahl von %,d Geburtstagen am %s  ist  %d  %n", MAX_PERSONEN,
				bestimmterTag, anzahl);
		System.out.printf("Durchschnitt %f %n", (double) anzahl / MAX_PERSONEN);
	}

}
