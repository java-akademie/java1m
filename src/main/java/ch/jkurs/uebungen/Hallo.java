package ch.jkurs.uebungen;

import ch.jmildner.tools.MyTools;

public class Hallo
{
	public static void main(String[] args)
	{
		String name = MyTools
				.getString("bitte Ihren Namen eingeben > ");
		System.out.println("hallo " + name);
	}
}
