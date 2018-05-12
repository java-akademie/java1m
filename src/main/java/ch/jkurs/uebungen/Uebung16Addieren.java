package ch.jkurs.uebungen;

import ch.jmildner.tools.MyTools;

public class Uebung16Addieren
{
	interface Addieren {
		int add(int a, int b);
	}



	public static void main(String[] args)
	{
		MyTools.uebOut("test1", 3);
		Addieren add = (int a, int b) -> {return a + b;} ;
		int summe = add.add(5, 6);
		System.out.println(summe);
	}
}


