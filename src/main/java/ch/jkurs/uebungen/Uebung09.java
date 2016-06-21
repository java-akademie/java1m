package ch.jkurs.uebungen;

import ch.java_akademie.tools.MyTools;
import ch.java_akademie.tools.TextFile;

public class Uebung09
{
	public static void main(String[] args) throws Exception
	{
		TextFile tf;
		String s;

		tf = new TextFile("texte.txt", 'o');
		s = MyTools
				.getString("bitte Text eingeben (mit $$$ beenden) > ");
		while (!s.equals("$$$"))
		{
			tf.printLine(s);
			s = MyTools
					.getString("bitte Text eingeben (mit $$$ beenden) > ");
		}
		tf.close();

		tf = new TextFile("texte.txt", 'i');
		s = tf.readLine();
		while (s != null)
		{
			System.out.println(s);
			s = tf.readLine();
		}
		tf.close();

	}

}
