package ch.jkurs.uebungen;

import java.io.FileNotFoundException;

import ch.jmildner.tools.TextFile;

public class Uebung09b
{
	private static TextFile tf;


	private static void closeFile()
	{
		tf.close();
	}


	private static void hptvera()
	{
		String s;

		s = tf.readLine();

		while (s != null)
		{
			System.out.println(s);
			s = tf.readLine();
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
		tf = new TextFile("daten.txt", 'i');
	}


	private static void startmeldung()
	{
		System.out.println("start uebung9b");
	}


	private static void stoppMeldung()
	{
		System.out.println("stopp uebung9b");
	}


	private static void vorlauf() throws FileNotFoundException
	{
		startmeldung();
		openFile();
	}

}
