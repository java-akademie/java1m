package ch.jkurs.uebungen10;

import ch.java_akademie.tools.TextFile;

public class Uebung10c
{
	static TextFile tf;
	static String fn = "addr.txt";


	public static void main(String[] args) throws Exception
	{

		Person p1 = new Person(55, "hugo", "basel");
		Person p2 = new Person(12, "hans", "bern");
		Person p3 = new Person(88, "egon", "biel");

		tf = new TextFile(fn, 'o');
		tf.printLine(p1.toString());
		tf.printLine(p2.toString());
		tf.printLine(p3.toString());
		tf.close();

		tf = new TextFile(fn, 'i');

		String s = tf.readLine();

		while (s != null)
		{
			new Person(s).show();
			s = tf.readLine();
		}

		tf.close();
	}

}
