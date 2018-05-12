package ch.jkurs.a05_personenverwaltung;

import ch.jmildner.tools.MyTools;
import ch.jmildner.tools.TextFile;

public class Adressverwaltung2
{
	static final String FILE_NAME = "adressen2.txt";

	static Person[] person = new Person[1000];

	static int maxAdressen;


	private static void abspeichern()
	{
		TextFile outFile = null;

		try
		{
			outFile = new TextFile(FILE_NAME, 'o');

			for (int i = 0; i < maxAdressen; i++)
			{
				outFile.printLine(person[i].toString());
			}

			outFile.close();

			System.out.println("Adressarray wurde in die Datei '"
					+ FILE_NAME + "' geschrieben");
		}
		catch (Exception e)
		{
			System.out.println("Fehler bei adressenAbspeicher(): ");
			System.out.println("dieser Fehler duerfte nie passieren!!");
			e.printStackTrace();
		}
	}


	private static void anzeigen()
	{
		System.out.println("\n     Anzahl Adressen: " + maxAdressen);

		for (int i = 0; i < maxAdressen; i++)
		{
			person[i].show();
		}
	}


	private static void einlesen()
	{
		TextFile inFile = null;

		try
		{
			inFile = new TextFile(FILE_NAME, 'i');
		}
		catch (Exception e)
		{
			// kein adressdaten vorhanden
			return;
		}

		String s = inFile.readLine(); // erstlesen

		while (s != null)
		{
			person[maxAdressen++] = new Person(s);
			s = inFile.readLine(); // nachlesen
		}

		inFile.close();

		System.out.println("Adressarray wurde aus der Datei '"
				+ FILE_NAME + "' gefuellt");
	}


	private static void erfassen()
	{
		Person p = new Person();

		if (personVorhanden(p))
		{
			System.out.println("Person schon vorhanden ... ");
		}
		else
		{
			person[maxAdressen++] = p;
		}
	}


	private static void hilfe()
	{
		System.out.println("");
		System.out.println("Funktion:");
		System.out.println("     0 = Programm beenden      ");
		System.out.println("     1 = erfassen              ");
		System.out.println("     2 = anzeigen              ");
		System.out.println("     3 = sortieren             ");
		System.out.println("     4 = loeschen              ");
		System.out.println("     5 = abspeichern           ");
		System.out.println("     6 = anzeigen der Hilfe    ");
	}


	private static int holeFunktion()
	{
		System.out.println("");

		int i = MyTools.getInteger(
				"bitte geben Sie die Funktion ein (6=Hilfe) > ", 0, 6);

		return i;
	}


	private static void hptvera()
	{
		hilfe();

		int funktion = holeFunktion();

		while (funktion != 0)
		{
			vera(funktion);
			funktion = holeFunktion();
		}
	}


	private static void loeschen()
	{
		if (maxAdressen == 0)
		{
			System.out.println("es sind keine Adressen vorhanden ...");
			return;
		}

		int zwId = MyTools.getInteger("     ID   > ");

		// ID suchen
		int i;
		for (i = 0; i < maxAdressen; i++)
		{
			if (zwId == person[i].getId())
			{
				break;
			}
		}

		if (i == maxAdressen)
		{
			System.out.println("ID nicht vorhanden ...");
			return;
		}

		person[i] = person[--maxAdressen];
		sortieren();

		System.out.println("Adresse wurde aus Array entfernt");
	}


	public static void main(String[] args)
	{
		vorlauf();
		hptvera();
		nachlauf();
	}


	private static void nachlauf()
	{
		abspeichern();
		stoppMeldung();
	}


	private static boolean personVorhanden(Person p)
	{
		for (int i = 0; i < maxAdressen; i++)
		{
			if (person[i].getId() == p.getId())
			{
				return true;
			}
		}
		return false;
	}


	private static void sortieren()
	{
		for (int i = 0; i < maxAdressen - 1; i++)
		{
			for (int j = i + 1; j < maxAdressen; j++)
			{
				if (person[i].getId() > person[j].getId())
				{
					Person zw = person[i];
					person[i] = person[j];
					person[j] = zw;
				}
			}
		}

		System.out.println("Adressarray wurde sortiert");
	}


	private static void startMeldung()
	{
		System.out.println("");
		System.out.println("");
		System.out.println("----------------------------------------"
				+ "-------------------------");
		System.out.println("Programm    : AdressVerwaltung.java     "
				+ "   Autor: Johann Mildner ");
		System.out.println("Beschreibung: Dieses Programm dient der "
				+ "Pflege einer Adressdatei ");
		System.out.println("----------------------------------------"
				+ "-------------------------");
	}


	private static void stoppMeldung()
	{
		System.out.println("");
		System.out.println("Auf Wiedersehen!");
		System.out.println("----------------------------------------"
				+ "-------------------------");
		System.out.println("");
	}


	private static void vera(int funktion)
	{
		switch (funktion)
		{
			case 1:
				erfassen();
				break;
			case 2:
				anzeigen();
				break;
			case 3:
				sortieren();
				break;
			case 4:
				loeschen();
				break;
			case 5:
				abspeichern();
				break;
			case 6:
				hilfe();
				break;
			default:
				break;
		}
	}


	private static void vorlauf()
	{
		startMeldung();
		einlesen();
	}
}
