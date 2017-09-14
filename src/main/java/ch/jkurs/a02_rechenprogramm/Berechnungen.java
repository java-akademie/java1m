package ch.jkurs.a02_rechenprogramm;

import ch.jmb.tools.MyTools;

public class Berechnungen
{
	private static void hilfe()
	{
		System.out.println("");
		System.out.println("Funktion:");
		System.out.println("     0 = Programm beenden             ");
		System.out.println("     1 = kreis                        ");
		System.out.println("     2 = quadrat                      ");
		System.out.println("     3 = kugel (noch nicht realisiert)");
		System.out.println("     4 = hilfe                        ");
	}


	private static int holeFunktion()
	{
		System.out.println("");

		int i = MyTools.getInteger(
				"bitte geben Sie die Funktion ein (4=Hilfe) > ", 0, 4);

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


	private static void kreis()
	{
		System.out.println("");
		System.out.println("Kreisberechnung:");

		int radius = MyTools
				.getInteger("     bitte den Radius eingeben > ");

		double flaeche = radius * radius * 3.14159;
		double umfang = 2 * radius * 3.14159;

		System.out.println("" + "die Flaeche ist: " + flaeche
				+ ", der Umfang ist: " + umfang);
	}


	private static void kugel()
	{
		System.out.println("");
		System.out.println("Kugelberechnung:");
		System.out.println("diese Funktion ist noch nicht realisiert");
	}


	public static void main(String[] args)
	{
		vorlauf();
		hptvera();
		nachlauf();
	}


	private static void nachlauf()
	{
		stoppMeldung();
	}


	private static void quadrat()
	{
		System.out.println("");
		System.out.println("Quadratberechnung:");

		int laenge = MyTools
				.getInteger("     bitte die Laenge eingeben > ");
		int breite = MyTools
				.getInteger("     bitte die Breite eingeben > ");

		int flaeche = laenge * breite;
		int umfang = 2 * laenge + 2 * breite;

		System.out.println("" + "die Flaeche ist: " + flaeche
				+ ", der Umfang ist: " + umfang);

	}


	private static void startMeldung()
	{
		System.out.println("");
		System.out.println("");
		System.out.println("" + "------------------------------------"
				+ "------------------------------------");
		System.out.println("" + "Programm:     Berechnungen          "
				+ "               Autor: Johann Mildner");
		System.out.println("" + "Beschreibung: Ein Programm, das es d"
				+ "em Benutzer erm�glicht, verschiedene");
		System.out.println("" + "              Berechnungen durchzufu"
				+ "ehren.                             ");
		System.out.println("" + "------------------------------------"
				+ "------------------------------------");
	}


	private static void stoppMeldung()
	{
		System.out.println("");
		System.out.println("Auf Wiedersehen!");
		System.out.println("" + "------------------------------------"
				+ "------------------------------------");
		System.out.println("");
	}


	public static void vera(int funktion)
	{
		switch (funktion)
		{
			case 1:
				kreis();
				break;
			case 2:
				quadrat();
				break;
			case 3:
				kugel();
				break;
			case 4:
				hilfe();
				break;
			default:
				break;
		}
	}


	private static void vorlauf()
	{
		startMeldung();
	}
}
