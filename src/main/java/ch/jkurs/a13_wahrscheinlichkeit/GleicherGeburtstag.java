package ch.jkurs.a13_wahrscheinlichkeit;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import ch.jmildner.tools.DateTimeTools;
import ch.jmildner.tools.MyTools;

public class GleicherGeburtstag
{
	final static int MAX_DURCHLAEUFE = 100000;
	final static int MAX_SCHUELER = 28;
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

		double ps = 1.0;

		for (int i = 0; i < MAX_SCHUELER; i++)
		{
			double t = TAGE - i;
			ps *= t / TAGE;
		}

		System.out.printf("Gegenwahrscheinlichkeit dass keiner am selben Tag Geburtstag hat: %f %n",
				1 - ps);
	}


	private static void empirisch() throws Exception
	{
		MyTools.uebOut("Empirisch", 2);

		int gesamt = 0;
		int klassen = 0;

		for (int i = 1; i <= MAX_DURCHLAEUFE; i++)
		{
			int gleiche = doit(MAX_SCHUELER, JAHR);
			gesamt += doit(MAX_SCHUELER, JAHR);
			klassen += gleiche == 0 ? 0 : 1;
		}

		System.out.printf("Durchschnitt Anzahl Schueler mit doppelten Geburtstagen: %6.1f %n",
				(double) gesamt / MAX_DURCHLAEUFE);
		System.out.printf("Durchschnitt Anzahl Klassen  mit doppelten Geburtstagen: %8.3f %n",
				(double) klassen / MAX_DURCHLAEUFE);
	}


	private static int doit(final int MAX_SCHUELER, final int JAHR) throws Exception
	{
		Date[] d = new Date[MAX_SCHUELER];

		for (int i = 0; i < MAX_SCHUELER; i++)
		{
			d[i] = DateTimeTools.makeRandomDate(JAHR);
		}

		// es gibt jetzt MAX Daten
		// die werden in ein Set gestellt
		// ist das Set kleiner MAX gibt es doppelte Geburtstage

		Set<Date> verschiedeneGeburtstage = new HashSet<Date>();

		for (int i = 0; i < MAX_SCHUELER; i++)
		{
			verschiedeneGeburtstage.add(d[i]);
		}

		int gleich = MAX_SCHUELER - verschiedeneGeburtstage.size();

		// System.out.printf("gleiche Geburtstage: %d %n", gleich);

		return gleich;
	}

}
