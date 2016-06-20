package ch.jkurs.a05_personenverwaltung;

import ch.java_akademie.tools.MyTools;

public class PersonenVerwaltung
{
	private static PersonenArray pa;


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


	public static void main(String[] args)
	{
		pa = new PersonenArray("temp/adressen2.txt");

		vorlauf();
		hptvera();
		nachlauf();
	}


	private static void nachlauf()
	{
		pa.abspeichern();
		stoppMeldung();
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
				pa.erfassen();
				break;
			case 2:
				pa.anzeigen();
				break;
			case 3:
				pa.sortieren();
				break;
			case 4:
				pa.loeschen();
				break;
			case 5:
				pa.abspeichern();
				break;
			case 6:
				hilfe();
				break;
		}
	}


	private static void vorlauf()
	{
		startMeldung();
		pa.einlesen();
	}
}
