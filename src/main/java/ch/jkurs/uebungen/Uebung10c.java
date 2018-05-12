package ch.jkurs.uebungen;

import ch.jmildner.tools.TextFile;

public class Uebung10c
{
	static TextFile tf;
	static String fn = "addr.txt";


	public static void main(String[] args) throws Exception
	{

		Uebung10Person p1 = new Uebung10Person(55, "hugo", "basel");
		Uebung10Person p2 = new Uebung10Person(12, "hans", "bern");
		Uebung10Person p3 = new Uebung10Person(88, "egon", "biel");

		tf = new TextFile(fn, 'o');
		tf.printLine(p1.toString());
		tf.printLine(p2.toString());
		tf.printLine(p3.toString());
		tf.close();

		tf = new TextFile(fn, 'i');

		String s = tf.readLine();

		while (s != null)
		{
			new Uebung10Person(s).show();
			s = tf.readLine();
		}

		tf.close();
	}

}
