package ch.jkurs.uebungen09;

import java.io.FileNotFoundException;

import ch.java_akademie.tools.MyTools;
import ch.java_akademie.tools.TextFile;

public class Uebung09a
{
	private static TextFile tf;


	private static void closeFile()
	{
		tf.close();
	}


	private static void hptvera()
	{
		String s;

		s = MyTools.getString("bitte eine Zeile eingeben (ende=$) > ");

		while (!s.equals("$"))
		{
			tf.printLine(s);
			s = MyTools
					.getString("bitte eine Zeile eingeben (ende=$) > ");
		}
	}


	public static void main(String[] args) throws FileNotFoundException
	{
		vorlauf();
		hptvera();
		nachlauf();
	}


	private static void nachlauf()
	{
		closeFile();
		stoppMeldung();
	}


	private static void openFile() throws FileNotFoundException
	{
		tf = new TextFile("daten.txt", 'o');
	}


	private static void startmeldung()
	{
		System.out.println("start uebung9a");
	}


	private static void stoppMeldung()
	{
		System.out.println("stopp uebung9a");
	}


	private static void vorlauf() throws FileNotFoundException
	{
		startmeldung();
		openFile();
	}
}
