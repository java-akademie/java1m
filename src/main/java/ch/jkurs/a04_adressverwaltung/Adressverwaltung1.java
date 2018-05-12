package ch.jkurs.a04_adressverwaltung;

import java.io.FileNotFoundException;

import ch.jmildner.tools.MyTools;
import ch.jmildner.tools.TextFile;

public class Adressverwaltung1
{
	static final String FILE_NAME = "temp/adressen1.txt";

	static final int[] id = new int[1000];
	static final String[] name = new String[1000];
	static final String[] addr = new String[1000];

	static int maxAdressen;


	private static void adresseErfassen()
	{
		id[maxAdressen] = MyTools.getInteger("    ID    > ", 1,
				2000000000);
		name[maxAdressen] = MyTools.getString("    Name  > ");
		addr[maxAdressen] = MyTools.getString("    Addr  > ");

		maxAdressen++;
	}


	private static void adresseLoeschen()
	{
		int zuLoeschendeId = MyTools
				.getInteger("    zu loeschende ID > ");

		int i = 0;

		for (i = 0; i < maxAdressen; i++)
		{
			if (id[i] == zuLoeschendeId)
			{
				break;
			}
		}

		if (i < maxAdressen)
		{
			id[i] = 2000000001;
			adressenSortieren();
			maxAdressen--;
		}

	}


	private static void adressenAbspeichern()
			throws FileNotFoundException
	{
		TextFile tf = new TextFile(FILE_NAME, 'o');

		for (int i = 0; i < maxAdressen; i++)
		{
			tf.printLine(id[i] + "");
			tf.printLine(name[i]);
			tf.printLine(addr[i]);
		}

		tf.close();
	}


	private static void adressenAnzeigen()
	{
		System.out.println("    Anzahl Adressen: " + maxAdressen);
		System.out.println();
		for (int i = 0; i < maxAdressen; i++)
		{
			System.out.println("       ID  : " + id[i]);
			System.out.println("       Name: " + name[i]);
			System.out.println("       Addr: " + addr[i]);
			System.out.println();
		}
	}


	private static void adressenEinlesen()
	{
		TextFile tf;
		try
		{
			tf = new TextFile(FILE_NAME, 'i');

			String idx = tf.readLine();

			while (idx != null)
			{
				id[maxAdressen] = Integer.parseInt(idx);
				name[maxAdressen] = tf.readLine();
				addr[maxAdressen] = tf.readLine();
				maxAdressen++;

				idx = tf.readLine();
			}
			tf.close();
		}
		catch (FileNotFoundException e)
		{
		}
	}


	private static void adressenSortieren()
	{
		for (int i = 0; i < maxAdressen - 1; i++)
		{
			for (int j = i; j < maxAdressen; j++)
			{
				if (id[i] > id[j])
				{
					// vertauschen
					int zwid = id[i];
					id[i] = id[j];
					id[j] = zwid;
					String zwname = name[i];
					name[i] = name[j];
					name[j] = zwname;
					String zwaddr = addr[i];
					addr[i] = addr[j];
					addr[j] = zwaddr;
				}
			}
		}
	}



	private static void hilfeAnzeigen()
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


	private static void hptvera() throws FileNotFoundException
	{
		hilfeAnzeigen();

		int funktion = holeFunktion();

		while (funktion != 0)
		{
			vera(funktion);
			funktion = holeFunktion();
		}
	}


	public static void main(String[] args) throws FileNotFoundException
	{
		vorlauf();
		hptvera();
		nachlauf();
	}


	private static void nachlauf() throws FileNotFoundException
	{
		adressenAbspeichern();
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


	private static void vera(int funktion) throws FileNotFoundException
	{
		switch (funktion)
		{
			case 1:
				adresseErfassen();
				break;
			case 2:
				adressenAnzeigen();
				break;
			case 3:
				adressenSortieren();
				break;
			case 4:
				adresseLoeschen();
				break;
			case 5:
				adressenAbspeichern();
				break;
			case 6:
				hilfeAnzeigen();
				break;
			default:
				break;
		}
	}


	private static void vorlauf()
	{
		startMeldung();
		adressenEinlesen();
	}
}
